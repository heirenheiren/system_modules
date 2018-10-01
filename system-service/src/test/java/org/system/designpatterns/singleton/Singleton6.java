package org.system.designpatterns.singleton;

/**
 * 使用静态内置类实现线程安全的单例模式
 * 
 * @author Administrator
 *
 */
public class Singleton6
{
	// 内部类
	private static class SingletonHandler
	{
		private static Singleton6 instance = new Singleton6();
	}

	private Singleton6()
	{
	}

	public static Singleton6 getInstance()
	{
		return SingletonHandler.instance;
	}
}
