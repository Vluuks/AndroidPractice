class Activity implements Callback {

    public Activity() {
        // nothing
    }

    public void taskFinished() {
        System.out.println("Callback in Activity!");
    }

}