package com.atomicboolean;

public class AtomicBooleanTest
{

	public static void main(String[] args)
	{

        Thread thread3 = new Thread(new TestAtomicBoolean("李四"));
        Thread thread4 = new Thread(new TestAtomicBoolean("张三"));

        thread3.start();
        thread4.start();
	}

}
