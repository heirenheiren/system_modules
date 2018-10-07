package com.algorithm.revers;

/*
 * 将一个已知数组中的所有元素的次序颠倒为相反的次序
 */
public class Revers {

		public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1=new int[10];
		
		        for(int i=0;i<10;i++) 
		        {
		         System.out.print(array1[i]=i);
		        }
		        System.out.println();
		        int[] array2=new int[10];
		        for(int j=0;j<10;j++)
		        {
		         
		         array2[j]=array1[9-j];
		         System.out.print(array2[j]);
		        }
		}
}
