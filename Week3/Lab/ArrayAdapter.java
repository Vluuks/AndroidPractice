import java.util.ArrayList;

public class ArrayAdapter {
    
    private ArrayList<Student> studentList;
    
    public ArrayAdapter(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }
    
    public String createRow(int index) {

        Student currentStudent = studentList.get(index);
        String row = "| " + currentStudent.getName() + " |";
        return row;
    }
    
    public int getItemCount() {
        return studentList.size();
    }
}
