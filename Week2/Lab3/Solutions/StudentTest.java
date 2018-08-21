/* 
     Native App Studio Course UvA
     
     To compile: javac StudentTest.java
     To run: java StudentTest
     
*/
class Student {

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

    public void setEC(int someEC) {
        if(someEC > 0) {
            EC = someEC;
        }
        else {
            EC = 0;
        }
    }

    public int getEC() {
        return EC;
    }
}

// The class used to contain the main method
class StudentTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
    }
}