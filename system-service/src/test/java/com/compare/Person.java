package com.compare;

public class Person implements Comparable<Person>
{

	int i;

	
	public Person(int i)
	{
		super();
		this.i = i;
	}


	@Override
	public int compareTo(Person p)
	{
		// TODO Auto-generated method stub
		return i-p.i;
	}

}
