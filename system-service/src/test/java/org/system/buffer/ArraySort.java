package org.system.buffer;

public class ArraySort implements Runnable
{
	int number;

	public ArraySort(int number)
	{
		this.number = number;
	}

	public static void main(String[] args)
	{
		int[] numbers = new int[]{763,233,687,234,67};
		for (int number : numbers)
		{
			new Thread(new ArraySort(number)).start();
		}
	}

	@Override
	public void run()
	{
		try
		{
			Thread.sleep(number);
			System.out.println(number);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
