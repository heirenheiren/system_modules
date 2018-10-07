package com.algorithm.g3;
/*
 * short s1 = 0; s1 = s1+1; short s1 = 0; s1 += 1; 2种哪一种编译对，哪种错？为什么？ 
 *前面错 后面对
 *因为s1+1是提升为int运算的,故应该写s1 = (short)(s1+1) ；而s1 +=1 相当于s1 = (short)(s1+1) 
 */
public class IntShort {

	public static void main(String[] args) {
		try {
			short s1 = 0;
			s1 = (short) (s1+1);
			System.out.println(s1);
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		short s2 = 0; 
		s2+= 1;
		System.out.println(s2);
	}

}
