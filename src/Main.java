import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Main {
    static Datacenter data;
    public static void main(String[] args) {
        getAreas();

    }

    public static void getAreas() {
        String areasInputFile = "Areas.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(areasInputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // process the line.
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Problems when reading from file");
        }
    }
}
