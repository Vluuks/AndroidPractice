import java.util.concurrent.CompletableFuture;

public class InterfaceTest {

    public static void main(String[] args) {
        
        System.out.println(" hoi");
        Activity a = new Activity();
        
        new Thread(new Helper(a)).start();
        
        System.out.println("deze zou niet als laatst moeten zijn");
        
        try {
            Thread.sleep(3000);
        } 
        catch(Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        } 
        System.out.println("blablabla na sleep");
    }

}
