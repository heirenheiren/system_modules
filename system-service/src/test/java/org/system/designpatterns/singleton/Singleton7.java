package org.system.designpatterns.singleton;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * 序列化与反序列化的单例模式实现:静态内部类虽然保证了单例在多线程并发下的线程安全性，但是在遇到序列化对象时，默认的方式运行得到的结果就是多例的。
 * 
 * @author Administrator
 *
 */
public class Singleton7 implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 内部类
	private static class SingletonHandler
	{
		private static Singleton7 instance = new Singleton7();
	}

	private Singleton7()
	{
	}

	public static Singleton7 getInstance()
	{
		return SingletonHandler.instance;
	}

	// 如果没有这个方法，从结果中我们发现，序列号对象的hashCode和反序列化后得到的对象的hashCode值不一样，说明反序列化后返回的对象是重新实例化的，单例被破坏了
	// 添加该方法在反序列化时会被调用，该方法不是接口定义的方法，有点儿约定俗成的感觉
	protected Object readResolve() throws ObjectStreamException
	{
		System.out.println("调用了readResolve方法！"+Thread.currentThread().getName());
		return SingletonHandler.instance;
	}

	public static void main(String[] args)
	{
		Singleton7 singleton = Singleton7.getInstance();

		File file = new File("C:\\Users\\Administrator\\Desktop" + File.separator + "out.txt");

		try
		{
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(singleton);
			fos.close();
			oos.close();
			System.out.println(singleton.hashCode());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Singleton7 rSingleton = (Singleton7) ois.readObject();
			fis.close();
			ois.close();
			System.out.println(rSingleton.hashCode());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

	}
}
