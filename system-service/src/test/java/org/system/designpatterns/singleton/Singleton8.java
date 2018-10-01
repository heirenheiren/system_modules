package org.system.designpatterns.singleton;

/**
 * 使用static代码块实现线程安全的单例模式
 * 
 * @author Administrator
 *
 */
public class Singleton8 extends Thread
{
	private static Singleton8 instance = null;

	private Singleton8()
	{
	}

	static
	{
		instance = new Singleton8();
	}

	public static Singleton8 getInstance()
	{
		return instance;
	}

	@Override
	public void run()
	{
		System.out.println(Singleton8.getInstance().hashCode());
	}

	public static void main(String[] args)
	{

		Singleton8[] mts = new Singleton8[10];
		for (int i = 0; i < mts.length; i++)
		{
			mts[i] = new Singleton8();
		}

		for (int j = 0; j < mts.length; j++)
		{
			mts[j].start();
		}
	}
}
