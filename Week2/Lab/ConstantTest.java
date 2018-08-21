/* 
     Native App Studio Course UvA
     Demonstrating the behaviour of a final variable
     
     To compile: javac ConstantTest.java
     To run: java ConstantTest
     
*/
class Student {

    static final String UNIVERSITY_NAME = "University of Amsterdam";
    static int studentCount;
    
    // Properties of the class
    private String name;
    private String program;
    private int studentNumber;
    private int credits;

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber, int someCredits) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
        credits = someCredits;
    }
}

// The class used to contain the main method
class ConstantTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        System.out.println("Running main!");
        Student.UNIVERSITY_NAME = "Vrije Universiteit Amsterdam";
    }
}