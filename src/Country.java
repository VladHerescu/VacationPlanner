import java.util.*;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Country implements Area{
    String name;
    HashMap<String, Region> regions;
    TreeMap<Float,Location> locations;

    public Country(String name) {
        this.name = name;
        this.regions = new HashMap<>();
        this.locations = new TreeMap<>();
    }
    public void addLocation(float pricePerDay, Location location) {
        locations.put(pricePerDay,location);
    }

    public String getName() {
        return name;
    }

    @Override
    public ArrayList<Location> getTopLoc(int nr_top, Date startDate, Date endDate) {
        ArrayList<Location> cheap_loc = new ArrayList<>();
        Iterator<Location> iterator = locations.values().iterator();
        for(int i = 0; i < Math.min(nr_top,locations.size()); i++) {
            while(iterator.hasNext()) {
                Location loc = iterator.next();
                if (loc.startingDate.after(startDate) && loc.endingDate.before(endDate)) {
                    cheap_loc.add(loc);
                    break;
                }

            }
        }
        return cheap_loc;
    }
}
