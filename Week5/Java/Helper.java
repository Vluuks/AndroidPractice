public class Helper {

    Activity activity;

    public Helper(callingActivity) {
        this.activity = callingActivity;
    }

    public void getData() {
        // sleep for certain amount
        try {
            Thread.sleep(1000);
        } 
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }

        activity.gotData();
    }

}