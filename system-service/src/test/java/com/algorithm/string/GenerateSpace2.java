package com.algorithm.string;

public class GenerateSpace2 {
	public static String generateSpace(int count) {
	    if(count < 0) {
	        throw new IllegalArgumentException("count must be greater than or equal 0.");
	    }
	    // A 组初始化时给定 count，B 组初始化时不给定 count
	    StringBuilder sb = new StringBuilder(count);
	    for(int i = 0; i < count; i++) {
	        sb.append(' ');  // C 组使用字符空格，S 组使用字符串空格
	    }
	    return sb.toString();
	}


}
