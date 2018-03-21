import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Main {
    static Datacenter data = new Datacenter();
    public static void main(String[] args) {
        Parser.getAreas();
        Parser.getActivities();
        //data.printAllAreas();
        //data.getInfoAboutLoc("bazin innot");
       data.getTopLocations("Galati",new Date(118,1,1), new Date(118,12,31));
    }


}
