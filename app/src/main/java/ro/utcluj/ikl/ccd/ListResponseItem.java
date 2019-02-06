package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class ListResponseItem {

    @SerializedName("eventid")
    private String mEventId;

    @SerializedName("source")
    private String mSource;

    @SerializedName("object")
    private String mObject;

    @SerializedName("objectid")
    private String mObjectId;

    @SerializedName("clock")
    private String mClock;

    @SerializedName("ns")
    private String mNs;

    @SerializedName("r_eventid")
    private String mR_eventit;

    @SerializedName("r_clock")
    private String mR_clock;

    @SerializedName("r_ns")
    private String mR_ns;

    @SerializedName("correlationid")
    private String mCorrelationid;

    @SerializedName("userid")
    private String mUserid;

    @SerializedName("name")
    private String mName;

    @SerializedName("acknowledged")
    private String mAcknowledged;

    @SerializedName("severity")
    private String mSeverity;

    @SerializedName("suppressed")
    private int mSuppressed;

    public String getmEventId() {
        return mEventId;
    }

    public void setmEventId(String mEventId) {
        this.mEventId = mEventId;
    }

    public String getmSource() {
        return mSource;
    }

    public void setmSource(String mSource) {
        this.mSource = mSource;
    }

    public String getmObject() {
        return mObject;
    }

    public void setmObject(String mObject) {
        this.mObject = mObject;
    }

    public String getmObjectId() {
        return mObjectId;
    }

    public void setmObjectId(String mObjectId) {
        this.mObjectId = mObjectId;
    }

    public String getmClock() {
        return mClock;
    }

    public void setmClock(String mClock) {
        this.mClock = mClock;
    }

    public String getmNs() {
        return mNs;
    }

    public void setmNs(String mNs) {
        this.mNs = mNs;
    }

    public String getmR_eventit() {
        return mR_eventit;
    }

    public void setmR_eventit(String mR_eventit) {
        this.mR_eventit = mR_eventit;
    }

    public String getmR_clock() {
        return mR_clock;
    }

    public void setmR_clock(String mR_clock) {
        this.mR_clock = mR_clock;
    }

    public String getmR_ns() {
        return mR_ns;
    }

    public void setmR_ns(String mR_ns) {
        this.mR_ns = mR_ns;
    }

    public String getmCorrelationid() {
        return mCorrelationid;
    }

    public void setmCorrelationid(String mCorrelationid) {
        this.mCorrelationid = mCorrelationid;
    }

    public String getmUserid() {
        return mUserid;
    }

    public void setmUserid(String mUserid) {
        this.mUserid = mUserid;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAcknowledged() {
        return mAcknowledged;
    }

    public void setmAcknowledged(String mAcknowledged) {
        this.mAcknowledged = mAcknowledged;
    }

    public String getmSeverity() {
        return mSeverity;
    }

    public void setmSeverity(String mSeverity) {
        this.mSeverity = mSeverity;
    }

    public int getmSuppressed() {
        return mSuppressed;
    }

    public void setmSuppressed(int mSuppressed) {
        this.mSuppressed = mSuppressed;
    }
}
