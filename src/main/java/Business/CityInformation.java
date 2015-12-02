package Business;

import java.util.List;

import Converter.CSVCitiesWriter;
import Converter.CitiesWriter;
import DAO.CitiesDAO;
import DAO.NoInformationException;
import DTO.CitiesDTO;
import DTO.CityDTO;

public class CityInformation {
	private CitiesDAO citiesDAO;
	private CitiesWriter citiesWriter;
	
	public CityInformation(){
		this.citiesDAO = new CitiesDAO();
		this.citiesWriter = new CSVCitiesWriter();
	}
	
	public void retrieveCityInformation(String cityName) throws NoInformationException{
		CitiesDTO citiesDTO = citiesDAO.getCitiesDTO(cityName);
		String fileName = cityName+".csv";
		citiesWriter.Writer(citiesDTO, fileName);
		
	}

	

}
