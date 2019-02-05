package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class LoginBoddy {

    @SerializedName("jsonrpc")
    private String mJsonPrc="2.0";

    @SerializedName("method")
    private String mMethod="user.login";

    @SerializedName("params")
    private Params mParams;

    @SerializedName("id")
    private String mId;

    @SerializedName("auth")
    private String mAuth="null";

    public String getmJsonPrc() {
        return mJsonPrc;
    }

    public void setmJsonPrc(String mJsonPrc) {
        this.mJsonPrc = mJsonPrc;
    }

    public String getmMethod() {
        return mMethod;
    }

    public void setmMethod(String mMethod) {
        this.mMethod = mMethod;
    }

    public Params getmParams() {
        return mParams;
    }

    public void setmParams(Params mParams) {
        this.mParams = mParams;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmAuth() {
        return mAuth;
    }

    public void setmAuth(String mAuth) {
        this.mAuth = mAuth;
    }
}
