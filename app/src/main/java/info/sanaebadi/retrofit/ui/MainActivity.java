package info.sanaebadi.retrofit.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import info.sanaebadi.retrofit.databinding.ActivityMainBinding;
import info.sanaebadi.retrofit.ui.adapter.CityNameAdapter;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private CityNameAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        adapter= new CityNameAdapter();
        binding.recyclerCityName.setHasFixedSize(true);
        binding.recyclerCityName.setAdapter(adapter);

    }


}