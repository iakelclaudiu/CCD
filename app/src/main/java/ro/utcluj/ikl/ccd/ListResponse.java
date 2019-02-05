package ro.utcluj.ikl.ccd;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListResponse {

    @SerializedName("result")
    private List<ListResponseItem> mResponseList=new ArrayList<>();

    public List<ListResponseItem> getmResponseList() {
        return mResponseList;
    }
}
