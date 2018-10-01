package org.system.dao.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Future;

import net.spy.memcached.MemcachedClient;

/**
 * http://dustin.sallings.org/java-memcached-client/apidocs/net/spy/memcached/
 * MemcachedClient.html
 * 
 * @author Administrator
 *
 */
public class MemcachedClientForSpyManager
{
	private static MemcachedClient cachedClient;
	private static MemcachedClientForSpyManager instance = new MemcachedClientForSpyManager();

	private MemcachedClientForSpyManager()
	{
		InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.1.103", 11211);
		try
		{
			cachedClient = new MemcachedClient(inetSocketAddress);
			System.out.println("Connection to server sucessful.");
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MemcachedClientForSpyManager getInstance()
	{
		return instance;
	}

	public Future<Boolean> add(String key, int exp, Object o)
	{
		return cachedClient.add(key, exp, o);
	}

	public Object get(String key)
	{
		return cachedClient.get(key);
	}
}
