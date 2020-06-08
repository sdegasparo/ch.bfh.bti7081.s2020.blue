package ch.bfh.bti7081.s2020.blue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.domain.repository.CurrentLoginRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.PatientCrudRepository;
import java.util.Collection;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;


public class UserDetailsServiceTest {

  UserDetailsService fixture;
  LoginCrudRepository loginCrudRepositoryMock;

  @Mock
  PatientCrudRepository patientCrudRepository;

  CurrentLoginRepository currentLoginRepository;

  @Before
  public void beforeTestSetup() {


    Login login = new Login();
    login.setUsername("testuser1");
    login.setEmail("test@test.local");
    login.setIsBlocked(false);
    login.setIsEnabled(true);
    login.setPassword(null);
    Patient patient = new Patient();
    patient.setSurname("Tester");
    patient.setGivenName("Bester");
    login.setPatient(patient);

    currentLoginRepository = mock(CurrentLoginRepository.class);
    loginCrudRepositoryMock = mock(LoginCrudRepository.class);
    when(loginCrudRepositoryMock.findById("testuser1")).thenReturn(Optional.ofNullable(login));
    when(loginCrudRepositoryMock.findByEmail("test@test.local")).thenReturn(Optional.ofNullable(login));

    when(currentLoginRepository.getCurrentLogin()).thenReturn(Optional.ofNullable(login));

    fixture = new UserDetailsService(loginCrudRepositoryMock, patientCrudRepository, currentLoginRepository);
  }

  @Test
  public void shouldNotSaveIfPasswordsDoNotMatch() {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setPassword("TestPassword1");
    dto.setRepeatPassword("TestPassword2");

    Collection<ValidationError> validationErrors = fixture.updateCurrentUserDetails(dto);

    assertFalse(validationErrors.isEmpty());
    verify(loginCrudRepositoryMock, never()).save(any());
  }

  @Test
  public void shouldNotModifyPasswordIfEmpty() {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setPassword("");

    Collection<ValidationError> validationErrors = fixture.updateCurrentUserDetails(dto);

    ArgumentCaptor<Login> argument = ArgumentCaptor.forClass(Login.class);
    verify(loginCrudRepositoryMock).save(argument.capture());

    assertEquals(null, argument.getValue().getPassword());
  }

  @Test
  public void shouldNotModifyPasswordIfNull() {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setPassword(null);

    Collection<ValidationError> validationErrors = fixture.updateCurrentUserDetails(dto);

    ArgumentCaptor<Login> argument = ArgumentCaptor.forClass(Login.class);
    verify(loginCrudRepositoryMock).save(argument.capture());

    assertEquals(null, argument.getValue().getPassword());
  }


  @Test
  public void shouldCallSave() {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setUsername("peter");

    Collection<ValidationError> validationErrors = fixture.updateCurrentUserDetails(dto);

    ArgumentCaptor<Login> argument = ArgumentCaptor.forClass(Login.class);
    verify(loginCrudRepositoryMock).save(argument.capture());

    assertEquals(null, argument.getValue().getPassword());
  }

  @Test
  public void shouldOverrideUsernameWithCurrent() {
    UserDetailsDto dto = new UserDetailsDto();
    dto.setUsername("peter");

    Collection<ValidationError> validationErrors = fixture.updateCurrentUserDetails(dto);

    ArgumentCaptor<Login> argument = ArgumentCaptor.forClass(Login.class);
    verify(loginCrudRepositoryMock).save(argument.capture());

    assertEquals("testuser1", argument.getValue().getUsername());
  }
}
