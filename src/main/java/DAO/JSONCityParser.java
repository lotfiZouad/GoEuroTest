package DAO;

import org.json.JSONArray;
import org.json.JSONObject;

import DTO.CitiesDTO;
import DTO.CityDTO;

public class JSONCityParser  implements ICityParser{
	private static final String ID = "_id";
	private static final String NAME = "name";
	private static final String TYPE = "type";
	private static final String GEO_POSITION = "geo_position";
	private static final String LATITUDE = "latitude";
	private static final String LONGITUDE = "longitude";
	

	public CitiesDTO getCities(String json) throws NoInformationException {
		 CitiesDTO citiesDTO = new CitiesDTO();
		 
		 JSONArray citiesJson = new JSONArray(json);
		 int n = citiesJson.length();
		 if(n==0)
			 throw new NoInformationException("the city is invalid or no information found");
		
		 for(int i=0; i<n; i++){
			 JSONObject cityJson = citiesJson.getJSONObject(i);
			 int id = cityJson.getInt(ID);
			 String name = cityJson.getString(NAME);
			 String type = cityJson.getString(TYPE);
			 JSONObject geoPosition = cityJson.getJSONObject(GEO_POSITION);
			 double latitude = geoPosition.getDouble(LATITUDE);
			 double longitude = geoPosition.getDouble(LONGITUDE);
			 CityDTO cityDTO = new CityDTO();
			 cityDTO.setId(id);
			 cityDTO.setName(name);
			 cityDTO.setType(type);			 
			 cityDTO.setLatitude(latitude);
			 cityDTO.setLongitude(longitude);
			 citiesDTO.addCity(cityDTO);
			 
		 }
		 
		return citiesDTO;
	}

}
