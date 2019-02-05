package ro.utcluj.ikl.ccd;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Service {

    @POST("api_jsonrpc.php")
    Observable<LoginResponse> getLoginResponse(@Body String body);
}
