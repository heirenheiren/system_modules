package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockMain
{
	public static void main(String[] args) throws InterruptedException
	{
		Lock lock = new ReentrantLock();
		AtomicInteger data = new AtomicInteger(0);

		ExecutorService executor = Executors.newCachedThreadPool();
		executor.execute(new LockAddTask(lock, data));
		executor.execute(new LockAddTask(lock, data));

		executor.shutdown();
		Thread.sleep(10);

		System.out.println(data.get());
	}

	static class LockAddTask implements Runnable
	{
		private Lock lock;
		private AtomicInteger data;

		public LockAddTask(Lock lock, AtomicInteger data)
		{
			this.lock = lock;
			this.data = data;
		}

		public void run()
		{
			int cnt = 10;

			while (cnt-- > 0)
			{
				try
				{
					lock.lockInterruptibly();
					data.getAndIncrement();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				finally
				{
					lock.unlock();
				}
			}
		}
	}
}
