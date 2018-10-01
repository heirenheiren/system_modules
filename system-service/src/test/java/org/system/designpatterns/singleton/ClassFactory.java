package org.system.designpatterns.singleton;

/**
 * 不暴露枚举类实现细节的封装
 * @author Administrator
 *
 */
public class ClassFactory
{
	private enum EnumSingleton
	{
		singletonFactory;

		private Singleton10 instance;

		private EnumSingleton()
		{// 枚举类的构造方法在类加载是被实例化
			instance = new Singleton10();
		}

		public Singleton10 getInstance()
		{
			return instance;
		}
	}

	public static Singleton10 getInstance()
	{
		return EnumSingleton.singletonFactory.getInstance();
	}
}
