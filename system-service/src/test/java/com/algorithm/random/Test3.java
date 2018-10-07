package com.algorithm.random;

import java.util.Random;

/**
 *2011-7-10 下午10:24:34
 *perlin
 */
public class Test3 {
	public static void main(String[] args) {
		//随机产生5-15的数
		Random r=new Random();
		System.out.println(r.nextInt(15-5)+5);
		//0-99
		System.out.println(r.nextInt(100));
		System.out.println((int)(Math.random()*100));
	}
}
