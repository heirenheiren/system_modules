package org.system.designpatterns.singleton;

/**
 * 线程安全效率低的懒汉式单例:同步代码块实现
 * 
 * @author Administrator
 *
 */
public class Singleton3
{
	private static Singleton3 instance = null;

	private Singleton3()
	{
	}

	// public synchronized static MySingleton getInstance() {
	public static Singleton3 getInstance()
	{
		try
		{
			synchronized (Singleton3.class)
			{
				if (instance == null)
				{// 懒汉式
					// 创建实例之前可能会有一些准备性的耗时工作
					Thread.sleep(300);
					instance = new Singleton3();
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
