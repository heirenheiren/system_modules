package com.algorithm.fibonacci;

//Fibonacci数列，其数学表达如下：
//给定一正整数x，
//F(x) = 1 ( x=1 或 x=2)
//F(x) = F(x-1) + F(x-2) ( x > 2 )
//也就是说，前2个数是1， 后面的数是前面2个数之和

public class Fibonacci
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int i = 40;
		Fibonacci fib = new Fibonacci();
		System.out.println(fib.Fib1(i));
		System.out.println("1递归了多少次:" + fib.flag1);

		System.out.println(fib.Fib2(i));
		System.out.println("2递归了多少次:" + fib.flag2);

		System.out.println(fib.Fib3(i));
	}

	int flag1 = 0;

	long Fib1(int n)
	{
		flag1++;// 递归了多少次。
		if (n == 0)
		{
			return 0;
		}
		else
		{
			if (n == 1 || n == 2)
			{
				return 1;
			}
			else
			{
				return Fib1(n - 1) + Fib1(n - 2);
			}
		}
	}

	int flag2 = 0;

	long Fib2(int n)
	{
		flag2++;
		if (n <= 2)
		{
			return 1;
		}
		return Fib2(n - 1) + Fib2(n - 2);
	}

	long Fib3(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		System.out.println("第1个数是：\t" + 0);
		if (n == 1)
		{
			return 1;
		}
		System.out.println("第2个数是:\t" + 1);
		if (n == 2)
		{
			return 1;
		}
		System.out.println("第3个数是:\t" + 1);
		long x = 1;
		long y = 1;
		long z = 0;
		for (int i = 0; i < n - 2; i++)
		{
			z = x + y;
			x = y;
			y = z;
			System.out.println("第" + (i + 4) + "个数是：\t" + z);
		}
		return z;
	}
}
