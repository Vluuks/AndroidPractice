// The class depicting a Student
class Student {

    // Properties of the class
    private String name;
    private String program;
    private int studentNumber; 

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
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
        
        System.out.println("Running main!");
        
        Student al = new Student("Ada Lovelace", "Computer Science", 61283);
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148);
        
        // You can add your code here
    }
}