package ro.utcluj.ikl.ccd;


import android.content.SharedPreferences;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {

    private static RetrofitUtils retrofitUtilis;



    private Service apiInterface;


    public static RetrofitUtils getRetrofitUtilis() {
        if (retrofitUtilis == null) {
            retrofitUtilis = new RetrofitUtils();
        }
        return retrofitUtilis;
    }

    public Service getApiInterface() {
        return apiInterface;
    }

    private RetrofitUtils() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.71.44/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        apiInterface = retrofit.create(Service.class);
    }

}
