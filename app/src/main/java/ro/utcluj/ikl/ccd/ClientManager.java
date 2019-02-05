package ro.utcluj.ikl.ccd;

public class ClientManager {

    private static ClientManager retrofitUtilis;

    private String mSessionKey="";
    private ListResponse mListResponse;

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
}
