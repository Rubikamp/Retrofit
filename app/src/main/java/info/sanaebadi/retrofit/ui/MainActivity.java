package info.sanaebadi.retrofit.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.List;

import info.sanaebadi.retrofit.api.RetrofitClient;
import info.sanaebadi.retrofit.databinding.ActivityMainBinding;
import info.sanaebadi.retrofit.model.CityModelItem;
import info.sanaebadi.retrofit.ui.adapter.CityNameAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CityNameAdapter adapter;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        configRecyclerView();

        getCityNames();


    }

    private void configRecyclerView() {
        binding.recyclerCityName.setHasFixedSize(true);
        binding.recyclerCityName.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));

    }


    private void getCityNames() {
        Call<List<CityModelItem>> listCall = RetrofitClient.getInstance().getApiInterfcae().getCityNames();
        listCall.enqueue(new Callback<List<CityModelItem>>() {
            @Override
            public void onResponse(Call<List<CityModelItem>> call, Response<List<CityModelItem>> response) {
                binding.progressCircular.setVisibility(View.VISIBLE);
                List<CityModelItem> cityModelItemList = response.body();
                adapter = new CityNameAdapter(cityModelItemList);
                binding.recyclerCityName.setAdapter(adapter);
                binding.progressCircular.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<CityModelItem>> call, Throwable t) {
                binding.progressCircular.setVisibility(View.GONE);
                Log.e(TAG, "onFailure: " + t.getMessage());
            }
        });
    }

}