/*
    ...
*/
public class Printer {
    
    private ArrayAdapter adapter;
    private int rowsToShow;

    /*
        ...
    */
    public Printer(int rowsToShow) {
        this.rowsToShow = rowsToShow;
    }
    
    /*
        ...
    */
    public void setAdapter(ArrayAdapter adapter) {
        this.adapter = adapter;
    }
    
    /*
        ...
    */
    public void print() {
        for (int i = 0; i < Math.min(adapter.getItemCount(), rowsToShow); i++) {
           String currentRow = adapter.createRow(i);
           System.out.println(currentRow);
        }        
    }
}
