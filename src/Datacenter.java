import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Herescu on 3/21/2018.
 */
/**
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

    /**
     * Uses predefined method to print the cheapest location
     * No need to perform any search since the cheapest location was found since the file was parsed
     */
    public void printCheapestActivity() {
        System.out.println("This is the cheapest activity for 10 days");
        cheapestLoc.getLocationInfo();
        System.out.println("\n");
    }

    /**
     * Gets information about a location
     * All the locations are held in a hash map for quicker find
     * @param name
     */
    public void getInfoAboutLoc(String name) {
        System.out.println("This is the info for " + name);
        if (locations.containsKey(name)) {
            locations.get(name).getLocationInfo();
            System.out.println("\n");
        } else {
            System.out.println("Couldn't find the specified location. Please try again!");
        }
    }

    /**
     * Gets an arraylist with the cheapest locations.
     * It prints the info for every one.
     * @param fromWhere
     * @param startingDate
     * @param endingDate
     */
    public void getTopLocations(int nr_top,String fromWhere, Date startingDate, Date endingDate) {
        System.out.println("Top locations for " + fromWhere);
        ArrayList<Location> cheapLocations = new ArrayList<>();
        if (countries.containsKey(fromWhere)) {
            cheapLocations = countries.get(fromWhere).getTopLoc(nr_top,startingDate,endingDate);
        }
        if (regions.containsKey(fromWhere)) {
            cheapLocations = regions.get(fromWhere).getTopLoc(nr_top,startingDate,endingDate);
        }
        if (cities.containsKey(fromWhere)) {
            cheapLocations = cities.get(fromWhere).getTopLoc(nr_top,startingDate,endingDate);
        }
        for(Location l : cheapLocations){
            l.getLocationInfo();
            System.out.println();
        }
    }

    /**
     * Debug function.
     * It prints all the area inserted for verification
     */
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
