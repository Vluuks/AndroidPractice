class Student {

    // Properties of the class
    private String name;
    private String program;
    private int studentNumber;
    private int credits;

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber, int someCredits) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
        credits = someCredits;
    }

    // Method of the class
    public void setCredits(int someCredits) {
        if(someCredits > 0) {
            credits = someCredits;
        }
        else {
            credits = 0;
        }
    }

    public int getCredits() {
        return credits;
    }
}