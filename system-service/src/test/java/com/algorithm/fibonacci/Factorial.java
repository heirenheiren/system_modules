package com.algorithm.fibonacci;

public class Factorial
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Factorial fac = new Factorial();
		// 递归计算阶乘
		System.out.println(Fac1(5));
		System.out.println(fac.Fac2(5));
	}

	long Fac2(int n)
	{
		// TODO Auto-generated method stub
		long result = 1;
		while (n > 1)
		{
			result *= n; // 乘号必须紧靠等于号，如果两个符号之间有空格就会报错。
			n--;
		}
		return result;
	}

	private static long Fac1(int n)
	{
		if (n == 0)
			return 1;
		else
			return Fac1(n - 1) * n;
	}
}
