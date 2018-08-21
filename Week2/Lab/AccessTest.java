/* 
     Native App Studio - University of Amsterdam
     Demonstrating encapsulation and various access rights
     
     To compile: javac AccessTest.java
     To run: java AccessTest
     
*/
class Student {

    // Properties of the class
    public String name;
    public String program;
    public int studentNumber;
    public int EC;

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber, int someEC) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
        EC = someEC;
    }

    // Method of the class
    public void printInfo() {
        System.out.println("This student is called " + name);
        System.out.println("they are studying " + program);
        System.out.println("and their student number is " + studentNumber);
    }

}

// The class used to contain the main method
class AccessTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        Student a = ("Tim Steward", "Business Administration", 12487142, 60);
    }
}