package com.algorithm.string;

public class GenerateSpace {

	public static String generateSpace(int count) {
	    if(count < 0) {
	        throw new IllegalArgumentException("count must be greater than or equal 0.");
	    }
	    char[] chs = new char[count];
	    for(int i = 0; i < count; i++) {
	        chs[i] = ' ';
	    }
	    return new String(chs);
	}
        
	}


