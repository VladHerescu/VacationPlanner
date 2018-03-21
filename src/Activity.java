/**
 * Created by Herescu on 3/21/2018.
 */
/*
    Activity class. Contains the minimum number of fields for the moment.
    Can be extended at any time with new fields.
 */
public class Activity {
    String activityName;
    String activityDescription; //For future use

    public Activity(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    /*
    This can be easily made to show more info (For example activity description)
     */
    @Override
    public String toString() {
        return activityName;
    }
}
