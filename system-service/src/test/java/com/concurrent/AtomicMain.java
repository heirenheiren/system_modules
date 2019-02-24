package com.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;


/**
 * AtomicMain https://www.cnblogs.com/luoxn28/p/6059881.html
 * atomic class test https://blog.csdn.net/fenglongmiao/article/details/79402452
 */
public class AtomicMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService   executor  = Executors.newCachedThreadPool();
        AtomicInteger     data      = new AtomicInteger(0);
        AtomicIntegerArray array    = new AtomicIntegerArray(10);
        AtomicReference<User>   reference = new AtomicReference<User>();

        /* AtomicInteger测试 */
        executor.execute(new AtomicIntegerTask(data));
        executor.execute(new AtomicIntegerTask(data));

        /* AtomicIntegerArray测试 */
        executor.execute(new AtomicIntegerArrayTask(array));
        executor.execute(new AtomicIntegerArrayTask(array));

        User user = new User("xxx", 18);
        reference.set(user);
        executor.execute(new AtomicReferenceTask(reference));

        /**
         * shutdown表示线程池不再接收新的任务了，
         * 而不是阻塞到线程池任务执行完成之后再返回
         */
        executor.shutdown();
        /* 延时保证线程池任务执行完毕 */
        Thread.sleep(100);

        System.out.println(data);

        for (int i = 0; i < 10; i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();

        System.out.println(user);
    }

    /**
     * AtomicInteger
     */
    static class AtomicIntegerTask implements Runnable {
        private AtomicInteger data;

        public AtomicIntegerTask(AtomicInteger data) {
            this.data = data;
        }

        public void run() {
            int cnt = 10;

            while (cnt-- > 0) {
                data.incrementAndGet();
            }
        }
    }

    /**
     * 传进来的Array大小至少为10
     * AtomicIntegerArray是原子性的，保证对该array整个内存操作的原子性，
     * 也就是说不可能同时有A线程对array[0]操作，而B线程对array[1]操作
     */
    static class AtomicIntegerArrayTask implements Runnable {
        private AtomicIntegerArray array;

        public AtomicIntegerArrayTask(AtomicIntegerArray array) {
            this.array = array;
        }

        public void run() {
            int cnt = 10;

            while (cnt-- > 0) {
                for (int i = 0; i < 10; i++) {
                    array.getAndAdd(i, 1);
                }
            }
        }
    }

    static class AtomicReferenceTask implements Runnable {
        private AtomicReference<User> reference;

        public AtomicReferenceTask(AtomicReference<User> reference) {
            this.reference = reference;
        }

        public void run() {
            reference.set(new User("luoxn28", 23));
        }
    }

    static class User {
        public String name;
        public int    age;

        public User(String name, int age) {
            this.name = name;
            this.age  = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
