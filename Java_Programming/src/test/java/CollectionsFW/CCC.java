package CollectionsFW;
import java.util.*;import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CCC {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		List<String> ArrayList = new ArrayList<String>(Arrays.asList("a","z","b","n","d"));
//		System.out.println(ArrayList);
//		ArrayList.set(0, "X");
//		System.out.println(ArrayList);
//		
//		List<String> LinkedList = new LinkedList<String>();
//		LinkedList.add(0, "A");LinkedList.add(1, "I");
//		LinkedList.addAll(ArrayList);
//		System.out.println(LinkedList);
//		LinkedList.removeAll(ArrayList);
//		System.out.println(LinkedList);
//		
//		Set<Integer> Hashset = new HashSet<Integer>(Arrays.asList(33,11,69,05,35));
//		System.out.println(Hashset);
//		TreeSet<Integer> Treeset = new TreeSet<Integer>(Hashset);
//		System.out.println(Treeset);
//		Treeset.add(11);
//		System.out.println(Treeset);
//		Treeset.add(4);
//		System.out.println(Treeset);
//		
		
//		Queue<Integer> priorityqueue = new PriorityQueue<Integer>();
//		Deque<Integer> Arraydeque = new ArrayDeque<Integer>();
//		int[] data = {1,5,3,7,0,2};
//		for(int x: data) {
//			priorityqueue.add(x);
//			Arraydeque.add(x);
//			System.out.println(priorityqueue);
//			System.err.println(Arraydeque);
//		}
//		System.out.println(Arraydeque.remove(9));
//		System.out.println(priorityqueue.peek());
//		priorityqueue.poll();
//		System.out.println(priorityqueue);		
//		priorityqueue.offer(10);
//		System.out.println(priorityqueue);
//		priorityqueue.poll();
//		System.out.println(priorityqueue);	
		
		
		
//		Map<Integer,String> Hashmap = new HashMap<Integer, String>();
//		Hashmap.put(0, "Daddy");Hashmap.put(7, "Mummy");Hashmap.put(5, "brother");
//		System.out.println(Hashmap);
//		for(Map.Entry<Integer,String> z : Hashmap.entrySet()) {
//			System.out.println(z);
//		}
//		System.out.println(Map.Entry.comparingByValue());
//		System.out.println(Hashmap.keySet());
//		System.out.println(Hashmap.values());
//		System.out.println(Hashmap.containsKey(5));
//		System.out.println(Hashmap.containsValue("sister"));
//		
//		Map<Integer,String> LinkedHashMap = new LinkedHashMap<Integer, String>(Hashmap);
//		System.out.println(Hashmap.equals(LinkedHashMap));
//		TreeMap<Integer,String> TreeMap = new TreeMap<Integer, String>(LinkedHashMap);
//		System.out.println(TreeMap.equals(LinkedHashMap));
//		TreeMap.put(2, "sister");
//		LinkedHashMap.putAll(TreeMap);
//		System.out.println(LinkedHashMap);
//		TreeMap.putAll(LinkedHashMap);
//		System.out.println(TreeMap);
//		
//		Iterator<String> ListIterator = ArrayList.iterator();
//		System.out.println(ListIterator.hasNext());
//		System.out.println(ListIterator.next());
//		while(ListIterator.hasNext()) {
//			System.out.println(ListIterator.next());
//		}
		List<Integer> li = List.of(1,3,6,2,5,4,2,1);
		System.out.println(li.subList(0,4));
		System.out.println(Collections.frequency(li, 1));
//		sSystem.out.println(Collections.binarySearch(li, 3));
		int[] a = {4,7,5,2};
		Arrays.sort(a);
		System.out.println(Arrays.binarySearch(a, 0));
		
		li.stream().distinct().forEach(System.out::print);
		System.out.println();
		li.stream().limit(3).map(n -> n*2).forEach(System.out::print);
		System.out.println();
		li.stream().collect(Collectors.toSet()).forEach(System.out::print);
		List<String> li2 = List.of("mani","swathi","sonia");
		System.out.println();
		System.out.println(li2.stream().allMatch(n -> n.equals("mani")));
		System.out.println(li2.stream().anyMatch(n -> n.equals("mani")));
		System.out.println(li2.stream().noneMatch(n -> n.equals("mani")));
	}

}
