import java.util.ArrayList;

/* 
    ...
*/
public class ArrayAdapter {
    
    private ArrayList<Student> studentList;
    private Formatter formatter;
    
    /*
        ...
    */
    public ArrayAdapter(ArrayList<Student> studentList, Formatter formatter) {
        this.studentList = studentList;
        this.formatter = formatter;
    }
    
    /*
        ...
    */
    public String createRow(int index) {

        String row;
        String horizontalBorder, verticalBorder;
        
        Student currentStudent = studentList.get(index);

        horizontalBorder = formatter.horizontalBorder;
        verticalBorder = formatter.verticalBorder;

        row = horizontalBorder + verticalBorder + " " + currentStudent.getName() + " " + horizontalBorder;
        return row;
    }
    
    /*
        ...
    */
    public int getItemCount() {
        return studentList.size();
    }
}