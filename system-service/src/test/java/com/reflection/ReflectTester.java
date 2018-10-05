package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTester
{
	public static void main(String[] args) throws Exception
	{
		Customer customer = new Customer("Tom", 21);
		customer.setId(new Long(1));

		Customer customerCopy = (Customer) new ReflectTester().copy(customer);
		System.out.println("Copy information:" + customerCopy.getId() + " " + customerCopy.getName() + " "
				+ customerCopy.getAge());

		Car car = initByDefaultConst();
		car.introduce();

		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> clazz = loader.loadClass("com.reflect.PrivateCar");
		PrivateCar pcar = (PrivateCar) clazz.newInstance();

		Field colorFld = clazz.getDeclaredField("color");
		// ①取消Java语言访问检查以访问private变量
		colorFld.setAccessible(true);
		colorFld.set(pcar, "红色");

		Method driveMtd = clazz.getDeclaredMethod("drive", (Class[]) null);
		// Method driveMtd = clazz.getDeclaredMethod("drive"); JDK5.0下使用

		// ②取消Java语言访问检查以访问protected方法
		driveMtd.setAccessible(true);
		driveMtd.invoke(pcar, (Object[]) null);
	}

	public static Car initByDefaultConst()
	{
		try
		{
			// ①通过类装载器获取Car类对象
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			Class<?> clazz = loader.loadClass("com.reflect.Car");

			// ②获取类的默认构造器对象并通过它实例化Car
			Constructor<?> cons = clazz.getDeclaredConstructor((Class[]) null);
			Car car = (Car) cons.newInstance();

			// ③通过反射方法设置属性
			Method setBrand = clazz.getMethod("setBrand", String.class);
			setBrand.invoke(car, "红旗CA72");
			Method setColor = clazz.getMethod("setColor", String.class);
			setColor.invoke(car, "黑色");
			Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
			setMaxSpeed.invoke(car, 200);
			return car;
		}
		catch (Throwable e)
		{
			// TODO: handle exception
		}
		return null;
	}

	public Object copy(Object object) throws Exception
	{
		Class<?> classType = object.getClass();
		System.out.println("Class:" + classType.getName());

		Object objectCopy = classType.getConstructor(new Class[] {}).newInstance(new Object[] {});

		Field fields[] = classType.getDeclaredFields();

		for (int i = 0; i < fields.length; i++)
		{
			Field field = fields[i];

			String fieldName = field.getName();
			String firstLetter = fieldName.substring(0, 1).toUpperCase();
			String getMethodName = "get" + firstLetter + fieldName.substring(1);
			String setMethodName = "set" + firstLetter + fieldName.substring(1);

			Method getMethod = classType.getMethod(getMethodName, new Class[] {});
			Method setMethod = classType.getMethod(setMethodName, new Class[] { field.getType() });

			Object value = getMethod.invoke(object, new Object[] {});
			System.out.println(fieldName + ":" + value);
			setMethod.invoke(objectCopy, new Object[] { value });
		}
		return objectCopy;
	}
}
