import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


/**
 * Created by Herescu on 3/21/2018.
 */
public class City implements Area{
    String name;
    HashMap<String, Location> locations;

    public City(String name) {
        this.name = name;
        this.locations = new HashMap();
    }

    public void addLocation(String name, Location location) {
        locations.put(name,location);
    }


    /*
        Will return a list of cheapest locations here
         */
    public ArrayList<Location> getTopLoc() {
        return null;
    }

    public String getName() {
        return name;
    }


}
