package Converter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import DTO.CitiesDTO;
import DTO.CityDTO;

public class CSVCitiesWriter implements CitiesWriter {
	private static final Object[] FILE_HEADER = {"_id","name","type","latitude","longitude"};
	private static final String NEW_LINE_SEPARATOR = "\n";

	
	public void Writer(CitiesDTO cities,String fileName) {
		 FileWriter fileWriter = null;
		 CSVPrinter csvFilePrinter = null;
		
		 CSVFormat csvFileFormat = CSVFormat.DEFAULT.withRecordSeparator(NEW_LINE_SEPARATOR);
		 
		 try{
		 fileWriter = new FileWriter(fileName);
		 csvFilePrinter = new CSVPrinter(fileWriter, csvFileFormat);
		 
		 csvFilePrinter.printRecord(FILE_HEADER);
		 
		 for(CityDTO city:cities.getCities()){
		 List cityRow = new ArrayList();
		 cityRow.add(city.getId());
		 cityRow.add(city.getName());
		 cityRow.add(city.getType());
		 cityRow.add(city.getLatitude());
		 cityRow.add(city.getLongitude());
		 csvFilePrinter.printRecord(cityRow);
		 }
		 
		 fileWriter.flush();
		 fileWriter.close();
		 }catch(IOException e){
			 e.printStackTrace();
		 }
		 

	}

}
