package info.sanaebadi.retrofit;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class CityModel{

	@SerializedName("CityModel")
	private List<CityModelItem> cityModel;

	public void setCityModel(List<CityModelItem> cityModel){
		this.cityModel = cityModel;
	}

	public List<CityModelItem> getCityModel(){
		return cityModel;
	}

	@Override
 	public String toString(){
		return 
			"CityModel{" + 
			"cityModel = '" + cityModel + '\'' + 
			"}";
		}
}