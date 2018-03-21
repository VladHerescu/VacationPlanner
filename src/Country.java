import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Country implements Area{
    String name;
    HashMap<String, Region> regions;

    public Country(String name) {
        this.name = name;
    }


    @Override
    public ArrayList<Location> getTopLoc() {
        return null;
    }
}
