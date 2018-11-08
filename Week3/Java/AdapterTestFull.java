/* 
     Native App Studio Course UvA
     A simulation of what an adapter class is doing behind the scene but in a very simplified manner.
     
     To compile: javac AdapterTest.java
     To run: java AdapterTest
     
*/


/*
    A class depicting a student. For this example it contains only getters since we do not
    actually need to set values.
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

    public int getEC() {
        return EC;
    }

    public String getName() {
        return name;
    }


    public String getProgram() {
        return program;
    }


    public int getStudentNumber() {
        return studentNumber;
    }
}

class Printer {
    
    private int rowsToShow;

    public Printer(int rowsToShow) {
        this.rowsToShow = rowsToShow;
    }
    
    public void setAdapter(ArrayAdapter adapter) {
         for (int i = 0; i < Math.min(adapter.getItemCount(), rowsToShow); i++) {
            String currentRow = adapter.createRow(i);
            System.out.println(currentRow);
        }
    }
}

/*
    Enum to hold the constants that users can pick to determine what the borders of the
    data printed to the console look like.
*/
enum Formatter {
    DASH("\n---------------------\n", "|"), 
    CIRCLE("\no 0 o 0 o 0 o 0 o 0 o\n", "0"), 
    STAR("\n*********************\n", "*");
    
    String horizontalBorder, verticalBorder;
    
    // Constructor
    private Formatter(String horizontalBorder, String verticalBorder) {
        this.horizontalBorder = horizontalBorder;
        this.verticalBorder = verticalBorder;
    }
}

/* 
    This class holds the functionality of the "adapter", which takes in an array and the layout
    type to show (the enum). It then iterates over the array and prints out the appropriate layout
    for every student object in the array.
*/
class ArrayAdapter {
    
    private Student[] studentArray;
    private Formatter formatter;
    
    public ArrayAdapter(Student[] studentArray, Formatter formatter) {
        this.studentArray = studentArray;
        this.formatter = formatter;
    }
    
    public String createRow(int index) {

        String row;
        String horizontalBorder, verticalBorder;
        
        Student currentStudent = studentArray[index];

        // Determine layout type
        horizontalBorder = formatter.horizontalBorder;
        verticalBorder = formatter.verticalBorder;

        row = horizontalBorder + verticalBorder + " " + currentStudent.getName() + " " + horizontalBorder;
        return row;
    }
    
    public int getItemCount() {
        return studentArray.length;
    }
}

/*
    The class containing the main method.
*/
class AdapterTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        // Creation of the array containing student objects
        Student[] students = {
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Wouter Vrielink", "AI? Of iets dergelijks", 98319811, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90),
            new Student("Tim Meijer", "Business Information Systems", 11153431, 90)
        };
        
        // Constructing the adapter and starting it
        ArrayAdapter adapter = new ArrayAdapter(students, Formatter.DASH);
        Printer printer = new Printer(12);
        
        printer.setAdapter(adapter);
    }
}