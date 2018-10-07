package com.algorithm.maxelement;
//从N个元素中查找元素最大值的问题
public class Max {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      int[] a={2,43,352,2354,514654,67,89};
      int max=a[0];
      int flag=0;
      for(int i=1;i<a.length;i++)
      {
      	if(max<a[i])
      		max=a[i];
      	flag++;
      }
      System.out.println(max);
      System.out.println(flag);
	}

}