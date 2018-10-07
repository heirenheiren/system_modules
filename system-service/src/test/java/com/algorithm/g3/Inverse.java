package com.algorithm.g3;

/*
 * 输入一个数，返回它的逆置，如输入55821000，返回12855 
 */
public class Inverse
{

	public int method(int n)
	{
		if (n == 0)
		{
			return 0;
		}
		while (n % 10 == 0)
		{
			n /= 10;
		}
		int result = 0;
		while (n != 0)
		{
			result = result * 10 + n % 10;
			// n=n\10;
		}
		return result;
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Inverse inverse = new Inverse();
		int input = inverse.method(55821000);
		System.out.println(input);
		System.out.println("打印");
	}
}