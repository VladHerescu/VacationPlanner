import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Herescu on 3/21/2018.
 */
public interface Area {
    public ArrayList<Location> getTopLoc(int nr_top,Date startDate,Date endDate);
}
