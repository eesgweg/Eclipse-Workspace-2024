package OOps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class programs {

	public static void StringSwap(String a, String b) {
		System.out.println("Before swap:");
		System.out.println("a = " + a);
		System.out.println("b = " + b);

		// Swap without using a third variable
		a = a + b; // Concatenate both
		b = a.substring(0, a.length() - b.length()); // Extract the original value of 'a
		a = a.substring(b.length()); // Extract the original value of 'b'

		System.out.println("After swap:");
		System.out.println("a = " + a);
		System.out.println("b = " + b);
	}

	public static void NumberSwap(int a, int b) {
		// swap integer without third variable
		a = a + b; // Step 1: Add both integers
		b = a - b; // Step 2: Subtract new 'b' from the result to get the original 'a'
		a = a - b;
		System.out.println("a =" + a);
		System.out.println("b =" + b);
	}

	public static void DuplicatesInString(String str) {
//		Duplicates in a string

		Set<Character> seen = new HashSet<Character>();
		Set<Character> duplicates = new HashSet<Character>();

		// Traverse the string
		for (char c : str.toCharArray()) {
			if (seen.contains(c)) {
				// If the character is already in 'seen', it is a duplicate
				duplicates.add(c);
			} else {
				// Otherwise, add it to 'seen'
				seen.add(c);
			}
		}
		System.out.println(seen);
		System.out.println(duplicates);
	}

	public static void FizzBuzz(int n) {
		// FizzBuzz
		int i = 1;
		while (i <= n) {
			if (i % 3 == 0 && i % 5 == 0) {
				System.out.println("FizzBuzz");
			} else if (i % 3 == 0) {
				System.out.println("Fizz");
			} else if (i % 5 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
			i++;
		}
	}

	public static void StringLength(String Str) {
		// Length of string without length function
		int length = 0;

		for (char i : Str.toCharArray()) {
			System.out.println(i);
			length += 1;
		}
		System.out.println("Length of " + Str + ": " + length);
	}

	public static void Reverse(String s) {
		// String Reverse without Reverse Function

		String v = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			v = v + s.charAt(i);
		}
		System.out.println("Reversed String: " + v);

	}

	public static void FibonacciSeries(int terms) {
//		Fibonacci series
		int a = 0, b = 1;
		System.out.print("Fibonacci Series up to " + terms + " terms: ");
		for (int i = 0; i < terms; i++) {
			System.out.print(a + " ");
			int next = a + b; // Calculate the next term
			a = b; // Update 'a' to the next term
			b = next; // Update 'b' to the next term
		}
		
	}

	public static void LargestNumberInaArray(Integer[] numbers) {
		// Largest no in a array:
//		Without Using Sort
		TreeSet<Integer> ts = new TreeSet<Integer>(Arrays.asList(numbers));
		System.out.println("Largest Number: " + ts.getLast());

//	Using Sort	
//		Arrays.sort(numbers);
//		System.out.println(numbers[(numbers.length)-1]);				
//		List<Integer> n = Arrays.asList(numbers);
//		System.out.println(Collections.max(n));
	}

	public static void RotationalArray(int k, int[] a) {

		List<Integer> al = new ArrayList<Integer>();
		for (int x : a) {
			al.add(x);
		}
		System.out.println("Orginal Array: " + al);
		Collections.reverse(al);
		List<Integer> al2 = al.subList(k, al.size());
		Collections.reverse(al2);
		List<Integer> cl = Stream.concat(al.subList(0, k).stream(), al2.stream()).collect(Collectors.toList());
		System.out.println("Rotational Array: " + cl);
	}

	public static void SortHashMapByValues(HashMap<String, Integer> map) {
		// Sort HashMap by Values
		System.out.println(map);
		List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
		System.out.println(list);
		list.sort(Map.Entry.comparingByValue());
		System.out.println(list);
		LinkedHashMap<String, Integer> lhmap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> x : list) {
			lhmap.put(x.getKey(), x.getValue());

		}
		System.out.println(lhmap);
	}

	public static void RightAngledTriangle_StarPattern(int rows) {
		// Right Angled Triangle
		// Number of rows

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void InvertedRightAngledTriangle_StarPattern(int rows) {
		// //Inverted Right angle triangle
		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public static void Pyramid_StarPattern(int rows) {
		// Pyramid
		for (int i = 1; i <= rows; i++) {
			for (int j = i; j < rows; j++) {
				System.out.print(" "); // Print spaces
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*"); // Print stars
			}

			System.out.println();
		}
	}

	public static void Diamond_StarPattern(int n) {
		// Upper half of the diamond
		for (int i = 1; i <= n; i++) {
			for (int j = i; j < n; j++) {
				System.out.print(" "); // Print spaces
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*"); // Print stars
			}
			System.out.println();
		}

		// Lower half of the diamond
		for (int i = n - 1; i >= 1; i--) {
			for (int j = n; j > i; j--) {
				System.out.print(" "); // Print spaces
			}
			for (int k = 1; k <= (2 * i - 1); k++) {
				System.out.print("*"); // Print stars
			}
			System.out.println();
		}
	}

	public static void OccururanceOfEachElement(List<Integer> LL) {
		// Find Occurance of each element in the list and remove duplicates

		List<Integer> L2 = new ArrayList<Integer>();
		for (int x : LL) {

			if (L2.contains(x)) {
				continue;
			} else {
				System.out.println(x + " - " + Collections.frequency(LL, x) + " Times");
				L2.add(x);
			}
		}
		System.out.println("Duplicates: " + L2);
	}

	public static void Union_Intersection(Set<Integer> Set1, Set<Integer> Set2) {
		// Union & Intersection

		Set<Integer> Intersection = new HashSet<Integer>();
		Set<Integer> Union = new HashSet<Integer>();
		for (int x : Set1) {
			Union.add(x);
			if (Set2.contains(x)) {
				Intersection.add(x);
			}
		}
		for (int y : Set2) {
			Union.add(y);
		}
		System.out.println(Union);
		System.out.println(Intersection);
	}

	public static void UniqueCharacters(String str) {
		// Distict Characters from a String and its count

		ArrayList<Character> cc = new ArrayList<Character>();
		for (char s : str.toCharArray()) {
			cc.add(s);

		}
		System.out.println(cc);
		long ccc = cc.stream().map(b -> Character.toUpperCase(b)).distinct().peek(b -> System.out.println(b)).count();
		System.out.println("Unique Characters in the String: " + ccc);
	}

	public static void StringCompare(String s1, String s2) {
		// Two Strings are not made up of same characters or not

		List<Character> Set1 = new ArrayList<Character>();
		for (char c1 : s1.toCharArray()) {
			Set1.add(c1);
		}
		List<Character> Set2 = new ArrayList<Character>();
		for (char c2 : s2.toCharArray()) {
			Set2.add(c2);
		}
		
		System.out.println(Set1);
		System.out.println(Set2);

		if (Set1.equals(Set2)) {
			System.out.println("Strings are made up of same characters");
		} else {
			System.out.println("Strings are not made up of same characters");
		}
	}
	
	public static void CharacterTypes(String Str) {
		int Alphabets=0,numbers=0,Spaces=0,Alphanumeric=0,UppercaseAlphabets=0,Lowercasealphabets=0;
		for(char x : Str.toCharArray()) {
			if(Character.isAlphabetic(x)) {
				Alphabets++;
				if(Character.isUpperCase(x)) {
					UppercaseAlphabets++;
				}else {
					Lowercasealphabets++;
				}
			}else if(Character.isWhitespace(x)) {
				Spaces++;
			}else if(Character.isDigit(x)) {
				numbers++;
			}else {
				Alphanumeric++;
			}
			
		}
		System.err.println(" Alphabets: "+Alphabets+"\n numbers: "+numbers+
				"\n Spaces: "+Spaces+"\n Alphanumeric: "+Alphanumeric 
				+"\n UppercaseAlphabets: "+UppercaseAlphabets+"\n Lowercasealphabets: "+Lowercasealphabets);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// swap strings without 3rd variable
//		StringSwap("Hello","World");
//		NumberSwap(10,20);
//		DuplicatesInString("Programming");
//		FizzBuzz(100);
//		StringLength("Programming");
//		Reverse("Programming");
//		FibonacciSeries(10);
//		Integer[] numbers = {3, 5, 7, 2, 8, 6, 1};
//		LargestNumberInaArray(numbers);
//		int[] a = {1,2,3,4,5,6,7};
//		RotationalArray(3,a);
//		HashMap<String, Integer> map = new HashMap<>();
//        map.put("A", 3);
//        map.put("B", 1);
//        map.put("C", 2);
//		SortHashMapByValues(map);
//		int rows = 5;
//		RightAngledTriangle_StarPattern(rows);
//		InvertedRightAngledTriangle_StarPattern(rows);
//		Pyramid_StarPattern(rows);
//		Diamond_StarPattern(rows);
//		List<Integer> LL = List.of(7,8,7,9,8,4,0,8,4,5);
//		OccururanceOfEachElement(LL);
//		Set<Integer> Set1 = Set.of(1, 2, 3, 4, 5);
//		Set<Integer> Set2 = Set.of(4, 5, 6, 7);
  //      Union_Intersection(Set1,Set2);
		//CharacterTypes("sfegEn568#^ &DaGA ");

////Convert CamelCase to SnakeCase
//String Camelcase ="MyNameIsMani";
//String SnakeCase ="";
//for(char x:Camelcase.toCharArray()) {
//	if(Character.isUpperCase(x)) {
//		SnakeCase+="_"+x;
//	}else {
//		SnakeCase+=x;
//	}
//}
//System.out.println("Camelcase: "+Camelcase);
//System.out.println("SnakeCase: "+SnakeCase.substring(1));

//print count common numbers in a array
List<Integer> a = new ArrayList<Integer>(Arrays.asList(5,3,4));
Set<Integer> dummy = new HashSet<Integer>();
for(int x:a) {
	int count = Collections.frequency(a,x);
	if(count > 1 & dummy.contains(x) == false) {
		System.out.println(x+" = "+Collections.frequency(a,x)+" times");
		dummy.add(x);
	}

}
		
		
		
	}
}
