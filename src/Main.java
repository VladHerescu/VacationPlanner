import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */

/**
 * Main class
 * Using the facade design pattern this class looks now very simple and easy to use.
 * With a single method call you can invoke any kind of action.
 * Even the parse was done in other classes.
 *
 */
public class Main {
    static Datacenter data = new Datacenter();
    public static void main(String[] args) {
        Parser.getAreas("Areas.txt");
        Parser.getActivities("Locations.txt");
        data.printCheapestActivity();
        data.getInfoAboutLoc("bazin innot");
        data.getTopLocations(2,"Romania",new Date(118,5,10), new Date(118,5,15));
        data.getTopLocations(2,"Cluj",new Date(118,5,10), new Date(118,5,15));
    }


}
