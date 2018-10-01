package com.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Person p1 = new Person(1);
		Person p3 = new Person(3);
		Person p2 = new Person(2);
		System.out.println(p1.compareTo(p2));
		
		Person[] peoples=new Person[]{p1,p3,p2};
		
		System.out.println("排序前");
		for (Person person : peoples)
		{
			System.out.println(person.i);
		}
		
		Arrays.sort(peoples);
		System.out.println("\n排序后");
		for (Person person : peoples)
		{
			System.out.println(person.i);
		}
		
		List<String> lists = new ArrayList<String>();
        lists.add("1");
        lists.add("5");
        lists.add("3");
        System.out.println("lists 排序前：" + lists.toString());
        //排序，直接调用sort方法排序，排序方式是自燃排序，即升序排序
        Collections.sort(lists);
        System.out.println("lists 排序后：" + lists.toString());
		
		String str = "a";
		System.out.println(str.compareTo("b"));
		
		
	}

}
