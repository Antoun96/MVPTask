package where.example.com.popbus.Registration;

import where.example.com.popbus.User;

/**
 * Created by Antoun on 8/3/2018.
 */

public class RegistrationPresenter implements RegistrationInteractor.OnRegisterFinishedListener{

    private RegistrationView registrationView;
    private RegistrationInteractor registrationInteractor;

    public RegistrationPresenter(RegistrationView registrationView, RegistrationInteractor registrationInteractor) {
        this.registrationView = registrationView;
        this.registrationInteractor = registrationInteractor;
    }

    public void validateCredentials(User user) {

        registrationInteractor.register( user ,  this);
    }

    @Override
    public void onUsernameEmpty() {
        if (registrationView!=null){
            registrationView.setUsernameEmpty();
        }
    }

    @Override
    public void onPasswordError() {
        if (registrationView != null) {
            registrationView.setPasswordError();
        }
    }

    @Override
    public void onEmailEmpty() {
        if (registrationView != null) {
            registrationView.setEmailEmpty();

        }
    }

    @Override
    public void onPhoneEmpty() {
        if (registrationView != null){
            registrationView.setPhoneEmpty();
        }
    }

    @Override
    public void onConfirmPasswordError() {
        if (registrationView != null){
            registrationView.setConfirmPasswrodError();
        }
    }

    @Override
    public void onEmailError(){
        if (registrationView != null){
            registrationView.setEmailError();
        }
    }

    @Override
    public void onSuccess() {
            if (registrationView != null){
                registrationView.setSuccessfulRegistration();
            }

    }

    @Override
    public void onValidationError(String msg) {
        if (registrationView != null){
            registrationView.setRegistrationError(msg);
        }
    }
}
