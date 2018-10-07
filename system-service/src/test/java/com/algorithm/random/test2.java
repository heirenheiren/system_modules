package com.algorithm.random;
//给一个大小为100的（整型）数组，分配0-1000的随机数100个，但这100个数不能重复，
//然后把它从小到大排序，并输出来。（时间10分钟）
//我把它变了一下数组大小为101，感觉效率比较高。算法如下：
public class test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a=new int[101];
		for(int i=0;i<100;i++)
		{
			int r=(int) (Math.random()*1000);;
			for(int j=0;j<=i;j++)
			{
				if(r!=a[i])
				{
					a[i]=r;
					System.out.print("随机产生的第"+(i+1)+"个数是："+a[i]);
					if((i+1)%10==0)
					{
						System.out.println();
					}
				}
			}
		}
		
		for(int i=0;i<100;i++)
		{
			for(int j=i+1;j<100;j++)
			{
				if(a[i]>a[j])
				{
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
			System.out.println("排列后的第"+(i+1)+"个数是："+a[i]);
		}
	}

}
