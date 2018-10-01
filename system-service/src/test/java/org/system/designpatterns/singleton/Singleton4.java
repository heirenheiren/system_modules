package org.system.designpatterns.singleton;

/**
 * 可能线程不安全的懒汉式单例：针对某些重要的代码来进行单独的同步
 * 
 * @author Administrator
 *
 */
public class Singleton4
{
	private static Singleton4 instance = null;

	private Singleton4()
	{
	}

	public static Singleton4 getInstance()
	{
		try
		{
			if (instance == null)
			{
				// 创建实例之前可能会有一些准备性的耗时工作
				Thread.sleep(300);
				synchronized (Singleton4.class)
				{
					instance = new Singleton4();
				}
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return instance;
	}
}
