import java.util.ArrayList;
import java.util.Date;
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

    public void printCheapestActivity() {
        cheapestLoc.getLocationInfo();
    }
    public void getInfoAboutLoc(String name) {
        if (locations.containsKey(name)) {
            locations.get(name).getLocationInfo();
        } else {
            System.out.println("Couldn't find the specified location. Please try again!");
        }
    }
    public void getTopLocations(String fromWhere, Date startingDate, Date endingDate) {
        ArrayList<Location> cheapLocations = new ArrayList<>();
        if (countries.containsKey(fromWhere)) {
            cheapLocations = countries.get(fromWhere).getTopLoc(2,startingDate,endingDate);
        }
        if (regions.containsKey(fromWhere)) {
            cheapLocations = regions.get(fromWhere).getTopLoc(2,startingDate,endingDate);
        }
        if (cities.containsKey(fromWhere)) {
            cheapLocations = cities.get(fromWhere).getTopLoc(2,startingDate,endingDate);
        }
        for(Location l : cheapLocations){
            l.getLocationInfo();
            System.out.println();
        }
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
