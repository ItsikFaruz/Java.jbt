package home_ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

public class ex_1 {

	public static void main(String[] args) {

//===================================================================		
		System.out.println("ex1:===============");
		List<Integer> list1 = new ArrayList<Integer>();

		list1.add(2);
		list1.add(4);
		list1.add(6);

		System.out.println(list1);
		System.out.println("Third element: " + list1.get(2));

		int sum = 0;
		for (Integer integer : list1) {
			sum += integer;
		}
		System.out.println("the sum is: " + sum);
		System.out.println("the avg is: " + (sum / list1.size()));

//===================================================================		
		System.out.println("\nex2:===============");

		List<Integer> list2 = new ArrayList<Integer>();

		for (int i = 0; i < 100; i++) {
			list2.add(i, ((int) (Math.random() * 61) + 20));

		}
		System.out.println(list2);
		System.out.println("there is: " + list2.size() + " elements");
		System.out.println("element 1: " + list2.get(0));
		System.out.println("element left: " + (list2.size() - 1));
		System.out.println("element 10: " + list2.get(9));

		if (list2.contains(25)) {
			System.out.println("index of 25: " + list2.indexOf(25));
		} else
			System.out.println("element 25 is not contains");

//===================================================================		
		System.out.println("\nex3:===============");
		List<Integer> list3 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list3.add(i, (int) (Math.random() * 6) + 5);
		}
		System.out.println("original list: " + list3);
		Set<Integer> unicList = new LinkedHashSet<Integer>(list3);
		unicList.addAll(list3);
		list3.clear();
		list3.addAll(unicList);
		System.out.println(list3);

//===================================================================		
		System.out.println("\nex4:===============");
		Set<String> set1 = new HashSet<String>();
		set1.add("Itsik");
		set1.add("Eldar");
		set1.add("Avi");

		System.out.println(set1);
		Iterator<String> it = set1.iterator();

		for (int i = 0; it.hasNext(); i++) {
			String chr = it.next();
			if (i == 2) {
				System.out.println("third element is: " + chr);
				break;
			}
		}

//===================================================================		
		System.out.println("\nex5:===============");
		Set<Integer> set2 = new LinkedHashSet<Integer>();
		while (set2.size() < 10) {
			set2.add((int) (Math.random() * 11));
		}
		System.out.println("set with ten unic numbers: " + set2);

		Iterator<Integer> iter = set2.iterator();
		while (iter.hasNext()) {

			if (iter.next() % 2 == 0) {
				iter.remove();
			}

		}
		System.out.println("set without even numbers: " + set2);

//===================================================================		
		System.out.println("\nex6:===============");

		Map<Character, Integer> map1 = new LinkedHashMap<Character, Integer>();

		map1.put('A', 65);
		map1.put('B', 66);
		map1.put('C', 67);

		Map<Integer, String> map2 = new LinkedHashMap<Integer, String>();

		map2.put(1, "Sunday");
		map2.put(2, "Monday");
		map2.put(3, "Tuesday");

		Map<Integer, String> map3 = new LinkedHashMap<Integer, String>();

		map3.put(1, "One");
		map3.put(2, "Two");
		map3.put(3, "three");
		map3.put(4, "Four");
		map3.put(5, "Five");

		System.out.println(map1);
		System.out.println(map1.keySet());
		System.out.println(map1.values());

		System.out.println("\n" + map2);
		System.out.println(map2.keySet());
		System.out.println(map2.values());

		System.out.println("\n" + map3);
		System.out.println(map3.keySet());
		System.out.println(map3.values());

//===================================================================		
		System.out.println("\nex7:===============");

		Map<String, String> map7 = new HashMap<String, String>();
		map7.put("dog", "an animal that barks");
		map7.put("car", "a vehicle");
		map7.put("java", "a programming language");
		System.out.println(map7.keySet());
		
		try {
			String input = (JOptionPane.showInputDialog("plsase enter a word:\n" + map7.keySet()));
			if (!map7.containsKey(input)) {
				Exception e = new Exception();
				throw e;
			}
			JOptionPane.showMessageDialog(null, map7.get(input));
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "incorrect entry ");
		}

		
		
		
		
		
		
		
	}

}
