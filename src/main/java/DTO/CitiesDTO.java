package DTO;

import java.util.ArrayList;
import java.util.List;

public class CitiesDTO {
    public List<CityDTO> cities = new ArrayList<CityDTO>();

	public List<CityDTO> getCities() {
		return cities;
	}
    
    public void addCity(CityDTO city){
    	cities.add(city);
   	}
	
	
}
