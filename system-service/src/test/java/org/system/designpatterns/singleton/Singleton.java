package org.system.designpatterns.singleton;

/**
 * 饿汉式单例:运行结果可以看出实例变量额hashCode值一致，这说明对象是同一个，饿汉式单例实现
 * 
 * @author Administrator
 *
 */
public class Singleton extends Thread
{
	// 在静态初始化器(static initializer)中创建单例，这保证了线程安全,利用这个做法，JVM在加载这个类时马上创建此唯一的单件实例。JVM保证任何线程访问uniqueInstance静态变量之前，一定先创建些实例。
	private static Singleton uniqueInstance = new Singleton();

	private Singleton()
	{
	}

	public static Singleton getInstance()
	{
		return uniqueInstance;
	}

	public static void main(String[] args)
	{
		Singleton[] mts = new Singleton[10];
		for (int i = 0; i < mts.length; i++)
		{
			mts[i] = new Singleton();
		}

		for (int j = 0; j < mts.length; j++)
		{
			mts[j].start();
		}
	}

	@Override
	public void run()
	{
		System.out.println(Singleton.getInstance().hashCode());
	}
}
