package JavaConcepts;

import java.util.ArrayList;
import java.util.List;

public class StaticNonStatic {
	
	public static void Staticmethod() {
		System.out.println("Staticmethod");	
		
	}
	
	public void NonStaticmethod() {		
		System.out.println("NonStaticmethod");
	}
	
	public static void main(String[] args) {
//		StaticNonStatic SC = new StaticNonStatic();
//		SC.NonStaticmethod();
//		Staticmethod();
		
		String ab ="MANIBH";
		System.out.println(ab.substring(0,2));
		
		List<Integer> a = new ArrayList<Integer>();
		a.add(2);a.add(5);a.add(7);a.add(8);
		System.out.println(a.subList(0, a.size()));
	 }

}
