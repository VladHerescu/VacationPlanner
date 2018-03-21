import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Main {
    static Datacenter data = new Datacenter();
    public static void main(String[] args) {
        Parser.getAreas();
        Parser.getActivities();
        data.printAllAreas();
    }


}
