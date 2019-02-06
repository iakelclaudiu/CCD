package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

public class HostRequestParams {

    @SerializedName("filter")
    private String[] mFilter;

    public String[] getmFilter() {
        return mFilter;
    }

    public void setmFilter(String[] mFilter) {
        this.mFilter = mFilter;
    }
}
