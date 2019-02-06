package ro.utcluj.ikl.ccd;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("api_jsonrpc.php")
    Call<LoginResponse> getLoginResponse(@Body LoginBoddy body);

    @POST("api_jsonrpc.php")
    Call<ListResponse> getEventList(@Body LoginBoddy body);

    @POST("api_jsonrpc.php")
    Call<HostResponse> getHostResponse(@Body LoginBoddy body);
}
