import java.util.ArrayList;

/* 
    ...
*/
public class ArrayAdapter {
    
    private ArrayList<Student> studentList;
    private LayoutType layoutType;
    
    /*
        ...
    */
    public ArrayAdapter(ArrayList<Student> studentList, LayoutType layoutType) {
        this.studentList = studentList;
        this.layoutType = layoutType;
    }
    
    /*
        ...
    */
    public String createRow(int index) {

        String row;
        String horizontalBorder, verticalBorder;
        
        Student currentStudent = studentList.get(index);

        horizontalBorder = layoutType.horizontalBorder;
        verticalBorder = layoutType.verticalBorder;

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