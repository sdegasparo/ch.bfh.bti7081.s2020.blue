package ch.bfh.bti7081.s2020.blue.presenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import ch.bfh.bti7081.s2020.blue.domain.dto.UserDetailsDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.UserDetailsService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RegisterPresenterUnitTest {

  @Mock
  private UserDetailsDto userDetailsDtoMock;

  @Mock
  private RegistrationView registrationViewMock;

  @Mock
  private BeanInjector beanInjectorMock;

  @Mock
  private UserDetailsService userDetailsServiceMock;

  private RegistrationPresenter fixture;

  @Before
  public void beforeTestSetup() {
    doReturn(userDetailsServiceMock)
        .when(beanInjectorMock)
        .get(UserDetailsService.class);

    fixture = new RegistrationPresenter(userDetailsDtoMock, registrationViewMock, beanInjectorMock);
  }

  @Test
  public void saveButtonClickNavigatesToLogin() {
    // When the registration service does not return any errors.
    doReturn(Collections.emptyList())
        .when(userDetailsServiceMock)
        .register(any());

    fixture.saveButtonClick();

    // navigate to /login has to be called.
    verify(registrationViewMock).navigateToLogin();
  }

  @Test
  public void saveButtonClickTriggersErrorMessage() {
    // When the registration service return errors.
    doReturn(List.of(new ValidationError("Error one."), new ValidationError("Error two.")))
        .when(userDetailsServiceMock)
        .register(any());

    fixture.saveButtonClick();

    // show message with the concatenated errors should be called
    verify(registrationViewMock).showMessage("Error one. Error two.");
  }
}
