package ch.bfh.bti7081.s2020.blue.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

import ch.bfh.bti7081.s2020.blue.domain.Login;
import ch.bfh.bti7081.s2020.blue.domain.repository.LoginCrudRepository;
import java.util.Optional;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class DatabaseUserDetailsServiceUnitTest {

  @Rule
  public final ExpectedException expectedException = ExpectedException.none();

  @Mock
  LoginCrudRepository loginCrudRepositoryMock;

  DatabaseUserDetailsService fixture;

  @Before
  public void beforeTestSetup() {
    fixture = new DatabaseUserDetailsService(loginCrudRepositoryMock);
  }

  @Test
  public void loadUserByUsernameReturnsUserDetails() {
    final String username = "username";

    Login login = new Login(username, null, null);

    doReturn(Optional.of(login))
        .when(loginCrudRepositoryMock)
        .findById(username);

    UserDetails userDetails = fixture.loadUserByUsername(username);
    assertThat(userDetails)
        .hasFieldOrPropertyWithValue("username", username);
  }

  @Test
  public void loadUserByUsernameThrowsUsernameNotFoundException() {
    doReturn(Optional.empty())
        .when(loginCrudRepositoryMock)
        .findById(anyString());

    expectedException.expect(UsernameNotFoundException.class);
    expectedException.expectMessage("User not found.");
    fixture.loadUserByUsername("username");
  }
}
