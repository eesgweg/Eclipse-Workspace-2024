package CollectionsFW;

import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class test {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";

	public static void main(String[] args) {
		Class<?> clazz = test.class;
        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods[2].getName());
//        for(Method x : methods) {
//        	System.out.println(x.getName());
//        }
//        
	}
	
	public void A() {
		
	}
public void B() {
		
	}
public void C() {
	
}
}
