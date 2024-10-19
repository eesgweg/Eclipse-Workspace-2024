package Practice;

public class SIB_IIB {

    static { // Static Initialization Block (SIB)
        System.out.println("Entering Static Initialization Block (SIB) - Will execute when JVM Starts for a class");
        System.out.println("Static Initialization Block (SIB)");
    }

    { // Instance Initialization Block (IIB)
        System.out.println("Entering Instance Initialization Block (IIB) - Will execute when a instance of class is created");
    }
    

    SIB_IIB() { // Constructor
        System.out.println("Entering Constructor - Everytime a instance is created Constructor will execute after IIB");
        System.out.println("Constructor");
    }

    public static void main(String[] args) { // Main Method
        System.out.println("Main Method");
        System.err.println("--------Code Starts--------");
        new SIB_IIB();
        System.err.println("---------Code Ends---------");
    }
    
    
    
    
    
    
    public void method1() {
    	System.out.println("Method1");
    }
    public static void method1(String a) {
    	System.out.println("Method1 with String "+ a);
    }
}
