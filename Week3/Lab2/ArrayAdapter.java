/* 
    ...
*/
public class ArrayAdapter {
    
    private Student[] studentArray;
    private LayoutType layoutType;
    
    public ArrayAdapter(Student[] studentArray, LayoutType layoutType) {
        this.studentArray = studentArray;
        this.layoutType = layoutType;
    }
    
    public String createRow(int index) {

        String row;
        String horizontalBorder, verticalBorder;
        
        Student currentStudent = studentArray[index];

        horizontalBorder = layoutType.horizontalBorder;
        verticalBorder = layoutType.verticalBorder;

        row = horizontalBorder + verticalBorder + " " + currentStudent.getName() + " " + horizontalBorder;
        return row;
    }
    
    public int getItemCount() {
        return studentArray.length;
    }
}