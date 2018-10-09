/*
    ...
*/
public class ListContainer {
    
    private int rowsToShow;

    public ListContainer(int rowsToShow) {
        this.rowsToShow = rowsToShow;
    }
    
    public void setAdapter(ArrayAdapter adapter) {
         for (int i = 0; i < Math.min(adapter.getItemCount(), rowsToShow); i++) {
            String currentRow = adapter.createRow(i);
            System.out.println(currentRow);
        }
    }
}
