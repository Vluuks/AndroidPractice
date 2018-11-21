public class InterfaceTest {

    public static void main(String[] args) {
        
        System.out.println("Running main!");
        Activity a = new Activity();
        
        // Run the helper class code in another thread
        new Thread(new Helper(a)).start();
        
        // This should be executed before the callback finishes, even if it is invoked last.
        System.out.println("Dit komt nog voor de callback.");
        
    }

}
