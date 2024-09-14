package CollectionsFW;

import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class Collections_Framework {
	public static final String RESET = "\u001B[0m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String MAGENTA = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	//public List<Integer> myList;
	
	enum game{
		CRICEKT,HOCKEY,FOOTBALL,SWIMMING;
	}
	
	@Test(groups = "Lists")
	public void List() {
		/*------------LIST---------------------*/
		List<Integer> myList = List.of(3, 6, 2, 5, 0, 8,22,33,55);		
		List<Integer> dummy1 = new ArrayList<Integer>(Arrays.asList(3, 6, 2, 5, 0, 8,22,33,55));
		System.out.println("Dummy1: " + myList);
		List<Integer> dummy2 = new ArrayList<Integer>(Arrays.asList(22,33,55));
		dummy1.removeAll(dummy2);
		System.out.println("Dummy1 list with removed values from Dummy2 list: " + dummy1);
//		// Adding Elements to the lists
		ArrayList<Integer> myArrayList = new ArrayList<Integer>();
		myArrayList.add(3);
		myArrayList.add(6);
		myArrayList.add(2);
		myArrayList.add(5);
		myArrayList.add(0);
		myArrayList.add(8);
		System.out.println("ArrayList: " + myArrayList);
		myArrayList.set(0, 10);
		System.out.println("ArrayList after setting a vvalue as per Index: " + myArrayList);
		LinkedList<Integer> myLinkedList = new LinkedList<Integer>();
		myLinkedList.add(3);
		myLinkedList.add(6);
		myLinkedList.add(2);
		myLinkedList.add(5);
		myLinkedList.add(0);
		myLinkedList.add(8);
		System.out.println("LinkedList: " + myLinkedList);
		// Searching
		System.out.println("ArrayList - Element at index 3: " + myArrayList.get(3));
		System.out.println("ArrayList - First Element: " + myArrayList.getFirst());
		System.out.println("ArrayList - Last Element: " + myArrayList.getLast());
		System.out.println("LinkedList - Element at index 3: " + myLinkedList.get(3));
		System.out.println("LinkedList - First Element: " + myLinkedList.getFirst());
		System.out.println("LinkedList - Last Element: " + myLinkedList.getLast());
		System.out.println("Boolean Value of ArrayList of Finding '6' Element: "+myArrayList.contains(6));
		System.out.println("Boolean Value of LinkedList of Finding '88' Element: "+myLinkedList.contains(88));
		// Insert and Delete Records
		myArrayList.add(4); // Element is added
		System.out.println("Added 4 to ArrayList: " + myArrayList);
		myArrayList.remove(6); // Index is used to remove element
		System.out.println("Removed 6th index element from ArrayList: " + myArrayList);
		// Insert and Delete Records
		myLinkedList.add(4); // Element is added
		System.out.println("Added 4 to LinkedList: " + myLinkedList);
		myLinkedList.remove(6); // Index is used to remove element
		System.out.println("Removed 6th index element from LinkedList: " + myLinkedList);
		//Sorting		
		Collections.sort(myArrayList);
		System.out.println("Sorted ArrayList: "+myArrayList);
		Collections.sort(myLinkedList);
		System.out.println("Sorted Linkedlist: "+myLinkedList);
		//Empty the Array
		myArrayList.clear();
		myLinkedList.clear();
		if(myArrayList.isEmpty() && myLinkedList.isEmpty()) {
			System.out.println("ArrayList and LinkedList Are Empty");
		}
		ListIterator<Integer> myListIterator = myList.listIterator();
		System.out.println(RED+"Get Next Element in the List: "+RESET+myListIterator.next());
		System.out.println(RED+"Get Index of Next Element in the List: "+RESET+myListIterator.nextIndex());
		System.out.println("Get Index of Previous Element in the List: "+myListIterator.previousIndex());
		System.out.println("Verify if the List has a next element from current Iterator Index: "+myListIterator.hasNext());
		System.out.println("Verify if the List has a previous element from current Iterator Index: "+myListIterator.hasPrevious());	
		List<String> list = new ArrayList<>(Arrays.asList("Apple", "Banana", "Cherry"));
        ListIterator<String> iterator = list.listIterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            if (fruit.equals("Banana")) {
                iterator.remove(); // Removes "Banana"
            }
            
        }
        System.out.println(RED+"Removed Banana from the List: "+RESET+list);
	}
	
	@Test(groups = "Map")
	public void Maps() {
		/*------------MAP---------------------*/
		Map<Integer,Integer> LHM = new LinkedHashMap<Integer, Integer>(2, 0.8f, true);
		try {
			LHM.put(1, 1);	LHM.put(3, 3);
			LHM.put(2, 2); 	LHM.put(4, 4); 	
			LHM.put(5, 5);
		}catch (Exception e) {
			System.out.println("5th element cant be added as Capacity is ");
			System.out.println(LHM);
		}
		System.out.println(LHM);
		System.out.println("6 is not there in Map so returning default: "+LHM.getOrDefault(6, 99));
		
		WeakHashMap<String, Integer> WHM = new WeakHashMap<String, Integer>();
		String key1 = new String("Two");//String Object Reference
		int value1 = 1;
		WHM.put(key1, value1);
		System.out.println(WHM);
		key1 = null; // Making Key1 object to null
		System.gc();
		System.out.println("WeakHashMap Post Garbage Clear: "+WHM);
		
		EnumMap<game, String> EM = new EnumMap<>(game.class);
		EM.put(game.CRICEKT, "Virat");
		EM.put(game.FOOTBALL, "Messi");
		EM.put(game.SWIMMING, "Phelips");
		System.out.println("EnumMap: "+EM);
		System.out.println("Get Enum Key Value of Cricket: "+EM.get(game.CRICEKT));
		EM.replace(game.FOOTBALL, "Messi");
		System.out.println("EnumMap post replace: "+EM);
		System.out.println(EM.replace(game.CRICEKT, "Dhoni", "Sachin"));
		System.out.println(EM.replace(game.CRICEKT, "Virat", "Sachin"));
		System.out.println("Replaced by condition of old value EnumMap: "+EM);
		
		Map<Integer,String> myMap= Map.of(1,"George",2,"Mathew",3,"hi",4,"hello");			
		System.out.println(myMap);
		HashMap<Integer,String> myhashmap = new HashMap<Integer, String>();
		myhashmap.putAll(myMap);
		TreeMap<Integer,String> myTreeMap = new TreeMap<Integer,String>();
		myTreeMap.put(2,"MMdwd");
		System.out.println("TreeMap before Putall: "+myTreeMap);
		myTreeMap.putAll(myhashmap);
		System.out.println("TreeMap After Putall : "+myTreeMap);
		System.out.println("FirstKey of the TreeMap: "+myTreeMap.firstKey());
		System.out.println("LastKey of the TreeMap: "+myTreeMap.lastKey());
		System.out.println("FirstEntry of the TreeMap: "+myTreeMap.firstEntry());
		System.out.println("LastEntry of the TreeMap: "+myTreeMap.lastEntry());
		System.out.println(myTreeMap.putIfAbsent(7, "sfag"));
		System.out.println("TreeMap before putIfAbsent: "+myTreeMap);
		System.out.println(myTreeMap.comparator());
		System.out.println(myTreeMap.tailMap(3));
		System.out.println(myTreeMap.headMap(3));
		System.out.println(myTreeMap.subMap(2, 4));
		
		NavigableMap<Integer, Integer> NM = new TreeMap<Integer, Integer>();
		for(int nmi=6;nmi>=0;nmi--) {
			NM.put(nmi, nmi);
		}
		System.out.println("NavigableMap: "+NM);
		System.out.println("Head Map with 2 Key excluded: "+NM.headMap(2, false));
		System.out.println("Tail Map with 2 Key Included: "+NM.tailMap(2, true));
		System.out.println("Sub Map with 3 Key Included and 6 key excluded: "+NM.subMap(3, true, 6, false));
		NM.put(10, 10);
		NM.put(9, 9);
		System.out.println("Returns the lowest key among those keys that are greater than or equal to the specified key: "+NM.ceilingKey(7));
		System.out.println("returns an entry with the highest key "
				+ "among all those entries whose keys are less than or equal to the specified key: "+NM.floorKey(11));
		System.out.println("reverse the order of entries in a map: "+NM.descendingMap());
		System.out.println("reverse the order of keys in a map: "+NM.descendingKeySet());
		System.out.println("NextHighestKey in the map after 3 Key: : "+NM.higherKey(3));
		System.out.println("NextLowestKey in the map after 3 Key: : "+NM.lowerKey(3));
		System.out.println("NextHighest entry in the map after 2 Key: : "+NM.higherEntry(2));
		System.out.println("NextLowest Entry in the map after 2 Key: : "+NM.lowerEntry(2));
		System.out.println("Poll First Entry: "+NM.pollFirstEntry());
		System.out.println("Poll Last Entry: "+NM.pollLastEntry());
		System.out.println("NavigableMap: "+NM);
		
		ConcurrentHashMap<Integer, Integer> CM = new ConcurrentHashMap<Integer, Integer>();
		CM.put(1, 11);		CM.put(2, 22);		CM.put(3, 33);
		System.out.println(CM);
		CM.forEach(4,(k,v) -> System.out.println(Math.multiplyExact(k, 2)+" : "+Math.addExact(k, v)));
		int sum = CM.reduce(4, (k, v) -> v, (v1, v2) -> v1 + v2);
		System.out.println("Sum of all values: " + sum);
		int just = CM.reduce(4, (k, v) -> k, (k1, k2) -> Math.addExact(Math.addExact(k1, k2), k2));
		System.out.println(just);		
		for(Entry<Integer, Integer> g : CM.entrySet()) {
			System.out.println(g.getKey().compareTo(11));
		}		
		myTreeMap.replaceAll((key,value) -> value.concat("-00"));
		System.out.println("TreeMap after ReplaceALL: "+myTreeMap);
		System.out.println(myhashmap);
		System.out.println(myhashmap.keySet());
		System.out.println(myhashmap.values());
		System.out.println(myhashmap.entrySet());
		System.out.println(myhashmap.containsKey(1));
		System.out.println(myhashmap.containsValue("Mathew"));
		myhashmap.put(0, "gbkbh");
		System.out.println(myhashmap);
		myhashmap.remove(3);
		System.out.println(myhashmap);
		myhashmap.replace(4, "SSSS");
		System.out.println(myhashmap);
	}
	
	@Test(groups = "Sets")
	public void Set() {
		/*------------SET---------------------*/
		Set<Integer> myset = Set.of(1,2,3,5);
		System.out.println("Set: "+myset);
		List<Integer> myList = List.of(3, 6, 2, 5, 0, 8,22,33,55);	
		TreeSet<Integer> myTreeSet = new TreeSet<Integer>(myList);
		System.out.println("Set Converted from List-Sorted: "+myTreeSet);
		System.out.println("Set Contains Value 5 -- Boolean : "+myTreeSet.contains(5));
		myTreeSet.add(4);
		System.out.println("Add 4 to the Set: "+myTreeSet);
		myTreeSet.remove(5);
		System.out.println("Remove 5 from the Set: "+myTreeSet);
		System.out.println("First element: "+myTreeSet.first()); System.out.println("Last element: "+myTreeSet.last());
		System.out.println("Poll First element: "+myTreeSet.pollFirst());System.out.println("Remove First element: "+myTreeSet.removeFirst());
		System.out.println("Set: "+myTreeSet);
		System.out.println("Poll Last element: "+myTreeSet.pollLast());System.out.println("Remove Last element: "+myTreeSet.removeLast());
		System.out.println("Set: "+myTreeSet);
		Object m = myTreeSet.clone();
		System.out.println("Çloned Set: "+m);
		myTreeSet.clear();
		System.out.println("Set: "+myTreeSet);

	}
	
	@Test(groups = "Stacks")
	public void Stacks() {
		// Stacks
		System.out.println(RED+"----------STACK--------------"+RESET);
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(1);stack.add(2);stack.add(3);
		System.out.println("Stack: "+stack);
		stack.push(10);
		System.out.println("Stack: "+stack);
		System.out.println("Stack Pop - Removed Top element: "+stack.pop());
		int ele = stack.peek();
		System.out.println("Stack Peek - Retrieves Top element: "+ele);
		System.out.println("Stack: "+stack);
		System.out.println("Stack Search 2 Element which returns the imdex of 2 : "+stack.search(2));
		System.out.println("Stack Empty Check: "+stack.empty());
		stack.pop();stack.pop();stack.pop();
		System.out.println("Stack Empty Check: "+stack.empty());
	}
	
	@Test(groups = "QueueDequeue")
	public void Queues() {
		/*------------QUEUES---------------------*/
//		 LinkedList implementation of Queue
		Queue<String> animal1 = new LinkedList<>();
		animal1.add("A");animal1.add("B");animal1.add("C");
		System.out.println("Queue Implemented Linked List: "+animal1);		
		// Array implementation of Queue
		Queue<String> animal2 = new ArrayDeque<>();
		// Priority Queue implementation of Queue
		Queue<String> animal3 = new PriorityQueue<>();
		if(animal3.poll() == null && animal3.peek() == null) {System.out.println("Peek and Poll returned Null value as queue is empty");};
		try {
			animal3.element();
			animal3.remove();
		}catch (Exception e) {
			System.out.println("Element and Remove throwed exception as queue is empty");
		}
		animal3.add("D");
		animal3.add("M");
		animal3.add("A");
		animal3.add("S");
		System.out.println("Priority Queue: "+animal3+RED+" - always the head of the queue will be the Smallest in the queue(Auto Rearrange)"+RESET);
		System.out.print("Ascending Order Retrival in Priority Queue: ");
		System.out.println();
		Iterator<String> qi = animal3.iterator();
		while(qi.hasNext()) {
			System.out.print(animal3.poll());
		}
		System.out.println();
		System.out.println("Priority Queue emptied: "+animal3);
		System.out.println("Priority Queue Contains A: "+animal3.contains("A"));

//		ConcurrentLinkedQueue Implementation of Queue
		Queue<Integer> myqueue = new ConcurrentLinkedQueue<Integer>();
		myqueue.add(1);
		myqueue.add(2);
		myqueue.add(3);
		myqueue.add(4);
		System.out.println(myqueue);
		myqueue.poll();
		System.out.println(myqueue);
		System.out.println("myqueue.remove(): "+myqueue.remove());
		System.out.println(myqueue);
		myqueue.add(1);
		System.out.println(myqueue);
		myqueue.remove(4);
		System.out.println(myqueue);
		System.out.println(myqueue.contains(3));
		myqueue.offer(10);
		System.out.println(myqueue);
		System.out.println(myqueue.peek());
		Deque<Integer> D1 = new ArrayDeque<Integer>();
		Deque<Integer> D2 = new LinkedList<Integer>();
		D1.addFirst(10);
		D1.addLast(1);
		D2.addFirst(10);
		D2.addLast(1);
		System.out.println("Dequeue - ArrayDeque Implemented - "+D1);
		System.out.println("Dequeue - LinkedList Implemented - "+D1);
		D1.addFirst(8);
		D1.addLast(4);
		D2.addFirst(7);
		D2.addLast(3);
		System.out.println("D1 - "+D1);
		System.out.println("D2 - "+D2);
		D1.pollFirst();
		D2.removeFirst();
		System.out.println("D1 - "+D1);
		System.out.println("D2 - "+D2);
		int p1=D1.peekLast();
		int p2=D2.peekLast();
		System.out.println("D1 Peeked Last Element - "+p1);
		System.out.println("D2 Peeked Last Element- "+p2);
		System.out.println("D1 - "+D1);
		System.out.println("D2 - "+D2);
		int g1=D1.getFirst();
		int g2=D2.getLast();
		System.out.println("D1 Get First Element - "+g1);
		System.out.println("D2 Get Last Element- "+g2);
		System.out.println("D1 - "+D1);
		System.out.println("D2 - "+D2);
		Iterator<Integer> desiterator = D1.descendingIterator();
		System.out.println("ArrayList Descending Iterator of D1");
		while(desiterator.hasNext()) {
			System.out.println(desiterator.next());
		}
		BlockingQueue<Integer> Bq1 = new ArrayBlockingQueue<Integer>(5);
		BlockingQueue<Integer> Bq2 = new LinkedBlockingDeque<Integer>();
		try {
			Bq1.put(1);
			Bq1.put(2);
			Bq1.put(3);
			Bq1.put(4);
			Bq1.put(5);
			Bq1.offer(6, 5, TimeUnit.SECONDS);
			Bq1.take();

		} catch (Exception e) {

			System.out.println("Queue is Full");
		} finally {
			System.out.println("Tried to Insert 6 for 5 seconds amd unable to so it returned false");
			System.out.println("Blocking Queue: " + Bq1);
		}
	}
	
	@Test(groups = "CollectionsUtlity")
	public void CollectionsUtility() {
		//Collections Utility		
		List<String> list = Arrays.asList("Dhoni","Andrew", "Kholi","Watson");
		Collections.sort(list);
		System.out.println("Sorted List: "+list);
		Collections.reverse(list);
		System.out.println("Reverse List: "+list);
		System.out.println("Minimum element from List: "+Collections.min(list));
		System.out.println("Maximum element from List: "+Collections.max(list));
		List<String> list1 = Collections.nCopies(3, "Cricket");
		System.out.println("Ncopies List: "+list1);
		int frequency = Collections.frequency(list1, "Cricket");
		System.out.println("Frequency of occurance of Cricket in the list: "+frequency);
		List<String> src = Arrays.asList("a", "b", "c");
		List<String> dest = new ArrayList<>(Arrays.asList("", "", ""));
		Collections.copy(dest, src);
		System.out.println(dest);
	}
	
	
	@Test(groups = "ArraysUtility")
	public void ArraysUtlitity() {
		//Array Utlity		
		List<String> list2 = Arrays.asList("a", "b", "a", "c");		
		int[] numbers = {4, 2, 7, 1};
		Arrays.sort(numbers);
		System.out.print("Sorted Array Values: {");
		for(int x : numbers) {System.out.print(x);}
		System.out.println();
		System.out.println("Index of 2 is : "+Arrays.binarySearch(numbers, 2));
		int[] array1 = {1, 2, 3};
		int[] array2 = {1, 2, 3,3};
		boolean areEqual = Arrays.equals(array1, array2);		
		System.out.println("Boolean Value of Comparison of Array1 and Array 2 is "+areEqual);
		int[] numbers1 = new int[5];
		Arrays.fill(numbers1, 9);
		System.out.print("Filled Array Values: ");
		for(int y : numbers1) {System.out.print(y);}
	}
	
	@Test(groups = "Conversions")
	public void ConversionsOfCollections() {
	//String Array
		String[] cricket = { "Dhoni", "Andrew", "Kholi", "Watson" };
	// Converting String Array to List
		List<String> CricketList = Arrays.asList(cricket);
		System.out.println("Array to Converted String List: " + CricketList);
	//Integer Array				
		Integer[] num = {1,2,3,4};
	// Converting Integer Array to List
		List<Integer> num_list = Arrays.asList(num);
		System.out.println("Array to Converted Integer List: " + num_list);
	
	// Converting List to Set(Auto Sorted)
		TreeSet<String> CricketTreeSet = new TreeSet<String>(CricketList);
		System.out.println("List to Converted Sorted Set:  " + CricketTreeSet);

	//Converting Set To Array
		Object[] CricketArray=CricketTreeSet.toArray();
		System.out.println("Set Converted Array: " + CricketArray);
		
	//Array to Hashmap	
		HashMap<Integer, String> CricketMap= new HashMap<Integer, String>();
		int index =0;
		for(Object x:CricketArray) {
			CricketMap.put(index, x.toString());
			index++;
		}
		System.out.println("Array to converted Hashmap: "+CricketMap);
	}
	
	@Test(groups = "Streams")
	public void APIStreams() {
		List<Integer> li = List.of(1,3,6,2,5,4,2,1);
		Stream<Integer> stream = li.stream();
		System.out.println(stream);
		System.err.println("---- sorted().distinct()---------");
		stream.sorted().distinct().forEach(System.out::println);
		System.err.println("---- filter()---------");
		li.stream().filter(n -> n%2 == 0).forEach(System.out::print);
		 System.out.println();
		System.err.println("---- peek() and limit(3)---------");
		li.stream().peek(n ->  System.out.println("Peeking: "+n)).limit(3).forEach(System.out::println);
        System.err.println("---- skip()---------");
		li.stream().skip(3).forEach(System.out::println);
		System.err.println("---- reduce()---------");		
		int sum = li.stream().reduce(2,(a,b) -> a+b);
		System.out.println(sum);		
		Set<Integer> Convertedset =li.stream().collect(Collectors.toSet());
		System.out.println("Convertedset: "+Convertedset);	
		System.err.println(Convertedset.stream().allMatch(n -> n%2 == 0));
		System.err.println(Convertedset.stream().anyMatch(n -> n%2 == 1));
		System.err.println(Convertedset.stream().noneMatch(n -> n%5 == 0));
		System.err.println("------ Map()---------");
		Convertedset.stream().map(n -> n*2).forEach(System.out::println);
	}

}
