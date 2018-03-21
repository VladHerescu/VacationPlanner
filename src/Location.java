import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */
public class Location {
    String name;
    City city;
    float pricePerDay;
    ArrayList<Activity> activities;
    Date startingDate;
    Date endingDate;

    public Location(String name, City city, float pricePerDay, Date startingDate, Date endingDate) {
        this.name = name;
        this.city = city;
        this.pricePerDay = pricePerDay;
        this.startingDate = startingDate;
        this.endingDate = endingDate;
        this.activities = new ArrayList<Activity>();
    }

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public void getLocationInfo() {
        System.out.println("For location named -" + name + "- we have registered the following info:");
        System.out.println("The city where this is located is " + city.getName());
        System.out.println("The average price per day for this location is " + pricePerDay);
        System.out.println("The best period to go there is from " + startingDate.toString() + " to " + endingDate.toString());
        System.out.println("And now here's a list of activities you can do there " + activities.toString());
    }
}
