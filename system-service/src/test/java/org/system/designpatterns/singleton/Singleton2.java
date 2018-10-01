package org.system.designpatterns.singleton;

/**
 * 线程安全效率低的懒汉式单例：方法中声明synchronized关键字
 * 
 * @author Administrator
 *
 */
public class Singleton2
{

	// 用一个静态变量来记录Singleton类的唯一实例
	private static Singleton2 uniqueInstance;

	private Singleton2()
	{
	}

	// 注意这个方法也是静态的，增加synchronized关键字，不会有两个线程可以同时进入这个方法，
	// 这种方法存在的问题：只有第一次执行此方法时，才真正需要同步。换句话说，一旦设置好uniqueInstance变量，就不再需要同步这个方法了。之后每次调用这个方法，同步都是一种浪费。
	public static synchronized Singleton2 getInstance()
	{
		if (uniqueInstance == null)
		{
			uniqueInstance = new Singleton2();
		}
		return uniqueInstance;
	}

}
