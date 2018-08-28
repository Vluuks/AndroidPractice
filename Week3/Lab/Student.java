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