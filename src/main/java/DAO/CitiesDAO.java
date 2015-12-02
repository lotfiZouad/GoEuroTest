package DAO;

import java.util.List;

import Converter.CSVCitiesWriter;
import DTO.CitiesDTO;
import DTO.CityDTO;

public class CitiesDAO {
	
	private static String WEBSERVICE_URL = "http://api.goeuro.com/api/v2/position/suggest/en/CITY_NAME";
    private static final String CITY_NAME = "CITY_NAME";

    private ICityParser parser;
    private CityRequest requester;
    
    public CitiesDAO(){
    	this.parser = new JSONCityParser();
    	this.requester = new CityRequest(); 
    }
	
    public CitiesDTO getCitiesDTO(String city) throws NoInformationException{
    	String json = requester.request(WEBSERVICE_URL.replace(CITY_NAME,city));
    	CitiesDTO citiesDTO = parser.getCities(json);
    	return citiesDTO;
    }
  

}
