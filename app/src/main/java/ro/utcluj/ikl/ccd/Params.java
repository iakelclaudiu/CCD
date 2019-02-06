package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class Params {

    @SerializedName("user")
    private String mUser;

    @SerializedName("password")
    private String mPassword;


    public String getmUser() {
        return mUser;
    }

    public void setmUser(String mUser) {
        this.mUser = mUser;
    }

    public String getmPassword() {
        return mPassword;
    }

    public void setmPassword(String mPassword) {
        this.mPassword = mPassword;
    }
}
