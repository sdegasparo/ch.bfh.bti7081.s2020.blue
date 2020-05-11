package ch.bfh.bti7081.s2020.blue.domain;

import java.util.ArrayList;
import java.util.Collection;
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
    var validationErrors = new ArrayList<ValidationError>();
    try {
      if (loginRepository.findById(registerDto.getUsername()).isPresent()) {
        validationErrors.add(new ValidationError("Username is already in use."));
      }
      if (loginRepository.findByEmail(registerDto.getEmail()).isPresent()) {
        validationErrors.add(new ValidationError("E-Mail address is already in use."));
      }
      if (!registerDto.getPassword().equals(registerDto.getRepeatPassword())) {
        System.out.println(registerDto.getPassword());
        System.out.println(registerDto.getRepeatPassword());
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
      }
    } catch (Exception e) {
      log.error(e);
      validationErrors.add(new ValidationError("An error occurred"));
    }

    return validationErrors;
  }
}
