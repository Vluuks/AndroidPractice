import java.util.ArrayList;

/*
    A class that represents a student. For this example it contains only getters since we do not
    actually need to set values.
*/
class Student {

    // Instance variables
    private String name;
    private String program;

    // Constructor
    public Student(String aName, String aProgram) {
        name = aName;
        program = aProgram;
    }

    public String getName() {
        return name;
    }

    public String getProgram() {
        return program;
    }
    
    public static ArrayList<Student> createSampleList() {
        // TODO
    }
}
