package where.example.com.popbus.Login;

import where.example.com.popbus.User;

/**
 * Created by Antoun on 8/4/2018.
 */

public class LoginPresenter implements LoginInteractor.OnLoginFinishedListener {

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
        this.loginView = loginView;
        this.loginInteractor = loginInteractor;
    }

    public void validateCredentials(User user) {

        loginInteractor.login( user ,  this);
    }

    @Override
    public void onPasswordError() {
        if (loginView != null) {
            loginView.setPasswordError();
        }
    }

    @Override
    public void onEmailEmpty() {
        if (loginView != null) {
            loginView.setEmailEmpty();

        }
    }

    @Override
    public void onEmailError() {
        if (loginView != null){
            loginView.setEmailError();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView != null){
            loginView.setSuccessfulLogin();
        }
    }

    @Override
    public void onResponseMsg(String msg) {
        if (loginView != null){
            loginView.setResponse(msg);
        }
    }


}
