package com.algorithm.string;

public class GenerateSpace1 {
	public static void main(String[] args) {
        long t0, t1;
        String str = null;
        final int COUNT = 10000;
        t0 = System.nanoTime();
        for(int i = 0; i < COUNT; i++) {
            str = generateSpace(10000);
        }
        t1 = System.nanoTime();
        System.out.println((t1 - t0) / (float)COUNT);
        System.out.println(str.length());
    }
//fuck what about
	private static String generateSpace(int i) {
		return null;
	}
}
