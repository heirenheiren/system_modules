package com.qq;

import java.io.*;
import java.net.*;

public class MyClient2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient2 mc2=new MyClient2();
	}
	public MyClient2()
	{
		try {
			//连接服务器
			Socket s=new Socket("127.0.0.1",9999);
			
			//从控制台输入信息
			InputStreamReader isr1=new InputStreamReader(System.in);
			BufferedReader br1=new BufferedReader(isr1);
			
			//向服务器发送信息
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			//接收服务器端信息
			InputStreamReader isr2=new InputStreamReader(s.getInputStream());
			BufferedReader br2=new BufferedReader(isr2);
			
			while(true)
			{
				System.out.println("输入发送给服务器端的信息：");
				
				//从控制台输入信息
				String info=br1.readLine();
				
				//向服务器发送信息
				pw.println(info);
				
				//退出
				if(info.equals("88"))
				{
					System.out.println("对话结束");
					s.close();
					break;
				}
				
				//接收服务器端信息
				String response=br2.readLine();
				System.out.println("服务器发来："+response);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
