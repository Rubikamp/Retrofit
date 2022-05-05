package info.sanaebadi.retrofit.api;

import java.util.List;

import info.sanaebadi.retrofit.model.CityModelItem;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterfcae {

    String BASE_URL= "https://dl.android-studio.ir";

    @GET("files/city.json")
    Call<List<CityModelItem>> getCityNames();
}
