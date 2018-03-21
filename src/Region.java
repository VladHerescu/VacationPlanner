import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Region implements Area{
    String name;
    HashMap<String, City> cities;

    public Region(String name) {
        this.name = name;
        this.cities = new HashMap<String, City>();
    }


    @Override
    public ArrayList<Location> getTopLoc() {
        return null;
    }
}
