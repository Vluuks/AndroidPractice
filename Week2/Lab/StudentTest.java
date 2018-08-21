/* 
     Native App Studio - University of Amsterdam
     
     To compile: javac StudentTest.java
     To run: java StudentTest
     
*/
class Student {

    // Properties of the class
    private String name;
    private String program;
    private int studentNumber;
    private int EC;

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber, int someEC) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
        EC = someEC;
    }
}

// The class used to contain the main method
class StudentTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        Student a = ("Tim Steward", "Business Administration", 12487142, 60);
    }
}