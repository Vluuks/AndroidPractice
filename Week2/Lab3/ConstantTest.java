/* 
     Native App Studio Course UvA
     Demonstrating the behaviour of a final variable
     
     To compile: javac ConstantTest.java
     To run: java ConstantTest
     
*/

// The class used to contain the main method
class ConstantTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        System.out.println("Running main!");
        Student.UNIVERSITY_NAME = "Vrije Universiteit Amsterdam";
    }
}