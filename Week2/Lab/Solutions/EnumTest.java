/* 
     Native App Studio Course UvA
     Class showing the use of an enum in Java
     
     To compile: javac EnumTest.java
     To run: java EnumTest
     
*/

class EnumTest {
    
    private enum Shape { 
        RECTANGLE, CIRCLE, TRIANGLE, SQUARE;
    }
    
    // The main method is the start of the program
    public static void main(String[] args) {

        Shape shapeToShow = Shape.CIRCLE;
        
        switch(shapeToShow) {
            case RECTANGLE: System.out.println("It's a rectangle!");     
                            break;
            case CIRCLE:    System.out.println("It's a circle!");
                            break;
            case TRIANGLE:  System.out.println("It's a triangle!");
                            break;
            case SQUARE:    System.out.println("It's a square!");
                            break;
        }
    }
}