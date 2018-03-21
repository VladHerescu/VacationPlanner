import java.util.HashMap;
import java.util.Map;

/**
 * Created by Herescu on 3/21/2018.
 */
/*
    Contains the main datacenter from where the main class takes all the information
    Contains methods for all the interogations(and room for many more)
 */
public class Datacenter {
    Location cheapestLoc;
    HashMap<String, Location> locations;
    HashMap<String, Country> countries;
    HashMap<String, Region> regions;
    HashMap<String, City> cities;

    public Datacenter() {
        this.locations = new HashMap<>();
        this.countries = new HashMap<>();
        this.regions = new HashMap<>();
        this.cities = new HashMap<>();
    }

    public void printAllAreas() {
        for (Map.Entry<String, Country> country : countries.entrySet()) {
            for (Map.Entry<String, Region> region : country.getValue().regions.entrySet()) {
                for (Map.Entry<String, City> city : region.getValue().cities.entrySet()) {
                    System.out.println(country.getValue().getName() + "-" +region.getValue().getName() + "-" + city.getValue().getName());
                }
            }
        }
    }
}
