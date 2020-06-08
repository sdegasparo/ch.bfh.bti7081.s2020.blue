package ch.bfh.bti7081.s2020.blue.service;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.domain.repository.CurrentLoginRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService {

  private static final Log log = LogFactory.getLog(UserDetailsService.class);

  public static final String PASSWORDS_DID_NOT_MATCH = "Passwords did not match.";
  public static final String E_MAIL_ADDRESS_IS_ALREADY_IN_USE = "E-Mail address is already in use.";
  public static final String USERNAME_IS_ALREADY_IN_USE = "Username is already in use.";

  private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

  private final LoginCrudRepository loginCrudRepository;
  private final CurrentLoginRepository currentLoginRepository;

  public UserDetailsService(LoginCrudRepository loginCrudRepository, CurrentLoginRepository currentLoginRepository) {
    this.loginCrudRepository = loginCrudRepository;
    this.currentLoginRepository = currentLoginRepository;
  }

  private List<ValidationError> validateUserDetailsDto(UserDetailsDto userDetailsDto) {
    Set<ConstraintViolation<UserDetailsDto>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(userDetailsDto);
    List<ValidationError> validationErrors = violations.stream()
        .map(violation -> new ValidationError(String.format("%s: %s", violation.getPropertyPath(), violation.getMessage())))
        .collect(Collectors.toList());

    if (!isEmailUnique(userDetailsDto.getEmail())) {
      validationErrors.add(new ValidationError(E_MAIL_ADDRESS_IS_ALREADY_IN_USE));
    }

    if (!userDetailsDto.getPassword().equals(userDetailsDto.getRepeatPassword())) {
      validationErrors.add(new ValidationError(PASSWORDS_DID_NOT_MATCH));
    }

    return validationErrors;
  }

  private UserDetailsDto mapLoginToUserDetailsDto(Login login) {
    return UserDetailsDto.builder()
        .email(login.getEmail())
        .givenName(login.getPatient().getGivenName())
        .surname(login.getPatient().getSurname())
        .username(login.getUsername())
        .build();
  }

  public List<ValidationError> register(UserDetailsDto userDetailsDto) {
    List<ValidationError> validationErrors = validateUserDetailsDto(userDetailsDto);

    // Username is checked separately because it must not be unique when updating a user.
    if (!isUsernameUnique(userDetailsDto.getUsername())) {
      validationErrors.add(new ValidationError(USERNAME_IS_ALREADY_IN_USE));
    }

    if (validationErrors.isEmpty()) {
      String encodedPassword = passwordEncoder.encode(userDetailsDto.getPassword());
      Patient patient = Patient.builder()
          .givenName(userDetailsDto.getGivenName())
          .surname(userDetailsDto.getGivenName())
          .build();

      Login login = Login.builder()
          .username(userDetailsDto.getUsername())
          .email(userDetailsDto.getEmail())
          .password(encodedPassword)
          .isEnabled(true)
          .isBlocked(false)
          .patient(patient)
          .build();

      patient.setLogin(login);

      loginCrudRepository.save(login);
    } else {
      log.info(
          String.format("Could not register '%s' [%s] due to %s",
              userDetailsDto.getUsername(),
              userDetailsDto.getEmail(),
              validationErrors.stream()
                  .map(ValidationError::getMessage)
                  .collect(Collectors.joining(", "))));
    }

    return validationErrors;
  }

  // Only the username is taken from the Security Context. As other user details might change.
  public Optional<UserDetailsDto> getCurrentUserDetails() {
    Optional<String> username = currentLoginRepository.getCurrentLogin().map(Login::getUsername);
    Optional<Login> login = username.flatMap(loginCrudRepository::findById);

    return login.map(this::mapLoginToUserDetailsDto);
  }


  public Collection<ValidationError> updateCurrentUserDetails(UserDetailsDto userDetails) {
    List<ValidationError> validationErrors = new ArrayList<>();
    // Override Username with Security context to prevent modification of other users data.
    String username = currentLoginRepository.getCurrentLogin()
        .map(Login::getUsername)
        .orElseThrow(() -> new IllegalArgumentException("User not authenticated!"));
    Login login = loginCrudRepository.findById(username)
        .orElseThrow(() -> new IllegalArgumentException("Invalid authentication object!"));

    userDetails.setUsername(login.getUsername());
    login.getPatient().setGivenName(userDetails.getGivenName());
    login.getPatient().setSurname(userDetails.getSurname());

    if (userDetails.getEmail() != null && !userDetails.getEmail().isEmpty()) {
      if (!userDetails.getEmail().equals(login.getEmail()) && !isEmailUnique(userDetails.getEmail())) {
        validationErrors.add(new ValidationError(E_MAIL_ADDRESS_IS_ALREADY_IN_USE));
      } else {
        login.setEmail(userDetails.getEmail());
      }
    }

    if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
      if (!userDetails.getPassword().equals(userDetails.getRepeatPassword())) {
        validationErrors.add(new ValidationError(PASSWORDS_DID_NOT_MATCH));
      } else {
        login.setPassword(passwordEncoder.encode(userDetails.getPassword()));
      }
    }

    if (validationErrors.isEmpty()) {
      loginCrudRepository.save(login);
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
