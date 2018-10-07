package com.algorithm.combination;
//写一个程序, 要求功能：求出用1，2，5这三个数不同个数组合的和为100的组合个数。

//如：100个1是一个组合，5个1加19个5是一个组合。。。。 请用C++语言写。
//答案：最容易想到的算法是：
//设x是1的个数，y是2的个数，z是5的个数，number是组合数
//注意到0<=x<=100，0<=y<=50，0<=z=20，所以可以编程为：
//number=0;
//for (x=0; x<=100; x++)
//for (y=0; y<=50; y++)
//for (z=0; z<=20; z++)
//if ((x+2*y+5*z)==100)
//number++;
//cout<<number<<endl;

public class Combination
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		method1();
		method2();
		method3();
	}

	private static void method3()
	{
		// TODO Auto-generated method stub
		int i, j, n = 0;
		for (i = 0; i <= 20; i++)
		{
			for (j = 0; j <= (100 - i * 5) / 2; j++)
			{
				n++;
			}
		}
		System.out.println(n);
	}

	private static void method2()
	{
		// TODO Auto-generated method stub
		int j, k;
		int n = 0;
		for (j = 0; j <= 50; j++)
		{
			for (k = 0; k <= 20; k++)
			{
				if (2 * j + 5 * k <= 100)
				{
					n++;
				}
			}
		}
		System.out.println(n);
	}

	private static void method1()
	{
		// TODO Auto-generated method stub
		int x, y, z;
		int number = 0;
		for (x = 0; x <= 100; x++)
		{
			for (y = 0; y <= 50; y++)
			{
				for (z = 0; z <= 20; z++)
				{
					if (x + y * 2 + z * 5 == 100)
					{
						System.out.println(x + ":" + y + ":" + z);
						number++;
					}
				}
			}
		}
		System.out.println(number);
	}

}
