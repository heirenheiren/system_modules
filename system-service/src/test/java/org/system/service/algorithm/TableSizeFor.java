package org.system.service.algorithm;

/**
 * 返回一个比给定整数大且最接近的2的幂次方整数，如给定10，返回2的4次方16. 把传进来的参数的二进制数的左边第一个1不断右移，把后面所有的位变成1，最后返回n+1
 * @author Administrator
 *
 */
public class TableSizeFor
{
	private static final int MAXIMUM_CAPACITY = 1 << 30;

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		System.out.println(2>>>1);
		System.out.println(tableSizeFor(250));
	}

	private static final int tableSizeFor(int c)
	{
		int n = c - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
	}
}
