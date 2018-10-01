package org.system.designpatterns.singleton;

/**
 * 使用枚举数据类型实现线程安全的单例模式：运行结果表明单例得到了保证，但是这样写枚举类被完全暴露了，据说违反了“职责单一原则”
 * 
 * @author Administrator
 *
 */
public class Singleton9 extends Thread
{
	// 需要获实现单例的类，比如数据库连接Connection
	// 枚举enum和静态代码块的特性相似，在使用枚举时，构造方法会被自动调用，利用这一特性也可以实现单例
	public Singleton9()
	{
		System.out.println("Runing......"+Thread.currentThread().getName());
	}

	@Override
	public void run()
	{
		System.out.println(EnumFactory.singletonFactory.getInstance().hashCode());
	}

	public static void main(String[] args)
	{

		Singleton9[] mts = new Singleton9[10];
		for (int i = 0; i < mts.length; i++)
		{
			mts[i] = new Singleton9();
		}

		for (int j = 0; j < mts.length; j++)
		{
			mts[j].start();
		}
	}
}
