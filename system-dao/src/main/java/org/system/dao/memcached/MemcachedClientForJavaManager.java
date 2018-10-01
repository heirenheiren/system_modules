package org.system.dao.memcached;

import java.util.Date;

import com.whalin.MemCached.MemCachedClient;
import com.whalin.MemCached.SockIOPool;
/**
 * http://javadox.com/com.whalin/Memcached-Java-Client/3.0.0/com/whalin/MemCached/MemCachedClient.html#MemCachedClient(java.lang.String)
 * @author Administrator
 *
 */
public class MemcachedClientForJavaManager
{
	/**
	 * 构建缓存客户端
	 */
	private static MemCachedClient cachedClient;
	/**
	 * 单例模式实现客户端管理类
	 */
	private static MemcachedClientForJavaManager INSTANCE = new MemcachedClientForJavaManager();

	private MemcachedClientForJavaManager()
	{
		// String[] serverlist = {"192.168.1.103:11211", "192.168.1.101:11211"};

		cachedClient = new MemCachedClient();
		// 获取连接池实例
		SockIOPool pool = SockIOPool.getInstance();
		// 设置缓存服务器地址，可以设置多个实现分布式缓存
		pool.setServers(new String[] {"192.168.1.103:11211"});
		// 设置初始连接5
		pool.setInitConn(5);
		// 设置最小连接5
		pool.setMinConn(5);
		// 设置最大连接250
		pool.setMaxConn(250);
		// 设置每个连接最大空闲时间3个小时
		pool.setMaxIdle(1000 * 60 * 60 * 3);
		// 设置连接池维护线程的睡眠时间
		// 设置为0，维护线程不启动
		// 维护线程主要通过log输出socket的运行状况，监测连接数目及空闲等待时间等参数以控制连接创建和关闭。
		pool.setMaintSleep(30);
		// 设置是否使用Nagle算法，因为我们的通讯数据量通常都比较大（相对TCP控制数据）而且要求响应及时，因此该值需要设置为false（默认是true）
		pool.setNagle(false);
		// 设置socket的读取等待超时值
		pool.setSocketTO(3000);
		// 设置socket的连接等待超时值
		pool.setSocketConnectTO(0);
		// 设置权重
		pool.setWeights(new Integer[] {30,70});
		// 设置完pool参数后最后调用该方法，启动pool。
		pool.initialize();
	}

	/**
	 * 获取缓存管理器唯一实例
	 * 
	 * @return
	 */
	public static MemcachedClientForJavaManager getInstance()
	{
		return INSTANCE;
	}

	public void add(String key, Object value)
	{
		cachedClient.set(key, value);
	}

	public void add(String key, Object value, int milliseconds)
	{
		cachedClient.set(key, value, milliseconds);
	}

	public void remove(String key)
	{
		cachedClient.delete(key);
	}

	@SuppressWarnings("deprecation")
	public void remove(String key, int milliseconds)
	{
		cachedClient.delete(key, milliseconds, new Date());
	}

	public void update(String key, Object value, int milliseconds)
	{
		cachedClient.replace(key, value, milliseconds);
	}

	public void update(String key, Object value)
	{
		cachedClient.replace(key, value);
	}

	public Object get(String key)
	{
		return cachedClient.get(key);
	}

}
