import java.util.Random;

class SomeClass {
    
    static class A {}

    static class B extends A {}

    static class C extends B {}
   
    public static void doSomething() {
        
        Random r = new Random();
        int i = r.nextInt(6);
        
        switch(i) {
            case 0:
                int tmp1 = 80/0;
                break;
            case 1:
                Object o = new B();
                C c = (C) o;
                break;
            case 2:
                int[] arr = {0, 1, 2};
                int tmp2 = arr[5];
                break;
            case 3:
                B b = null;
                b.toString();
                break;
            case 4:
                String s = "foo";
                int tmp3 = Integer.parseInt(s);
                break;
            case 5:
                System.out.println("nothing wrong");
                break;
        }
    }
}

class ExceptionTestStaff {
    
    // The main method is the start of the program
    public static void main(String[] args) {
     
        // Call doSomething() multiple times to produce errors
        for(int i = 0; i < 50; i++) {
            try {
                SomeClass.doSomething();
            }
            catch(NullPointerException e) {
                e.printStackTrace();
            }
            catch(NumberFormatException e) {
                e.printStackTrace();
            }
            catch(ArithmeticException e) {
                e.printStackTrace();
            }
            catch(ClassCastException e) {
                e.printStackTrace();
            }
            catch(ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }  
    }
}
