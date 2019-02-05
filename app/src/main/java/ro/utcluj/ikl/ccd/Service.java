package ro.utcluj.ikl.ccd;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("zabbix/api_jsonrpc.php")
    Call<LoginResponse> getLoginResponse(@Body LoginBoddy body);

    @POST("zabbix/api_jsonrpc.php")
    Call<ListResponse> getEventList(@Body LoginBoddy body);
}
