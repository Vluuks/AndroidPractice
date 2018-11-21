public class InterfaceTest {

    public static void main(String[] args) {
        
        System.out.println("Running main!");
        Activity a = new Activity();
        
        // Run the helper class code in another thread
        new Thread(new Helper(a)).start();
        
        System.out.println("Print statement");
        
    }

}
