package com.qq;
//功能：半双工通信
import java.io.*;
import java.net.*;
public class MyServer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer2 ms1=new MyServer2();
	}
	public MyServer2()
	{
		try {
			//端口监听等待
			System.out.println("服务器在9999端口监听客户端来连接......");
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			
			//接收客户端信息
			InputStreamReader isr1=new InputStreamReader(s.getInputStream());
			BufferedReader br1=new BufferedReader(isr1);
			
			//接收控制台输入的信息
			InputStreamReader isr2=new InputStreamReader(System.in);
			BufferedReader br2=new BufferedReader(isr2);
			
			//回复客户端信息
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			
			while(true)
			{
				//接收客户端信息
				String infoFromClient=br1.readLine();
				System.out.println("客户端发来："+infoFromClient);
				
				//退出
				if(infoFromClient.equals("88"))
				{
					System.out.println("对话结束");
					s.close();
					break;
				}
				
				//接收控制台输入的信息
				System.out.println("输入回复客户端的信息：");
				String response=br2.readLine();
				
				//回复给客户端
				pw.println(response);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
