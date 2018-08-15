import java.util.concurrent.*;

public class Helper implements Runnable {

    Activity activity;

    public Helper(Activity callingActivity) {
        this.activity = callingActivity;
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } 
        catch(Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
        System.out.println("Thread klaar!");
    }
}
