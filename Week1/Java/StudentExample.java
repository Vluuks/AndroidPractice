class Student {

    // Properties of the class
    public String name;
    public String program;
    public int studentNumber; 

    // Constructor of the class
    public Student(String aName, String aProgram, int aStudentNumber) {
        name = aName;
        program = aProgram;
        studentNumber = aStudentNumber;
    }

    // Another constructor, with two arguments instead of three
    public Student(String aName, int aStudentNumber) {
        name = aName;
        studentNumber = aStudentNumber;
    }

    // Method of the class
    public void printInfo() {
        System.out.println("This student is called " + name);
        System.out.println("they are studying " + program);
        System.out.println("and their student number is " + studentNumber);
    }
}