import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */
/**
    This interface is implemented by every area
    It makes sure that every area is capable of telling it's cheapest locations.
 */
public interface Area {
    public ArrayList<Location> getTopLoc(int nr_top,Date startDate,Date endDate);
}
