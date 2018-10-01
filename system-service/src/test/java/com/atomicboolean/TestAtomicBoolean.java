package com.atomicboolean;

import java.util.concurrent.atomic.AtomicBoolean;

public class TestAtomicBoolean implements Runnable
{

	public static AtomicBoolean exits = new AtomicBoolean(false);

	private String name;

	public TestAtomicBoolean(String name)
	{
		this.name = name;
	}

	@Override
	public void run()
	{

		if (exits.compareAndSet(false, true))
		{
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(name + exits + ",step 1");

			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(name + exits + ",step 2");
			exits.set(false);
			System.out.println(name + exits + ",step 3");
		}
		else
		{
			System.out.println(name + exits + ",step else");
			try
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(name + exits + ",step else");
		}

	}

}
