import java.util.concurrent.CompletableFuture;

public class InterfaceTest {

    public static void main(String[] args) {
        
        System.out.println(" hoi");
        Activity a = new Activity();
        
        Helper h = new Helper(a);
//         h.getData();
            CompletableFuture<Void> cf = new CompletableFuture<Void>();
            cf.supplyAsync(() -> {
               System.out.println("async"); 
//             System.out.println("Run async in completable future " + Thread.currentThread());
             
            try {
                Thread.sleep(2000);
            } 
            catch(Exception e) {
                Thread.currentThread().interrupt();
                System.out.println(e.getMessage());
            } 
            
            return "fuck you";
        }).thenRun(() -> {
            System.out.println("aaaaaaaaaaaaaaaaaaaaah callback"); 
        });
		
        System.out.println("deze zou niet als enalaatst moeten zijn");
        
        // Sleep works in main method
        try {
            Thread.sleep(1000);
        } 
        catch(Exception e) {
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        } 
        System.out.println("blablabla na sleep");
        
        
    }

}
