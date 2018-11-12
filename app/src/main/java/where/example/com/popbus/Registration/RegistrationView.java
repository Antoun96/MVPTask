package where.example.com.popbus.Registration;

/**
 * Created by Antoun on 8/2/2018.
 */

public interface RegistrationView {

    void setUsernameEmpty();

    void setPasswordError();

    void setEmailEmpty();

    void setEmailError(); // email input validation

    void setPhoneEmpty();

    void setConfirmPasswrodError();

    void setSuccessfulRegistration();

    void setRegistrationError(String msg);
}
