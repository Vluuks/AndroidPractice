/* 
     Native App Studio - University of Amsterdam
     Demonstrating encapsulation and various access rights
     
     To compile: javac StudentTest.java
     To run: java StudentTest
     
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
class StudentTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);
    }
}