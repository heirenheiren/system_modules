package com.algorithm.fibonacci;

public class Meili
{
	long sum1(int n)
	{
		if (n == 1)
			return 1;
		else
			return sum1(n - 1) * 10 + n;
	}

	public void printNums1(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			StringBuilder builder = new StringBuilder();
			for (int j = 0; j < 9 - i; j++)
			{
				builder.append(" ");
			}
			String space = builder.toString();

			long a = sum1(i);
			System.out.println(space + a + "*" + 8 + "+" + i + "=" + (a * 8 + i));
		}
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Meili meili = new Meili();

		meili.printNums1(9);

		meili.printNums2(19);// long只能存到19的结果
	}

	public long sum2(int n)
	{
		if (n == 1)
			return 1;
		else
		{
			return sum2(n - 1) * 10 + n;
		}
	}

	public void printNums2(int num)
	{
		for (int i = 1; i <= num; i++)
		{
			System.out.println(sum2(i));
		}
	}
}
