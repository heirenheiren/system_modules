package com.concurrent;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/**
 * CountDownLatch最重要的方法是countDown()和await()，前者主要是倒数一次，后者是等待倒数到0，如果没有到达0，就只有阻塞等待了。
 * @author Administrator
 *
 */
public class TestCountDownLatch
{

	public static void main(String[] args) throws InterruptedException
	{
		// 开始的倒数锁
		final CountDownLatch begin = new CountDownLatch(1);
		// 结束的倒数锁
		final CountDownLatch end = new CountDownLatch(10);
		// 十名选手
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		for (int index = 0; index < 10; index++)
		{
			final int NO = index + 1;
			Runnable run = new Runnable()
			{
				public void run()
				{
					try
					{
						begin.await();// 一直阻塞
						System.out.println("begin.await");
						Thread.sleep((long) (Math.random() * 10000));
						System.out.println("No." + NO + " arrived");
					}
					catch (InterruptedException e)
					{
					}
					finally
					{
						System.out.println("end1.countDown");
						end.countDown();
						System.out.println("end2.countDown");
					}
				}
			};
			exec.submit(run);
		}
		System.out.println("Game Start");
		begin.countDown();
		System.out.println("begin.countDown");
		end.await();
		System.out.println("Game Over");
		exec.shutdown();
	}
}
