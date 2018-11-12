package where.example.com.popbus.Retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Antoun on 8/2/2018.
 */

public interface PopInterface {

    @POST("auth/register")
    @FormUrlEncoded
    Call<TokenResponse> getTokenAccess(@Field("name") String name,
                       @Field("email") String email,
                       @Field("phone") String phone,
                       @Field("password") String password);


    @POST("auth/login")
    @FormUrlEncoded
    Call<TokenResponse> LoginResponse(@Field("email") String email,
                                       @Field("password") String password);

}
