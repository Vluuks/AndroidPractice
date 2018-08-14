public class Helper {

    Activity activity;

    public Helper(Activity callingActivity) {
        this.activity = callingActivity;
    }

    public void getData() {
        // sleep for certain amount
        try {
            Thread.sleep(10000);
        } 
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }

        activity.taskFinished();
    }

}