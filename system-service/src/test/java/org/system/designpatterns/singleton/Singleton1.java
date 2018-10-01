package org.system.designpatterns.singleton;

/**
 * 线程不安全的懒汉式单例
 * 
 * @author Administrator
 *
 */
public class Singleton1 extends Thread
{
	// 用一个静态变量来记录Singleton类的唯一实例
	private static Singleton1 uniqueInstance;

	private Singleton1()
	{
	}

	// 注意这个方法也是静态的，这个模式的问题：在多线程时，并不能保证这个类只被实例化一次。
	public static Singleton1 getInstance()
	{
		/*
		 * if (uniqueInstance == null) { uniqueInstance = new Singleton1(); }
		 * return uniqueInstance;
		 */
		try
		{
			if (uniqueInstance == null)
			{// 懒汉式
				// 创建实例之前可能会有一些准备性的耗时工作
				Thread.sleep(300);
				uniqueInstance = new Singleton1();
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return uniqueInstance;
	}

	public static void main(String[] args)
	{
		Singleton1[] mts = new Singleton1[10];
		for (int i = 0; i < mts.length; i++)
		{
			mts[i] = new Singleton1();
		}

		for (int j = 0; j < mts.length; j++)
		{
			mts[j].start();
		}
	}

	@Override
	public void run()
	{
		System.out.println(Singleton1.getInstance().hashCode());
	}

}
