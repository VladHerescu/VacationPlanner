import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Parser {
    /**
     * Reads from the input file the areas and create the hierarchy.
     * Also, it fills the Datacenter fields accordingly.
     */
    public static void getAreas(String areasInputFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(areasInputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] areas = line.split(",");
                String country = areas[0].trim();
                String region = areas[1].trim();
                String city = areas[2].trim();
                if (!Main.data.countries.containsKey(country)){
                    Main.data.countries.put(country, new Country(country));
                }
                if (!Main.data.countries.get(country).regions.containsKey(region)) {
                    Region reg = new Region(region);
                    Main.data.countries.get(country).regions.put(region, reg);
                    Main.data.regions.put(region,reg);
                }
                if (!Main.data.countries.get(country).regions.get(region).cities.containsKey(city)){
                    City c = new City(city,Main.data.regions.get(region),Main.data.countries.get(country));
                    Main.data.countries.get(country).regions.get(region).cities.put(city, c);
                    Main.data.cities.put(city,c);
                }
            }
        } catch (IOException e) {
            System.out.println("Problems when reading from file");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Input format is wrong");
        }
    }
    /*
    Parseaza fisierul cu activitati si in acelasi timp cauta activitatea care este cel mai ieftin de practicat timp de 10 zile
     */

    /**
     * Reads the input location file(Found it better to call it activities here)
     * It parses what was read and creates an location with those parameters.
     * Also it keeps track of the cheapest location globally.
     * It also update the location list for the country and the region where the specific location is held.
     * This gives linear complexity to every operation requested by the user, so the only complexity is the one at insertion.
     */
    public static void getActivities(String locationInputFiles) {
        try (BufferedReader br = new BufferedReader(new FileReader(locationInputFiles))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String name = tokens[0].trim();
                City city = Main.data.cities.get(tokens[1].trim());
                float price = Float.parseFloat(tokens[2].trim());
                String[] date = tokens[3].trim().split("-");
                Date startingDate = new Date(Integer.parseInt(date[2]) - 1900,Integer.parseInt(date[1]),Integer.parseInt(date[0]));
                date = tokens[4].trim().split("-");
                Date endingDate = new Date(Integer.parseInt(date[2]) - 1900,Integer.parseInt(date[1]),Integer.parseInt(date[0]));
                Location loc = new Location(name,city,price,startingDate,endingDate);

                for(int i = 5; i < tokens.length; i++) {
                    loc.addActivity(new Activity(tokens[i].trim()));
                }
                //Putting the location in all the right places
                Main.data.locations.put(name,loc);
                city.addLocation(loc.pricePerDay,loc);
                city.motherRegion.addLocation(loc.pricePerDay,loc);
                city.motherCountry.addLocation(loc.pricePerDay,loc);

                //Find the cheapest location on parsing
                if (Main.data.cheapestLoc == null) {
                    Main.data.cheapestLoc = loc;
                } else {
                    long aux = endingDate.getTime() - startingDate.getTime();
                    //Got time difference in days
                    aux = aux / (1000 * 3600 * 24);
                    if (loc.pricePerDay < Main.data.cheapestLoc.pricePerDay && aux > 10)
                        Main.data.cheapestLoc = loc;
                }
            }
        } catch (IOException e) {
            System.out.println("Problems when reading from file");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Input format is wrong");
        }
    }
}
