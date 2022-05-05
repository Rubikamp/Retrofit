package info.sanaebadi.retrofit.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private ApiInterfcae apiInterfcae;

    public OkHttpClient getClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        return client;
    }

    private RetrofitClient(){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiInterfcae.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
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
