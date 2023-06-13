import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

class Activity {
    private String name;
    private int duration;

    public Activity(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }


    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

class DailyActivityTracker {
    private Map<LocalDate, Activity> activities;

    public DailyActivityTracker() {
        activities = new HashMap<>();
    }

    public void addActivity(LocalDate date, String name, int duration) {
        Activity activity = new Activity(name, duration);
        activities.put(date, activity);
        System.out.println("Activity added for " + date + ": " + activity.getName());
    }

    public void removeActivity(LocalDate date) {
        if (activities.containsKey(date)) {
            Activity removedActivity = activities.remove(date);
            System.out.println("Activity removed for " + date + ": " + removedActivity.getName());
        } else {
            System.out.println("No activity found for " + date);
        }
    }

    public void displayActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities found.");
        } else {
            System.out.println("Activities:");
            for (Map.Entry<LocalDate, Activity> entry : activities.entrySet()) {
                LocalDate date = entry.getKey();
                Activity activity = entry.getValue();
                System.out.println("Date: " + date + ", Activity: " + activity.getName() + ", Duration: " + activity.getDuration() + " minutes");
            }
        }
    }
}

public class Sunitasharma {
    public static void main(String[] args) {
        DailyActivityTracker tracker = new DailyActivityTracker();

        // Adding activities
        LocalDate today = LocalDate.now();
        tracker.addActivity(today, "Running", 30);
        tracker.addActivity(today, "Yoga", 45);
        tracker.addActivity(today, "Reading", 60);

        // Displaying activities
        tracker.displayActivities();

        // Removing activity
        tracker.removeActivity(today);

        // Displaying activities again
        tracker.displayActivities();
    }
}
