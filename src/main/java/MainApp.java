import Business.CityInformation;
import Converter.CSVCitiesWriter;
import DAO.CitiesDAO;
import DAO.NoInformationException;


public class MainApp {

	public static void main(String[] args) {
		if (args.length!=1){
    		System.err.println("Please provide a city name");
    		System.exit(0);
    	}    
    	CityInformation cityInformation = new CityInformation();
    	   	
    	try {
    		cityInformation.retrieveCityInformation(args[0]);
		} catch (NoInformationException e) {
			System.err.println(e.getMessage());
    		System.exit(0);
			
		}
       System.out.println("csv file created successfully!");
	}

}
