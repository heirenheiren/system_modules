package com.concurrent;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 我们现在在Java中使用多线程通常不会直接用Thread对象了，而是会用到java.util.concurrent包下的ExecutorService类来初始化一个线程池供我们使用。
 * 之前我一直习惯自己维护一个list保存submit的callable task所返回的Future对象。在主线程中遍历这个list并调用Future的get()方法取到Task的返回值。
 * 但是，我在很多地方会看到一些代码通过CompletionService包装ExecutorService，然后调用其take()方法去取Future对象。以前没研究过这两者之间的区别。
 * 今天看了源代码之后就明白了。这两者最主要的区别在于submit的task不一定是按照加入自己维护的list顺序完成的。
 * 从list中遍历的每个Future对象并不一定处于完成状态，这时调用get()方法就会被阻塞住，如果系统是设计成每个线程完成后就能根据其结果继续做后面的事，这样对于处于list后面的但是先完成的线程就会增加了额外的等待时间。
 * 而CompletionService的实现是维护一个保存Future对象的BlockingQueue。只有当这个Future对象状态是结束的时候，才会加入到这个Queue中，take()方法其实就是Producer-Consumer中的Consumer。
 * 它会从Queue中取出Future对象，如果Queue是空的，就会阻塞在那里，直到有完成的Future对象加入到Queue中。所以，先完成的必定先被取出。这样就减少了不必要的等待时间。ExecutorCompletionService 类提供了此方法的一个实现。
 * @author Administrator
 *
 */
// 这个东西的使用上很类似于CallableFutureTest，不同的是，它会首先取完成任务的线程。  
public class CompletionServiceTest
{
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		ExecutorService exec = Executors.newFixedThreadPool(10);
		// 创建CompletionService
		CompletionService<String> serv = new ExecutorCompletionService<String>(exec);
		for (int index = 0; index < 5; index++)
		{
			final int NO = index;
			// Callable 接口类似于 Runnable
			Callable<String> downImg = new Callable<String>()
			{
				public String call() throws Exception
				{
					Thread.sleep((long) (Math.random() * 10000));
					System.out.println("call");
					return "Downloaded Image " + NO;
				}
			};
			// 提交要执行的值返回任务，并返回表示挂起的任务结果的 Future。在完成时，可能会提取或轮询此任务。
			System.out.println("sub");
			serv.submit(downImg);
		}
		System.out.println("Show web content");
		for (int index = 0; index < 5; index++)
		{
			// 获取并移除表示下一个已完成任务的 Future，如果目前不存在这样的任务，则等待。
			Future<String> task = serv.take();
			// 如有必要，等待计算完成，然后获取其结果。
			String img = task.get();
			System.out.println("img:"+img);
		}
		System.out.println("End");
		// 关闭线程池
		exec.shutdown();
	}
}
