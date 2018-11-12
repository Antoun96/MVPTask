package where.example.com.popbus.Retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Antoun on 8/4/2018.
 */

public class TokenResponse {

    @SerializedName("statusCode")
    public int statusCode;

    @SerializedName("message")
    public String message;

    @SerializedName("errors")
    public Errors errors;
    public class Errors
    {
        @SerializedName("email")
        public List<String> email = null;
    }
}
