package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("result")
    String mResult;

    String getResult(){
        return mResult;
    }
}
