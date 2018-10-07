package com.qq;

import java.io.*;
import java.net.*;
public class MyClient1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient1 mc1=new MyClient1();
	}
	
	public MyClient1()
	{
		try {
			//Socket()就去连接某个服务器，127.0.0.1表示服务器的ip
			//9999就是端口号
			Socket s=new Socket("127.0.0.1",9999);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("你好！我是客户端");
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String response=br.readLine();
			System.out.println("客户端接收到了："+response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
