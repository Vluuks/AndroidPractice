class Student {

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

    // Method of the class
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