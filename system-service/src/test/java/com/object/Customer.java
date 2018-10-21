package com.object;

public class Customer {
	private String name;
	private int age;
	
	public  Customer(){
		this("unknown",0);
		System.out.println("call default constructor");
	}

	public Customer(String name, int age) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		System.out.println("call second constructor");
	}
	
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	public boolean equals(Object o){
		if(this==o) return true;
		if(!(o instanceof Customer)) return false;
		
		final Customer other=(Customer)o;
		
		if(this.name.equals(other.name) && this.age==other.age){
			return true;
		}else{
			return false;
		}
	}
	
	public String toString(){
		return "name="+name+",age="+age;
	}
	
	public static void main(String args[]) throws Exception{
		//1.运用反射手段创建Customer对象
		Class<?> objClass = Customer.class;
		Customer c1 = (Customer)objClass.newInstance();    //会调用Customer类的默认构造方法
		System.out.println("c1:"+c1);
		
		//2.用new语句创建Customer对象
		Customer c2 = new Customer("Tom",20);
		System.out.println("c2:"+c2);
		
		//3.运用克隆手段创建Customer对象
		Customer c3 = (Customer)c2.clone();					//不会调用Custmer类的构造方法
		System.out.println("c2==c3:"+(c2==c3));
		System.out.println("c2.equals(c3):"+c2.equals(c3));
		System.out.println("c3:"+c3);
	}
}
