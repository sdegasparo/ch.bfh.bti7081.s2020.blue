package ch.bfh.bti7081.s2020.blue.presenter;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import ch.bfh.bti7081.s2020.blue.domain.dto.RegisterDto;
import ch.bfh.bti7081.s2020.blue.domain.dto.ValidationError;
import ch.bfh.bti7081.s2020.blue.service.RegistrationService;
import ch.bfh.bti7081.s2020.blue.util.BeanInjector;
import ch.bfh.bti7081.s2020.blue.view.authentication.RegistrationView;
import java.util.Collections;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class RegisterPresenterTest {

  private RegisterDto registerDto;
  private RegistrationView registrationView;
  private BeanInjector injectorMock;
  private RegistrationService registrationServiceMock;

  private RegistrationPresenter presenter;

  @BeforeEach
  public void setUp() {
    registerDto = mock(RegisterDto.class);
    registrationView = mock(RegistrationView.class);
    injectorMock = mock(BeanInjector.class);
    registrationServiceMock = mock(RegistrationService.class);

    when(injectorMock.get(RegistrationService.class)).thenReturn(registrationServiceMock);
    presenter = new RegistrationPresenter(registerDto, registrationView, injectorMock);
  }

  @Test
  public void saveButtonClickSuccessTest() {

    // When the registration service does not return any errors.
    when(registrationServiceMock.register(any())).thenReturn(Collections.emptyList());

    presenter.saveButtonClick();

    // navigate to /login has to be called.
    verify(registrationView).navigate("login");

  }

  @Test
  public void saveButtonClickErrorTest() {

    // When the registration service return errors.
    when(registrationServiceMock.register(any())).thenReturn(
        Lists.list(new ValidationError("Error one."), new ValidationError("Error two."))
    );

    presenter.saveButtonClick();

    // show message with the concatenated errors should be called
    verify(registrationView).showMessage("Error one. Error two.");

  }
}
