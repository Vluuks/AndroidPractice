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

/*
    ...
*/
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
    ...
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
    ...
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
        
    }
}