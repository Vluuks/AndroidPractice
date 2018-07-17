// The class depicting a Student
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
}

// The class used to contain the main method
class StudentStaticTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        System.out.println("Running main!");
        
        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        al.studentCount = 1;
        
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        ik.studentCount = 2;
        
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);
        ja.studentCount = 3;
        
        // What is the value of studentCount using different ways to access it?
        System.out.println("The value of studentCount:  " + al.studentCount);
        System.out.println("The value of studentCount: " + Student.studentCount);
    }
}
