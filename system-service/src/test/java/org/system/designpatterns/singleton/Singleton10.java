package org.system.designpatterns.singleton;

/**
 * 完善使用enum枚举实现单例模式
 * 
 * @author Administrator
 *
 */
public class Singleton10 extends Thread
{
	// 需要获实现单例的类，比如数据库连接Connection
	// 枚举enum和静态代码块的特性相似，在使用枚举时，构造方法会被自动调用，利用这一特性也可以实现单例
	public Singleton10()
	{
		System.out.println("Runing......"+Thread.currentThread().getName());
	}

	@Override
	public void run()
	{
		System.out.println(ClassFactory.getInstance().hashCode());
	}

	public static void main(String[] args)
	{

		Singleton10[] mts = new Singleton10[10];
		for (int i = 0; i < mts.length; i++)
		{
			mts[i] = new Singleton10();
		}

		for (int j = 0; j < mts.length; j++)
		{
			mts[j].start();
		}
	}
}
