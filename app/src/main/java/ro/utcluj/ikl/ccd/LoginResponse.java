package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    private String mResult;

    String getResult(){
        return mResult;
    }
}
