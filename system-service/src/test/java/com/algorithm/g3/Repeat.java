package com.algorithm.g3;
/*
 * 一个长1001的数组，放1-1000这1001个数，有一个是重复的，不要用额外的存储空间，求出这个数是多少？
 * 将所有元素异或，再与1－1000也异或，结果就是要求的数。
 */
public class Repeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array=new int[1001];
		for(int i=0;i<array.length;i++)
		{
			array[i]=i+1;
			//System.out.println(array[i]);
		}
		array[1000]=2;
		for(int i=0;i<array.length;i++)
		{
			for(int j=i+1;j<array.length;j++)
				if(array[i]==array[j])
				{
					System.out.println("这个数的两个位置是："+i+"和"+j);
				}
		}
	}

}
