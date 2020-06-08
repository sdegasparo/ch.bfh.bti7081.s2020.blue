package ch.bfh.bti7081.s2020.blue.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.domain.Patient;
import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.domain.repository.CurrentLoginRepository;
import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import java.util.Collection;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceTest {

  @Mock
  LoginCrudRepository loginCrudRepositoryMock;

  @Mock
  CurrentLoginRepository currentLoginRepository;

  UserDetailsService fixture;

  @Before
  public void beforeTestSetup() {
    Patient patient = Patient.builder()
        .surname("Tester")
        .givenName("Bester")
        .build();

    Login login = Login.builder()
        .username("testuser1")
        .email("test@test.local")
        .isBlocked(false)
        .isEnabled(true)
        .password(null)
        .patient(patient)
        .build();

    doReturn(Optional.ofNullable(login))
        .when(loginCrudRepositoryMock)
        .findById("testuser1");

    doReturn(Optional.ofNullable(login))
        .when(currentLoginRepository)
        .getCurrentLogin();

    fixture = new UserDetailsService(loginCrudRepositoryMock, currentLoginRepository);
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
