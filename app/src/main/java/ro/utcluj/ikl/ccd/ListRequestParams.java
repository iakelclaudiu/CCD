package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class ListRequestParams {

    @SerializedName("output")
    private String mOutput;

    @SerializedName("time_from")
    private String mTimeFrom;

    @SerializedName("time_till")
    private String mTimeTo;

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

    public String getmTimeFrom() {
        return mTimeFrom;
    }

    public void setmTimeFrom(String mTimeFrom) {
        this.mTimeFrom = mTimeFrom;
    }

    public String getmTimeTo() {
        return mTimeTo;
    }

    public void setmTimeTo(String mTimeTo) {
        this.mTimeTo = mTimeTo;
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
