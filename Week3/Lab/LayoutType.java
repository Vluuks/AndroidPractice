/*
    ...
*/
public enum LayoutType {
    DASH("\n---------------------\n", "|"), 
    CIRCLE("\no 0 o 0 o 0 o 0 o 0 o\n", "0"), 
    STAR("\n*********************\n", "*");
    
    String horizontalBorder, verticalBorder;
    
    // Constructor
    private LayoutType(String horizontalBorder, String verticalBorder) {
        this.horizontalBorder = horizontalBorder;
        this.verticalBorder = verticalBorder;
    }
}