package org.system.keyword;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableTest
{
	static File file = new File("C:\\Users\\Administrator\\Desktop" + File.separator + "out.txt");

	public static void main(String[] args)
	{
		handle1();
		handle2();
	}

	private static void handle2()
	{
		try
		{
			InputStream in = new FileInputStream(file);
			ObjectInputStream objin = new ObjectInputStream(in);
			Person perobj = (Person) objin.readObject();
			System.out.println(perobj);
			in.close();
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

	private static void handle1()
	{
		FileOutputStream fos = null;
		try
		{
			fos = new FileOutputStream(file);
			ObjectOutputStream oos = null;
			try
			{
				oos = new ObjectOutputStream(fos);
				Person person = new Person(45, "tom", 22);
				Person.sex = "female";
				// 调用 person的 tostring() 方法
				System.out.println(person);
				// 写入对象
				oos.writeObject(person);
				oos.flush();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					oos.close();
				}
				catch (IOException e)
				{
					System.out.println("oos关闭失败：" + e.getMessage());
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("找不到文件：" + e.getMessage());
		}
		finally
		{
			try
			{
				fos.close();
			}
			catch (IOException e)
			{
				System.out.println("fos关闭失败：" + e.getMessage());
			}
		}

		FileInputStream fis = null;
		try
		{
			fis = new FileInputStream(file);
			ObjectInputStream ois = null;
			try
			{
				ois = new ObjectInputStream(fis);
				try
				{
					Person person = (Person) ois.readObject(); // 读出对象
					System.out.println(person);
				}
				catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					ois.close();
				}
				catch (IOException e)
				{
					System.out.println("ois关闭失败：" + e.getMessage());
				}
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("找不到文件：" + e.getMessage());
		}
		finally
		{
			try
			{
				fis.close();
			}
			catch (IOException e)
			{
				System.out.println("fis关闭失败：" + e.getMessage());
			}
		}
	}
}
