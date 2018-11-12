package where.example.com.popbus.Retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Antoun on 8/2/2018.
 */

public class Pop {

    @SerializedName("name")
    public String name;

    @SerializedName("email")
    public String email;

    @SerializedName("phone")
    public String phone;

    @SerializedName("password")
    public String password;

}
