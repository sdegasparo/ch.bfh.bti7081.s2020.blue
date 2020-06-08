package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

  private static final Log log = LogFactory.getLog(RegistrationService.class);

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  private final LoginCrudRepository loginCrudRepository;

  public RegistrationService(LoginCrudRepository loginCrudRepository) {
    this.loginCrudRepository = loginCrudRepository;
  }

  public Collection<ValidationError> register(RegisterDto registerDto) {
    Set<ConstraintViolation<RegisterDto>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(registerDto);
    List<ValidationError> validationErrors = violations.stream()
        .map(violation -> new ValidationError(String.format("%s: %s", violation.getPropertyPath(), violation.getMessage())))
        .collect(Collectors.toList());

    if (!isUsernameUnique(registerDto.getUsername())) {
      validationErrors.add(new ValidationError("Username is already in use."));
    }
    if (!isEmailUnique(registerDto.getEmail())) {
      validationErrors.add(new ValidationError("E-Mail address is already in use."));
    }
    if (!registerDto.getPassword().equals(registerDto.getRepeatPassword())) {
      validationErrors.add(new ValidationError("Passwords did not match."));
    }

    if (validationErrors.isEmpty()) {
      String encodedPassword = passwordEncoder.encode(registerDto.getPassword());
      Patient patient = Patient.builder()
          .givenName(registerDto.getGivenName())
          .surname(registerDto.getGivenName())
          .build();

      Login login = Login.builder()
          .username(registerDto.getUsername())
          .email(registerDto.getEmail())
          .password(encodedPassword)
          .isEnabled(true)
          .isBlocked(false)
          .patient(patient)
          .build();

      patient.setLogin(login);
      loginCrudRepository.save(login);
    } else {
      log.info(String.format("Could not register '%s' [%s] due to %s",
          registerDto.getUsername(),
          registerDto.getEmail(),
          validationErrors.stream()
              .map(ValidationError::getMessage)
              .collect(Collectors.joining(", "))));
    }

    return validationErrors;
  }

  public boolean isUsernameUnique(String username) {
    return loginCrudRepository.findById(username).isEmpty();
  }

  public boolean isEmailUnique(String email) {
    return loginCrudRepository.findByEmail(email).isEmpty();
  }
}
