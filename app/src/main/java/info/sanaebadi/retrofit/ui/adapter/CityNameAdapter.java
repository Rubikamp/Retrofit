package info.sanaebadi.retrofit.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import info.sanaebadi.retrofit.databinding.CityRowBinding;
import info.sanaebadi.retrofit.model.CityModelItem;

public class CityNameAdapter extends RecyclerView.Adapter<CityNameAdapter.CityNameVieWholder> {

    private List<CityModelItem> cityModelItemList;

    public CityNameAdapter(List<CityModelItem> cityModelItemList) {
        this.cityModelItemList = cityModelItemList;
    }


    @NonNull
    @Override
    public CityNameVieWholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityNameVieWholder(CityRowBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityNameVieWholder holder, int position) {
        CityModelItem item = cityModelItemList.get(position);
        holder.binding.textviewCityName.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return cityModelItemList.size();
    }

    static class CityNameVieWholder extends RecyclerView.ViewHolder {
        private CityRowBinding binding;

        public CityNameVieWholder(CityRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
