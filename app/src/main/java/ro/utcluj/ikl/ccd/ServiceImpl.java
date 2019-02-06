package ro.utcluj.ikl.ccd;

import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.nfc.tech.NfcA;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceImpl {


    ServiceImpl(){

    }

    void logIn(String username, String password){
        Log.d("IKLtest", "logIn: im at start" );
        LoginBoddy<Params> body=new LoginBoddy();
        Params params=new Params();
        body.setmMethod("user.login");
        body.setmParams(params);
        body.getmParams().setmPassword(password);
        body.getmParams().setmUser(username);
        Log.d("IKLtest", "logIn: i made the req" + body );

        Call<LoginResponse> response=RetrofitUtils.getRetrofitUtilis().getApiInterface().getLoginResponse(body);
        response.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){
                    Log.d("IKLtest", "onResponse: some response here");
                    ClientManager.getManager().setSessionKey(response.body().getResult());
                    getList();
                }else {
                    Log.e(this.getClass().toString(), "Password or username incorrect");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                t.printStackTrace();
                Navigator.getInstance().showLogin();
                Log.d("IKLtest", "onFailure: something failed here" + call);
            }
        });

    }

    private void getList(){
        LoginBoddy<ListRequestParams> body=new LoginBoddy();
        body.setmMethod("problem.get");
        body.setmAuth(ClientManager.getManager().getSessionKey());
        ListRequestParams params=new ListRequestParams();
        params.setmOutput("extend");
        params.setmselectAcknowledges("extend");
        params.setmRecent("true");
        String[] sorted={"eventid"};
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
    public void getHosts(){
        LoginBoddy<HostRequestParams> body = new LoginBoddy();
        body.setmMethod("host.get");
        body.setmAuth(ClientManager.getManager().getSessionKey());
        HostRequestParams params = new HostRequestParams();
        String[] filter={};
        params.setmFilter(filter);
        body.setmParams(params);

        Call<HostResponse> response= RetrofitUtils.getRetrofitUtilis().getApiInterface().getHostResponse(body);
        response.enqueue(new Callback<HostResponse>() {
            @Override
            public void onResponse(Call<HostResponse> call, Response<HostResponse> response) {
                if(response.isSuccessful()){
                    Navigator.getInstance().showHosts();
                    ClientManager.getManager().setmHostResponse(response.body());
                }
            }

            @Override
            public void onFailure(Call<HostResponse> call, Throwable t) {

            }
        });

    }

}
