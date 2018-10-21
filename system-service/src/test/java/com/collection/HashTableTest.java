package com.collection;

import java.util.Enumeration;
import java.util.Hashtable;

public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
		ht.put("test1", new Integer(80));
		ht.put("test2", new Integer(80));
		ht.put("test3", new Integer(70));
		ht.put("test4", new Integer(60));
		ht.put("test5", new Integer(50));
		ht.put("test6", new Integer(40));
		ht.put("test7", new Integer(30));
		Enumeration<Integer> e = ht.elements();
		while(e.hasMoreElements()){
			System.out.println(e.nextElement());
		}
	}

}
