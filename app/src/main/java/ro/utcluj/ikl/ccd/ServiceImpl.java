package ro.utcluj.ikl.ccd;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceImpl {

    private Service mService;
    private String mUrl="http://192.168.71.44/";
    private String mPublicUrl ="https://zabbix.org/zabbix";


    ServiceImpl(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(mUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        mService=retrofit.create(Service.class);
    }

    void logIn(String username, String password){
        LoginBoddy body=new LoginBoddy();
        Params params=new Params();
        body.setmParams(params);
        body.getmParams().setmPassword(password);
        body.getmParams().setmUser(username);
        Gson gson = new Gson();
        String stringBody= gson.toJson(body);
        Log.d("Petrea",stringBody);

       mService.getLoginResponse(stringBody).subscribeOn(Schedulers.newThread())
               .observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<LoginResponse>() {
           @Override
           public void onSubscribe(Disposable d) {

           }

           @Override
           public void onNext(LoginResponse value) {
               Log.d("Petrea","onNext");
           }

           @Override
           public void onError(Throwable e) {
               Log.d("Petrea","onError");

           }

           @Override
           public void onComplete() {
           }
       });
    }
}
