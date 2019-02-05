package ro.utcluj.ikl.ccd;

import android.util.Log;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceImpl {


    ServiceImpl(){

    }

    void logIn(String username, String password){
        LoginBoddy<Params> body=new LoginBoddy();
        Params params=new Params();
        body.setmMethod("user.login");
        body.setmParams(params);
        body.getmParams().setmPassword(password);
        body.getmParams().setmUser(username);

        Call<LoginResponse> response=RetrofitUtils.getRetrofitUtilis().getApiInterface().getLoginResponse(body);
        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    ClientManager.getManager().setSessionKey(response.body().getResult());
                    getList();
                }
                Log.e(this.getClass().toString(),"Password or username incorrect");
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    private void getList(){
        LoginBoddy<ListRequestParams> body=new LoginBoddy();
        body.setmMethod("event.get");
        body.setmAuth(ClientManager.getManager().getSessionKey());
        ListRequestParams params=new ListRequestParams();
        params.setmOutput("extend");
        params.setmTimeFrom("1546300800");
        params.setmTimeTo("1549395698");
        String[] sorted={"clock", "eventid"};
        params.setmSortedField(sorted);
        params.setmSortOrder("desc");
        body.setmParams(params);

        Call<ListResponse> response=RetrofitUtils.getRetrofitUtilis().getApiInterface().getEventList(body);
        response.enqueue(new Callback<ListResponse>() {
            @Override
            public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
                if(response.isSuccessful()) {
                    Navigator.getInstance().showDashBoard();
                    ClientManager.getManager().setmListResponse(response.body());
                }

            }

            @Override
            public void onFailure(Call<ListResponse> call, Throwable t) {

            }
        });
    }
}
