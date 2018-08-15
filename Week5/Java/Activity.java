/*
    Simulates an activity.  It imlpements the Callback interface so that when the
    task in the helper class has finished, the method taskFinished() inside this
    Activity can be invoked.
*/
class Activity implements Callback {

    public void taskFinished() {
        System.out.println("Callback in Activity!");
    }

}