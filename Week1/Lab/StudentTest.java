/*
    Simple model class depicting a student.
    Native App Studio - University of Amsterdam
*/
public class StudentTest {

    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        System.out.println("Running main!");
        // You can add your code here
    }
    
}


class Student {
    // Properties of the class
    public String name;
    public String program;
    public int studentNumber; 
    // ... add a property

    // Method of the class
    public void printInfo() {
        System.out.println("This student is called " + name);
        System.out.println("they are studying " + program);
        System.out.println("and their student number is " + studentNumber);
    }
}

