class StaticTest {
    
    // The main method is the start of the program
    public static void main(String[] args) {
        
        Student al = new Student("Ada Lovelace", "Computer Science", 61283, 180);
        Student.studentCount = 1;
        
        Student ik = new Student("Immanuel Kant", "Philosophy", 81148, 180);
        Student.studentCount = 2;
        
        Student ja = new Student("Jeanne d'Arc", "History", 90382, 40);
        Student.studentCount = 3;

        
    }
}