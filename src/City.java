import sun.nio.cs.ext.MacThai;

import java.util.*;


/**
 * Created by Herescu on 3/21/2018.
 */

public class City implements Area{
    String name;
    Region motherRegion; //Couldn't find a better name, i will work on it
    Country motherCountry; //Same here
    TreeMap<Float, Location> locations;

    public City(String name, Region motherRegion, Country motherCountry) {
        this.name = name;
        this.motherRegion = motherRegion;
        this.motherCountry = motherCountry;
        this.locations = new TreeMap<>();
    }

    public void addLocation(float pricePerDay, Location location) {
        locations.put(pricePerDay,location);
    }



    /**
     * Return a list of the cheapest nr_top activities in the specified date.
     * The locations are already kept in a treeMap data structure so they are already ordered by their price per day.
     * @param nr_top
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public ArrayList<Location> getTopLoc(int nr_top, Date startDate, Date endDate) {
        ArrayList<Location> cheap_loc = new ArrayList<>();
        Iterator<Location> iterator = locations.values().iterator();
        for(int i = 0; i < Math.min(nr_top,locations.size()); i++) {
            while(iterator.hasNext()) {
                Location loc = iterator.next();
                if (loc.startingDate.before(startDate) && loc.endingDate.after(endDate)) {
                    cheap_loc.add(loc);
                    break;
                }

            }
        }
        return cheap_loc;
    }

    public String getName() {
        return name;
    }


}
