package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class HostResponse {
    @SerializedName("result")
    private List<HostResponseItem> mResponseHost=new ArrayList<>();

    public List<HostResponseItem> getmResponseHost() {
        return mResponseHost;
    }

}
