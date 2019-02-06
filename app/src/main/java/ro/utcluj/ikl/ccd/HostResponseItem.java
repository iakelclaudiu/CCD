package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class HostResponseItem {

    @SerializedName("hostid")
    private String mHostid;

    @SerializedName("host")
    private String mHost;

    @SerializedName("status")
    private String mStatus;

    @SerializedName("snmp_available")
    private String mSnmp_av;

    @SerializedName("snmp_error")
    private String mSnmp_err;

    public String getmHostid() {
        return mHostid;
    }

    public void setmHostid(String mHostid) {
        this.mHostid = mHostid;
    }

    public String getmHost() {
        return mHost;
    }

    public void setmHost(String mHost) {
        this.mHost = mHost;
    }

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getmSnmp_av() {
        return mSnmp_av;
    }

    public void setmSnmp_av(String mSnmp_av) {
        this.mSnmp_av = mSnmp_av;
    }

    public String getmSnmp_err() {
        return mSnmp_err;
    }

    public void setmSnmp_err(String mSnmp_err) {
        this.mSnmp_err = mSnmp_err;
    }
}
