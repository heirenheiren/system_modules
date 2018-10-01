package org.system.service.algorithm;

public class Child implements Parent
{
	@Override
	public String name(Object b)
	{
		// TODO Auto-generated method stub
		return "11"+b;
	}
	
	public String name(String b)
	{
		// TODO Auto-generated method stub
		return "22"+b;
	}
	
	public static void main(String[] args)
	{
		Parent parent = new Child();
		System.out.println(parent.name("33"));
	}
	
}
