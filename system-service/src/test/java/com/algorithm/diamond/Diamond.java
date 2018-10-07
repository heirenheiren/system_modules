package com.algorithm.diamond;

public class Diamond
{
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		set1(10);
		set2(10);
		set3(10);
	}

	private static void set3(int n)
	{
		// TODO Auto-generated method stub
		int i, j, k;
		/* 变量i从0到4，表示所画菱形图的第一至第五行 */
		for (i = 0; i < n; i++)
		{
			/* 当行数为i时，空格数是i的函数，为4-i个 */
			for (j = 0; j < n - i; j++)
				System.out.print(" ");
			/* 星号数也是i的函数，为2i+1个 */
			for (k = 0; k <= 2 * i; k++)
				System.out.print("*");
			System.out.print("\n");
		}
		/* 变量i从0到3，表示所画菱形图的第六至第九行 */
		for (i = 0; i < n; i++)
		{
			/* 当行数为i时，空格数是i的函数，此时为i个 */
			for (j = 0; j < i + 2; j++)
				System.out.print(" ");
			/* 星号数也是i的函数，此时为7-2i个 */
			for (k = 0; k < 2 * n - 2 * i - 3; k++)
				System.out.print("*");
			System.out.print("\n");
		}
	}

	private static void set2(int n)
	{
		// TODO Auto-generated method stub
		int i, j;
		for (i = -n; i <= n; i++)
		{
			for (j = 0; j < (i > 0 ? i : -i); j++)
			{
				System.out.print(" ");// i=0不打印
			}
			for (j = 0; j < (i > 0 ? -2 * i + 2 * n + 1 : 2 * i + 2 * n + 1); j++)
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void set1(int n)
	{
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n - i - 1; j++)
			{
				System.out.print(" ");
			}
			for (int k = 0; k < 2 * i + 1; k++)// 得到奇数
			{
				System.out.print("*");
			}
			System.out.println();
		}
	}
}