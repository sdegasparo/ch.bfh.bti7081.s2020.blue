package ch.bfh.bti7081.s2020.blue.domain;

import java.util.Collection;
import java.util.stream.Collectors;
import javax.validation.Validation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class RegisterService {

  private final LoginRepository loginRepository;
  private final PatientRepository patientRepository;

  public RegisterService(
      @Autowired LoginRepository loginRepository,
      @Autowired PatientRepository patientRepository) {
    this.loginRepository = loginRepository;
    this.patientRepository = patientRepository;

  }

  public Collection<ValidationError> register(RegisterDto registerDto) {
    var violations = Validation.buildDefaultValidatorFactory().getValidator().validate(registerDto);
    var validationErrors = violations.stream()
        .map(violation -> new ValidationError(
            String.format("%s: %s", violation.getPropertyPath(), violation.getMessage())))
        .collect(Collectors.toList());

    try {
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
        var password = new BCryptPasswordEncoder().encode(registerDto.getPassword());
        var patient = Patient.builder()
            .givenName(registerDto.getGivenName())
            .surname(registerDto.getGivenName())
            .build();

        var login = Login.builder()
            .username(registerDto.getUsername())
            .email(registerDto.getEmail())
            .password(password)
            .isEnabled(true)
            .isBlocked(false)
            .patient(patient)
            .build();

        patient.setLogin(login);
        loginRepository.save(login);
      } else {
        log.info(String.format("Could not register '%s' [%s] due to %s", registerDto.getUsername(),
            registerDto.getEmail(),
            validationErrors.stream().map(ValidationError::getMessage)
                .collect(Collectors.joining(", "))));

      }
    } catch (Exception e) {
      log.error(String.format("Error registering user '%s' [%s]: ", registerDto.getUsername(),
          registerDto.getEmail()), e);
      validationErrors.add(new ValidationError("An error occurred."));
    }

    return validationErrors;
  }

  public boolean isUsernameUnique(String username) {
    return loginRepository.findById(username).isEmpty();
  }

  public boolean isEmailUnique(String email) {
    return loginRepository.findByEmail(email).isEmpty();
  }
}
