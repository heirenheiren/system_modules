package com.algorithm.uniqueelement;

//元素唯一性问题
public class Unique {

	boolean Fun()
	{
		int []Array={3,10,9,71,25,64,38,52,5,31,19,45,16,26,35,17,92,3,
				24,6,57,21,12,34,2,17,86,75,33,20,15,87,32,7,84,35,26,
				45,78,96,52,22,37,65,9,43,21,3,33,91};	
		long flag=0;
      for(int i=0;i<Array.length-2;i++)
         for(int j=i+1;j<Array.length-1;j++)
         {
      	   flag++;
         	if(Array[i]==Array[j])
         	{
         		return false;
         	}	
         }
      System.out.println(flag);
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Unique fun=new Unique();
       System.out.println(fun.Fun());
       System.out.println(Unique.class);
	}

}
