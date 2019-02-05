package ro.utcluj.ikl.ccd;

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
                .baseUrl("https://zabbix.org/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        apiInterface = retrofit.create(Service.class);
    }

}
