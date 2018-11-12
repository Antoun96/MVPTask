package where.example.com.popbus.Login;

/**
 * Created by Antoun on 8/4/2018.
 */

public interface LoginView {

    void setPasswordError();

    void setEmailEmpty();

    void setEmailError();

    void setSuccessfulLogin();

    void setResponse(String msg);
}
