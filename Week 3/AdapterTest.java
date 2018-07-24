/* 
     Native App Studio Course UvA
     A simulation of what an adapter class is doing behind the scene but in a very simplified manner.
     
     To compile: javac AdapterTest.java
     To run: java AdapterTest
     
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

enum LayoutType {
        DASH, CIRCLE, STAR;
}

class ArrayAdapter {
    
    private Student[] studentArray;
    private int dataToShow;
    private LayoutType layoutType;
    
    public ArrayAdapter(Student[] studentArray, int dataToShow, LayoutType layoutType) {
        this.studentArray = studentArray;
        this.dataToShow = dataToShow;
        this.layoutType = layoutType;
    }
    
    public void start() {
        for (int i = 0; i < studentArray.length; i++) {
            Student currentStudent = studentArray[i];
            createRow(currentStudent);
        }
    }
    
    private void createRow(Student aStudent) {
        
        
        System.out.println("woehoe");
    }
}

// The class used to contain the main method
class AdapterTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        

        // Creation of the array containing student objects
        Student[] students = {
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
        };
        
        // Constructing the adapter and starting it
        ArrayAdapter adapter = new ArrayAdapter(students, 1, LayoutType.DASH);
        adapter.start();
    }
}
