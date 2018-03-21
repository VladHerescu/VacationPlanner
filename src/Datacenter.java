import java.util.HashMap;

/**
 * Created by Herescu on 3/21/2018.
 */
/*
    Contains the main datacenter from where the main class takes all the information
    Contains methods for all the interogations(and room for many more)
 */
public class Datacenter {
    Location cheapestLoc;
    HashMap<String, Location> locations;
    HashMap<String, Country> countries;
    HashMap<String, Region> regions;
    HashMap<String, City> cities;
}
