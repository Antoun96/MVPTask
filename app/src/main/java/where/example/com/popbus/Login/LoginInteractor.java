package where.example.com.popbus.Login;

import android.text.TextUtils;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import where.example.com.popbus.Retrofit.PopClient;
import where.example.com.popbus.Retrofit.PopInterface;
import where.example.com.popbus.Retrofit.TokenResponse;
import where.example.com.popbus.User;

/**
 * Created by Antoun on 8/4/2018.
 */

public class LoginInteractor {

    PopInterface popInterface;

    interface OnLoginFinishedListener {
        void onPasswordError();

        void onEmailEmpty();

        void onEmailError();

        void onSuccess();

        void onResponseMsg(String msg);
    }

    private boolean isPasswordValid(String password) {
        if (password.length() > 5)
        {
            return true;
        }
        else{
            return false;
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public void login(final User user, final LoginInteractor.OnLoginFinishedListener listener) {

        if (TextUtils.isEmpty(user.email)) {
            listener.onEmailEmpty();
            return;
        }
        if (!isEmailValid(user.email)) {
            listener.onEmailError();
            return;
        }
        if (TextUtils.isEmpty(user.password) || !isPasswordValid(user.password)) {
            listener.onPasswordError();
            return;
        }
        popInterface = PopClient.getClient().create(PopInterface.class);
        //Log.i("Retrofit 1" , "entered retrofit");
        final Call<TokenResponse> tokenResponseCall =  popInterface.LoginResponse(user.email,user.password);
       // Log.i("Retrofit 2" , "entered retrofit");
        tokenResponseCall.enqueue(new Callback<TokenResponse>() {
            @Override
            public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
                int status_code = response.code();
        //        Log.i("StatusCode" , Integer.toString(status_code));
                TokenResponse tokenResponse = response.body();
                if(tokenResponse.statusCode == 200) {
                    listener.onSuccess();
                }
                else {
                    listener.onResponseMsg(tokenResponse.message);
                }

            }

            @Override
            public void onFailure(Call<TokenResponse> call, Throwable t) {
                Log.i("Retrofit 3" , t.getMessage());
            }
        });


    }
}
