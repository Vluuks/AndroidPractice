class ExceptionTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        int[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90};
        int i;

        try {
            i = data[10];
        }
        catch(Exception e) {
            // ...
        }
    }
}