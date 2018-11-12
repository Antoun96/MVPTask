package where.example.com.popbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import where.example.com.popbus.Login.LoginInteractor;
import where.example.com.popbus.Login.LoginPresenter;
import where.example.com.popbus.Login.LoginView;

public class LoginFragment extends Fragment implements LoginView {
    public LoginFragment() {

    }

    private EditText mEmailView;
    private EditText mPasswordView;
    private LoginPresenter presenter;
    User user = new User();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        mEmailView = (EditText) rootView.findViewById(R.id.email);
        mPasswordView = (EditText) rootView.findViewById(R.id.password);
        ImageView mEmailSignInButton = (ImageView) rootView.findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.email = mEmailView.getText().toString();
                user.password = mPasswordView.getText().toString();
                validateCredentials(user);
            }
        });

        presenter = new LoginPresenter (this , new LoginInteractor());

        return rootView;
    }
    private void validateCredentials(User user) {
        presenter.validateCredentials(user);
    }

    @Override
    public void setPasswordError() {
        mPasswordView.setError(getString(R.string.error_invalid_password));
    }

    @Override
    public void setEmailEmpty() {
        mEmailView.setError(getString(R.string.error_field_required));
    }

    @Override
    public void setEmailError() {
        mEmailView.setError(getString(R.string.error_invalid_email));
    }

    @Override
    public void setSuccessfulLogin() {
        Toast.makeText(getActivity().getApplicationContext(), "Login Done Successfully",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setResponse(String msg) {
        Toast.makeText(getActivity().getApplicationContext(), msg,
                Toast.LENGTH_SHORT).show();
    }

}

