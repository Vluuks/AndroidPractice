/* 
     Native App Studio Course UvA
     The class depicting a Student demonstrating the behaviour of a final variable
     
     To compile: javac StudentTest.java
     To run: java StudentTest
     
*/
class Student {

    static final String UNIVERSITY_NAME = "University of Amsterdam";
    static int studentCount;
    
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
        
        System.out.println("Running main!");

        // This is ok!
        System.out.println(Student.UNIVERSITY_NAME);
        
        // But this is not okay!
//         Student.UNIVERSITY_NAME = "Vrije Universiteit Amsterdam";
    }
}