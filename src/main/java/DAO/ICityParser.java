package DAO;

import DTO.CitiesDTO;

public interface ICityParser {
  
	public CitiesDTO getCities(String flux) throws NoInformationException;
}
