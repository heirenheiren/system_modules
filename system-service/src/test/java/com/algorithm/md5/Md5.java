package com.algorithm.md5;

import java.security.MessageDigest;
/** 
* @Txtcom.md5
* @author 作者: perlin
* @version 创建时间：2012-3-5 上午04:32:21
*/ 
public class Md5 {
	  private final static String[] hexDigits = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	  public static void main(String[] args){
	    System.err.println(MD5Encode(""));
//	    MD5 ("") = d41d8cd98f00b204e9800998ecf8427e
//		MD5 (”a”) = 0cc175b9c0f1b6a831c399e269772661
//		MD5 (”abc”) = 900150983cd24fb0d6963f7d28e17f72
//		MD5 (”message digest”) = f96b697d7cb7938d525a2f31aaf161d0
//		MD5 (”abcdefghijklmnopqrstuvwxyz”) = c3fcd3d76192e4007dfb496cca67e13b
	  }
	  public static String MD5Encode(String origin) {
		    String resultString = null;
		    try {
		      resultString=new String(origin);
		      MessageDigest md = MessageDigest.getInstance("MD5");
		      for(int i=0;i<(md.digest(resultString.getBytes())).length;i++){
		    	  System.out.println((md.digest(resultString.getBytes()))[i]);
		      }
		      resultString=byteArrayToHexString(md.digest(resultString.getBytes()));
		    }catch (Exception ex) {
		    	ex.printStackTrace();
		    }
		    return resultString;
	  }
	  /**
	   * 转换字节数组为16进制字串
	   * @param b 字节数组
	   * @return 16进制字串
	   */
	  public static String byteArrayToHexString(byte[] b) {
	    StringBuffer sb = new StringBuffer();
	    for (int i = 0; i < b.length; i++) {
	    	//System.out.println(b[i]);
	        sb.append(byteToHexString(b[i]));
	    }
	    return sb.toString();
	  }

	  private static String byteToHexString(byte b) {
	    int n = b;
	    if (n < 0){
	    	n = 256 + n;
	    }
	    int d1 = n / 16;
	    int d2 = n % 16;
	    return hexDigits[d1] + hexDigits[d2];
	  }
}
