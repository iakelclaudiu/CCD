package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class LoginBoddy<T> {

    @SerializedName("jsonrpc")
    private String mJsonPrc="2.0";

    @SerializedName("method")
    private String mMethod;

    @SerializedName("params")
    private T mParams;

    @SerializedName("id")
    private int mId=1;

    @SerializedName("auth")
    private String mAuth=null;

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

    public T getmParams() {
        return mParams;
    }

    public void setmParams(T mParams) {
        this.mParams = mParams;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmAuth() {
        return mAuth;
    }

    public void setmAuth(String mAuth) {
        this.mAuth = mAuth;
    }
}
