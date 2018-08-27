class Student {

    static final String UNIVERSITY_NAME = "University of Amsterdam";
    
    // Properties of the class
    public String name;
    public String program;
    public int studentNumber;
    public int credits;

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber, int someCredits) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
        credits = someCredits;
    }

    // Method of the class
    public void printInfo() {
        System.out.println("This student is called " + name);
        System.out.println("they are studying " + program);
        System.out.println("and their student number is " + studentNumber);
    }
}