package org.system.designpatterns.singleton;

/**
 * 枚举类被完全暴露
 * @author Administrator
 *
 */
public enum EnumFactory
{
	singletonFactory;

	private Singleton9 instance;

	private EnumFactory()
	{// 枚举类的构造方法在类加载是被实例化
		instance = new Singleton9();
	}

	public Singleton9 getInstance()
	{
		return instance;
	}
}