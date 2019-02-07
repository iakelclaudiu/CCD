package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class LogoutResponse {
    @SerializedName("result")
    private String mResult;

    String getResult(){
        return mResult;
    }
}
