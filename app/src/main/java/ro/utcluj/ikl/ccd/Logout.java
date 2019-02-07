package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class Logout {

    @SerializedName("params")
    private String[] mParams;

    public String[] getmParams() {
        return mParams;
    }

    public void setmParams(String[] mParams) {
        this.mParams = mParams;
    }
}
