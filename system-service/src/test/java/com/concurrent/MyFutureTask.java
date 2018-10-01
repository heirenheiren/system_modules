package com.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyFutureTask
{
	/**
	 * @param args
	 * @throws InterruptedException
	 * @throws ExecutionException
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		final ExecutorService exe = Executors.newFixedThreadPool(3);
		Callable<String> call = new Callable<String>()
		{
			public String call() throws InterruptedException
			{
				return "Thread is finished";
			}
		};
		Future<String> task = exe.submit(call);
		String obj = task.get();
		System.out.println(obj + "进程结束");
		System.out.println("总进程结束");
		exe.shutdown();
	}
}
