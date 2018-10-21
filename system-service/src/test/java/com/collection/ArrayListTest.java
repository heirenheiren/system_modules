package com.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new MyArrayList<Integer>();
		list.add(1);
		list.add(3);
		list.add(4);
		list.add(5);
		
		list.subList(1, 2);
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(3);
		list1.add(1);
		
		Integer[] original = {1,2,3,4,5};
		Integer[] aa = Arrays.copyOf(original, 2);

		Integer[] aaa = list.toArray(original);

		boolean bl = list.containsAll(list1);
		for (int i = 0; i < list.size(); i++) {
			
		}
		for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext();) {
			Integer integer = (Integer) iterator.next();
			System.out.println(integer);
		}
		for (Integer integer : list) {
			System.out.println(integer);
		}
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			Integer integer = (Integer) it.next();
			System.out.println(integer);
		}
	}

}
