package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class ListRequestParams {

    @SerializedName("output")
    private String mOutput;

    @SerializedName("selectAcknowledges")
    private String mselectAcknowledges;

    @SerializedName("recent")
    private String mRecent;

    @SerializedName("sortfield")
    private String[] mSortedField;

    @SerializedName("sortorder")
    private String mSortOrder;

    public String getmOutput() {
        return mOutput;
    }

    public void setmOutput(String mOutput) {
        this.mOutput = mOutput;
    }

    public String getmselectAcknowledges() {
        return mselectAcknowledges;
    }

    public void setmselectAcknowledges(String mTimeFrom) {
        this.mselectAcknowledges = mTimeFrom;
    }

    public String getmRecent() {
        return mRecent;
    }

    public void setmRecent(String mRecent) {
        this.mRecent = mRecent;
    }

    public String[] getmSortedField() {
        return mSortedField;
    }

    public void setmSortedField(String[] mSortedField) {
        this.mSortedField = mSortedField;
    }

    public String getmSortOrder() {
        return mSortOrder;
    }

    public void setmSortOrder(String mSortOrder) {
        this.mSortOrder = mSortOrder;
    }
}
