package org.system.keyword;

import java.io.Serializable;

public class Person extends People implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String sex="male";
	transient String name;
	int age;

	public Person(int num, String name, int age)
	{
		super(num);
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString()
	{
		return "Person ["+super.toString()+", sex=" + sex + ", name=" + name + ", age=" + age + "]";
	}

}
