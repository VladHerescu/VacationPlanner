import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Parser {
    public static void getAreas() {
        String areasInputFile = "Areas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(areasInputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] areas = line.split(",");
                String country = areas[0].trim();
                String region = areas[1].trim();
                String city = areas[2].trim();
                if (!Main.data.countries.containsKey(country))
                    Main.data.countries.put(country, new Country(country));
                if (!Main.data.countries.get(country).regions.containsKey(region)) {
                    Region reg = new Region(region);
                    Main.data.countries.get(country).regions.put(region, reg);
                    Main.data.regions.put(region,reg);
                }
                if (!Main.data.countries.get(country).regions.get(region).cities.containsKey(city)){
                    City c = new City(city);
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
    public static void getActivities() {
        String locationInputFiles = "Locations.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(locationInputFiles))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

            }
        } catch (IOException e) {
            System.out.println("Problems when reading from file");
        }
        catch (IndexOutOfBoundsException e) {
            System.out.println("Input format is wrong");
        }
    }
}
