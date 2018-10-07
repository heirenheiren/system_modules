package com.qq; 

import java.io.*;
import java.net.*;
public class MysServer1 { 
	
	public static void main(String[] args)
	{
		MysServer1 ms1=new MysServer1();
	}
	public MysServer1()
	{
		try {
			//在9999号端口监听
			ServerSocket ss=new ServerSocket(9999);
			System.out.println("我是服务器，在9999端口监听。。。");
			//等待某个客户端来连接，该函数会返回一个Socket连接
			Socket s=ss.accept();
			System.out.println("11");
			
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			String info=br.readLine();
			System.out.println("服务器接收到了："+info);
			
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			pw.println("客户端你好！我也收到你的信息了");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}