package org.system.dao;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.system.dao.memcached.MemcachedClientForJavaManager;
import org.system.dao.memcached.MemcachedClientForSpyManager;
import org.system.dao.memcached.MemcachedClientForXManager;

import net.spy.memcached.MemcachedClient;
/**
 * 
C:\memcached-win32-1.4.4-14>memcached.exe -d install

C:\memcached-win32-1.4.4-14>memcached.exe -d start

C:\memcached-win32-1.4.4-14>memcached.exe -d stop
https://blog.csdn.net/u013725455/article/details/52102170
 * @author Administrator
 *
 */
public class MemcachedTest
{

	public static void main(String[] args)
	{
		java();
		spy();
		X();
	}

	private static void X()
	{
		System.out.println(MemcachedClientForXManager.getInstance().add("key", 9, "Free Education"));
		System.out.println(MemcachedClientForXManager.getInstance().get("key").toString());
		System.out.println(MemcachedClientForXManager.getInstance().delete("key"));
		System.out.println(MemcachedClientForXManager.getInstance().get("key").toString());
	}

	private static void java()
	{
		// TODO Auto-generated method stub
		MemcachedClientForJavaManager.getInstance().add("key", "value");
		System.out.println(MemcachedClientForJavaManager.getInstance().get("key"));
		MemcachedClientForJavaManager.getInstance().remove("key");
		System.out.println(MemcachedClientForJavaManager.getInstance().get("key"));
	}

	private static void spy()
	{
		
		Future<?> fo = MemcachedClientForSpyManager.getInstance().add("runoob", 9, "Free Education");
		try
		{
			System.out.println("set status:" + fo.get());
			Thread.sleep(900);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ExecutionException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < 100; i++)
		{
			// 输出值
			System.out.println("runoob value in cache : " + MemcachedClientForSpyManager.getInstance().get("runoob"));
		}
		
	}

}
