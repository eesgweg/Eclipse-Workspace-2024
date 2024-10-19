package LeecodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.math3.exception.NullArgumentException;

public class Programs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Middle element of linked list
//		List<Integer> a = new LinkedList<Integer>(Arrays.asList(2,7,11,15,22,3));
//		int size = a.size();
//		System.out.println(size);
//		System.out.println(size/2);
//		System.out.println("Middle Element : "a.get(size/2))
		
		//Print 1 to 20 using continue which only divides by 2
//		for(int i=1;i<=20;i++) {
//			if(i%2 != 0) {
//				continue;
//			}
//			System.out.println(i);
//		
		//Anagram
//		String a1 = "mad am";
//		String a2 = "mada m";
//		List<Character> a1set = new LinkedList<Character>();
//		List<Character> a2set = new LinkedList<Character>();
//		for(char x: a1.toCharArray()) {
//			if(x == ' ') {
//				
//			}else {
//			a1set.add(Character.toUpperCase(x));
//			}
//		}
//		for(char y: a2.toCharArray()) {
//			if(y == ' ') {
//				
//			}else {
//			a2set.add(Character.toUpperCase(y));
//			}
//		}
		
//		Collections.sort(a1set);
//		Collections.sort(a2set);
//		
//		System.out.println(a1set);
//		System.out.println(a2set);
//		if(a1set.equals(a2set)) {
//			System.out.println("Anagram");
//		}else {
//			System.out.println("Not Anagram");
//		}
		
		
		System.out.print("a");  
	      try {  
	         System.out.print("b");  
	         throw new NullArgumentException();  
	      }   
	      catch (RuntimeException e) {  
	         System.out.print("c");  
	      }   
	      finally  {  
	         System.out.print("d");  
	      }  
	      System.out.print("e");  
	   }  
		
//		try {
//			System.out.println("1");
//			throw new ClassNotFoundException("ClassNotFoundException");
//		}catch (Throwable e) {
//			System.out.println("2");
//			System.out.println(e.getMessage());
//		
//		}finally {
//			System.out.println("4");
//		}
//		
		
//		Set<Integer> indices = new HashSet<Integer>();
//		int target = 18;
//		for(int x : a) {
//			for(int y: a) {
//				if(x+y ==target) {
//					indices.add(x);
//					indices.add(y);
//				}
//				
//			}
//		}
//		System.out.println(indices);
		
//		//Length of longest substring without repeating characters 
//		String orginal = "abcabcdabcda";
//		Set<Character> StringWithoutDuplicateChars = new LinkedHashSet<Character>();
//	//	List<Character> dump = new ArrayList<Character>();
//		for(char x1:orginal.toCharArray()) {
//			
//				StringWithoutDuplicateChars.add(x1);
//				
//			
//			
//		}
//		System.out.println(StringWithoutDuplicateChars);
//		String longestsubstring ="";
//		for(char yy : StringWithoutDuplicateChars) {
//			longestsubstring+=yy;
//		}
//		System.out.println(longestsubstring+" : "+longestsubstring.length());
		
		
		//First Unique Character
		String str1 = "aabb";
//		Set<Character> ch = new LinkedHashSet<Character>();
//		for(char x : str1.toCharArray()) {
//			ch.add(x);
//		}
//		System.out.println(ch);
//		List<Character> ls = new LinkedList<Character>();
//		System.out.println(ls.getFirst());
//		for(char c1:str1.toCharArray()) {
//			ls.add(c1);
//		}
//		System.out.println(ls);
//		for(int i=0;i<ls.size();i++) {
//			List<Character> ls2 = new LinkedList<Character>();
//			for(int j=0;j<ls.size();j++) {
//				if(i==j) {
//					
//				}else {
//					ls2.add(ls.get(j));	
//				}
//							
//			//	
//			}
//			//System.out.println(ls2);
//			if(!ls2.contains(ls.get(i))) {
//				System.out.println(ls.get(i));
//			}else {
//				System.out.println(-1);
//			}
//			ls2.clear();
//		}
		
//		
		}
		
		
	
	
	


