package com.collection;

import java.util.HashSet;
import java.util.Set;
/**
 * 去重
 * @author Administrator
 *
 */
public class HashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "a;a;s;d;wd;w;c;c;h;s;";
		String strArr[] = str.split(";");
		
		Set<String> hs = new HashSet<String>();
		StringBuffer sb = new StringBuffer();
		for(String string:strArr){
			while(!hs.contains(string)){
				hs.add(string);
				sb.append(string+";");
			}
		}
		System.out.println(sb.toString());
	}

}
