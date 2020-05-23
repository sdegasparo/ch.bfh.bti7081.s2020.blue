package ch.bfh.bti7081.s2020.blue.presenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.RegistrationService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class RegisterPresenterUnitTest {

  @Mock
  private RegisterDto registerDtoMock;

  @Mock
  private RegistrationView registrationViewMock;

  @Mock
  private BeanInjector beanInjectorMock;

  @Mock
  private RegistrationService registrationServiceMock;

  private RegistrationPresenter fixture;

  @Before
  public void beforeTestSetup() {
    doReturn(registrationServiceMock)
        .when(beanInjectorMock)
        .get(RegistrationService.class);

    fixture = new RegistrationPresenter(registerDtoMock, registrationViewMock, beanInjectorMock);
  }

  @Test
  public void saveButtonClickNavigatesToLogin() {
    // When the registration service does not return any errors.
    doReturn(Collections.emptyList())
        .when(registrationServiceMock)
        .register(any());

    fixture.saveButtonClick();

    // navigate to /login has to be called.
    verify(registrationViewMock).navigate("login");
  }

  @Test
  public void saveButtonClickTriggersErrorMessage() {
    // When the registration service return errors.
    doReturn(List.of(new ValidationError("Error one."), new ValidationError("Error two.")))
        .when(registrationServiceMock)
        .register(any());

    fixture.saveButtonClick();

    // show message with the concatenated errors should be called
    verify(registrationViewMock).showMessage("Error one. Error two.");
  }
}
