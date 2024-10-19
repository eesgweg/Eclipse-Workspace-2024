package CollectionsFW;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import CollectionsFW.Collections_Framework.game;

public class test {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";

	public static void main(String[] args) throws InterruptedException {
//		Class<?> clazz = Collections_Framework.class;
//        Method[] methods = clazz.getDeclaredMethods();
//        List<Method> Methods = new ArrayList<Method>();
//        for(Method method : methods) {
//        	if (!method.getName().contains("$")) {
//        		System.out.println(method.getName());
//            }
//        }

//		Matcher matcher;
//		Pattern CompiledPattern;
//		List<String> MailIDs = new ArrayList<String>();
//		MailIDs.add("rainamani.444@gmail.com");
//		MailIDs.add("abc123gmail.com");
//		MailIDs.add("swatsmani.1110@gmail.com");
//		String ptrn = "@gmail.com";
//		CompiledPattern = Pattern.compile(ptrn);
//
//		for (String x : MailIDs) {
//			matcher = CompiledPattern.matcher(x);
//			if(matcher.find()) {
//				System.out.println(matcher.start() + " : " + matcher.end());
//			}
//
//		}

//		List<String> names = Arrays.asList("Sara", "John", "Paul");
//		// API Stream For Each
//		names.forEach(name -> System.out.println(name));
//		names.stream().limit(names.size()).forEach(name -> {
//			System.out.println(name);
//		});
//
//		HashMap<Integer, String> mp = new HashMap<Integer, String>();
//		mp.put(1, "BLUE");
//		mp.put(2, "RED");
//		mp.put(3, "GREEN");
//		mp.forEach((k, v) -> {
//			if (v.contains("B")) { // Check if the value (String) contains "B"
//				System.out.println(k + " : " + v); // Print key and value
//			}
//		});
//		
//		// API Stream - Filter
//		names.stream().filter(n -> n.contains("a")).forEach(n -> System.out.println(n + " is 'A' category"));
//		
//		//API Stream - Map
//		names.stream().map(n -> n+"_AAA").forEach(n -> System.out.println(n));
//		names.stream().filter(n -> n.contains("a")).map(n -> n+"_AAA").forEach(n -> System.out.println(n));
		
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Enter First number:");
//		String s1 = scanner.nextLine();
//		System.out.println("Enter Second Word:");
//		String s2 = scanner.nextLine();
//		System.out.println(s1+s2);

//		Stack<String> s = new Stack<String>();
//		s.add("a");s.add("g");s.add("f");
//		System.out.println(s);
//		System.out.println(s.search("a")+" _ "+s.search("g")+" _ "+s.search("f"));
//		s.addElement("S");
//		System.out.println(s);
//		s.addFirst("X");
//		s.addLast("T");
//		System.out.println(s);
//		
//		Vector<Integer> v = new Vector<Integer>();
//		v.add(5);v.add(7);v.add(1);
//		System.out.println(v);
//		System.out.println(v.capacity());;
//		
//		BlockingQueue<Integer> bq = new ArrayBlockingQueue<Integer>(5);
//		bq.addAll(v);
//		System.out.println(bq);
//		bq.put(22);
//		System.out.println(bq);
//		bq.take();
//		System.out.println(bq);
//		bq.take();
//		System.out.println(bq);
//		bq.offer(34, 5, TimeUnit.SECONDS);
//		System.out.println(bq);
	
	
	//	Java Program to Get the Maximum Element From a Vector
//		Vector<Integer> v = new Vector<Integer>();
//		v.add(5);v.add(7);v.add(1);
//		System.out.println("vector: "+v);
//		System.out.println("Max: "+Collections.max(v));
//		
//		//Binary Search on Java Vector
//		Collections.sort(v);
//		System.out.println("vector: "+v);
//		System.out.println("binary search: "+Collections.binarySearch(v, 5));
//		Collection<Integer> vv = null;
//		//Readonly
//		try {
//		 vv = Collections.unmodifiableCollection(v);
//		vv.add(55);
//		}catch(Exception e) {
//			e.printStackTrace();
//			Vector<Integer> newv = new Vector<Integer>(vv);
//			newv.add(55);
//			System.out.println(newv);
//		}
		
		// Creating an empty hashtable 
        Hashtable<String, String> ht 
            = new Hashtable<String, String>(); 
  
        // Inserting key-value pairs into hash table 
        // using put() method 
//        ht.put("Name", "Rohan"); 
//        ht.put("Age", "23"); 
//        ht.put("Address", "India"); 
//        ht.put("Article", "GeeksforGeeks"); 
//        System.out.println(ht);
//        
//        Enumeration<String> e = ht.keys();
//        Enumeration<String> eq = ht.elements();
//        
//        while(e.hasMoreElements() && eq.hasMoreElements()) {
//        	String key=e.nextElement();      	
//        	System.out.println(key);
//        	String value=eq.nextElement();
//        	System.err.println(value);
//
//        }
        
        //Rotation of List
//        Integer[] a = {10, 20, 30, 40, 50, 60, 70};
//        List<Integer> li = new ArrayList<Integer>(Arrays.asList(a));
//        int n = 4;
//        System.out.println("Original List: "+li);
//       Collections.reverse(li);
//       System.out.println("Rotational List: "+ Stream.concat(li.subList(0, n).reversed().stream(), li.subList(n, li.size()).reversed().stream())
//    		   .collect(Collectors.toList()));
		
       
       String ab ="mani@gmail.com";
       System.out.println(ab.matches("^[a-zA-Z]+@gmail.com$"));
       String a2 = "MB_2024_,a";
       System.out.println(a2.matches("^[A-Z]{2}_[0-9]{4}_[@/,]{1}[a-z]{1}$"));
       
       String A = "Wg6w&%8EFubw";
     for(char c : A.toCharArray()) {
    	 if((c+"").matches("^[A-Z]*")) {
    		 System.out.println(c);
    	 }else if((c+"").matches("^[a-z]*")){
    		 System.err.println(c);
    	 }else if((c+"").matches("^[0-9]*")){
    		 System.out.println("\""+c+"\"");
    		 System.out.println("\n");
    	 }
     }
		
			}
	public void A() {
		}

	public void B() {

	}

	public void C() {

	}
}
