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

    @SerializedName("value")
    private String mValue;

    @SerializedName("acknowledged")
    private String mAcknowledged;

    @SerializedName("ns")
    private String mNs;

    @SerializedName("name")
    private String mName;

    @SerializedName("severity")
    private String mSeverity;

    @SerializedName("r_eventid")
    private String mREventId;

    @SerializedName("c_eventid")
    private String mCEventId;

    @SerializedName("correlationid")
    private String mCorrelationId;

    @SerializedName("userid")
    private String mUserId;

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

    public String getmValue() {
        return mValue;
    }

    public void setmValue(String mValue) {
        this.mValue = mValue;
    }

    public String getmAcknowledged() {
        return mAcknowledged;
    }

    public void setmAcknowledged(String mAcknowledged) {
        this.mAcknowledged = mAcknowledged;
    }

    public String getmNs() {
        return mNs;
    }

    public void setmNs(String mNs) {
        this.mNs = mNs;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmSeverity() {
        return mSeverity;
    }

    public void setmSeverity(String mSeverity) {
        this.mSeverity = mSeverity;
    }

    public String getmREventId() {
        return mREventId;
    }

    public void setmREventId(String mREventId) {
        this.mREventId = mREventId;
    }

    public String getmCEventId() {
        return mCEventId;
    }

    public void setmCEventId(String mCEventId) {
        this.mCEventId = mCEventId;
    }

    public String getmCorrelationId() {
        return mCorrelationId;
    }

    public void setmCorrelationId(String mCorrelationId) {
        this.mCorrelationId = mCorrelationId;
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public int getmSuppressed() {
        return mSuppressed;
    }

    public void setmSuppressed(int mSuppressed) {
        this.mSuppressed = mSuppressed;
    }
}
