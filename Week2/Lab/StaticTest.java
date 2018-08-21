/* 
     Native App Studio Course UvA
     The class depicting a Student demonstrating the behaviour of a final variable
     
     To compile: javac StaticTest.java
     To run: java StaticTest
     
*/
class Student {

    public static final String UNIVERSITY_NAME = "University of Amsterdam";
    public static int studentCount;
    
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
class StaticTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);

    }
}