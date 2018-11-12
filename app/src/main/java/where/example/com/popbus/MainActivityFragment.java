package where.example.com.popbus;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import where.example.com.popbus.Registration.RegistrationInteractor;
import where.example.com.popbus.Registration.RegistrationPresenter;
import where.example.com.popbus.Registration.RegistrationView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements RegistrationView {

    public MainActivityFragment() {
    }

    EditText name , phone , email , password , confirm_password ;
    ImageView register_btn;
    User user = new User();
    private RegistrationPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_main, container, false);

        // MainActivity Fragment is the signup page
        name = (EditText)rootview.findViewById(R.id.name);
        email = (EditText)rootview.findViewById(R.id.email);
        phone = (EditText)rootview.findViewById(R.id.mobile);
        password = (EditText)rootview.findViewById(R.id.password);
        confirm_password = (EditText)rootview.findViewById(R.id.confirm_password);
        register_btn = (ImageView) rootview.findViewById(R.id.register_btn);

        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.name = name.getText().toString();
                user.email = email.getText().toString();
                user.Phone = phone.getText().toString();
                user.password = password.getText().toString();
                user.confirm_password = confirm_password.getText().toString();
                Log.i("password" , user.password);
                // send the user object to presenter which gone send to the Model
                validateCredentials(user);
            }
        });

        //:et Presenter know its model and its view
        presenter = new RegistrationPresenter (this , new RegistrationInteractor());

        return rootview;
    }

    private void validateCredentials(User user) {
        presenter.validateCredentials(user);
    }

    @Override
    public void setUsernameEmpty() {
        name.setError(getString(R.string.error_field_required));
    }

    @Override
    public void setPasswordError() {
        password.setError(getString(R.string.error_invalid_password));
    }

    @Override
    public void setEmailEmpty() {
        email.setError(getString(R.string.error_field_required));

    }

    @Override
    public void setEmailError() {
        email.setError(getString(R.string.error_invalid_email));

    }

    @Override
    public void setPhoneEmpty() {
        phone.setError(getString(R.string.error_field_required));
    }

    @Override
    public void setConfirmPasswrodError() {
        confirm_password.setError("Not Matched to Password");
    }

    @Override
    public void setSuccessfulRegistration() {
        Toast.makeText(getActivity().getApplicationContext(), "Registered Successfully",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setRegistrationError(String msg) {
        Toast.makeText(getActivity().getApplicationContext(), msg.toString(),
                Toast.LENGTH_SHORT).show();
    }
}
