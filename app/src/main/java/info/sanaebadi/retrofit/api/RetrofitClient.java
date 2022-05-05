package info.sanaebadi.retrofit.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private ApiInterfcae apiInterfcae;

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterfcae.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiInterfcae = retrofit.create(ApiInterfcae.class);
    }

    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }

    public ApiInterfcae getApiInterfcae() {
        return apiInterfcae;
    }
}
