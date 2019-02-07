package ro.utcluj.ikl.ccd;

public class ClientManager {

    private static ClientManager retrofitUtilis;

    private String mSessionKey="";
    private ListResponse mListResponse;
    private HostResponse mHostResponse;
    private String mLogoutRespons;

    public static ClientManager getManager() {
        if (retrofitUtilis == null) {
            retrofitUtilis = new ClientManager();
        }
        return retrofitUtilis;
    }

    public void setSessionKey(String sessionKey){
        mSessionKey=sessionKey;
    }

    public String getSessionKey(){
        return mSessionKey;
    }

    public ListResponse getmListResponse() {
        return mListResponse;
    }

    public void setmListResponse(ListResponse mListResponse) {
        this.mListResponse = mListResponse;
    }

    public HostResponse getmHostResponse() {
        return mHostResponse;
    }

    public void setmHostResponse(HostResponse mHostResponse) {
        this.mHostResponse = mHostResponse;
    }

    public void setmLogoutRespons(String mLogoutRespons) {
        this.mLogoutRespons = mLogoutRespons;
    }
}
