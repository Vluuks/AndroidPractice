import java.util.concurrent.*;

/* 
    A helper class that simulates time consuming functionality
    not contained in the Activity.
*/
public class LongRunningTask implements Runnable {

    Activity activity;

    /*
        Constructor that takes a reference to the activity, so that
        we know where to invoke our callback from!
    */
    public LongRunningTask(Activity callingActivity) {
        this.activity = callingActivity;
    }

    /*
        This part will be run on another thread, asynchronously.
        We simulate a time consuming task using Thread.sleep(). 
    */
    public void run() {
        try {
            Thread.sleep(2000);
        } 
        catch(Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }

        // When we are done, perform the callback.
        System.out.println("Thread finished!");
        activity.taskFinished();
    }
}
