package org.system.designpatterns.singleton;

/**
 * 线程安全高效率单例模式：Double Check Locking 双检查锁机制
 * @author Administrator
 *
 */
public class Singleton5
{
	//volatile关键字确保：当uniqueInstance变量被初始化成Singleton实例时，多个线程正确地uniqueInstance变量。如果性能是你关心的重点，那么这个做法可以帮你大大地减少getInstance()的时间耗费。
	private volatile static Singleton5 uniqueInstance;

	private Singleton5()
	{
	}

	public static Singleton5 getInstance()
	{    
		try
		{
			//发现uniqueInstance已经不为空，跳出同步块
		    if(uniqueInstance == null) 
		    {
		    	//创建实例之前可能会有一些准备性的耗时工作   
		    	Thread.sleep(300);
		        //只有第一次才彻底执行这里的代码   
		        synchronized(Singleton5.class)
		        {
		    	   //再检查一次   
		    	   if(uniqueInstance == null)   
		    	   {
		    		   uniqueInstance = new Singleton5();
		    	   }
		        }   
		    } 
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
        return uniqueInstance;   
    }
}
