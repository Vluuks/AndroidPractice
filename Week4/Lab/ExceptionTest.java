class ExceptionTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
     
        // Call doSomething() from SomeClass multiple times to produce errors
        for(int i = 0; i < 50; i++) {
            
            SomeClass.doSomething();
        }  
    }
}