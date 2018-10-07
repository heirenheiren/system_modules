package com.qq;
//功能：全双工通信
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.*;

public class MyServer3 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp=null;
	
	PrintWriter pw=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServer3 ms3=new MyServer3();
	}
	public MyServer3()
	{
		jta=new JTextArea();
		jtf=new JTextField(10);
		jb=new JButton("发送");
		jsp=new JScrollPane(jta);
		jp=new JPanel();
		
		jb.addActionListener(this);
		
		jp.add(jtf);
		jp.add(jb);
		this.add(jsp,"Center");
		this.add(jp,"South");
		this.setTitle("QQ1.0版 Server");
		this.setLocation(200, 200);
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try {
			//端口监听等待
			ServerSocket ss=new ServerSocket(9999);
			Socket s=ss.accept();
			
			//接收客户端信息
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			//回复信息客户端
		    pw=new PrintWriter(s.getOutputStream(),true);
			
			while(true)
			{
				//接收客户端信息
				String infoFromClient=br.readLine();
				//把服务器接收到的信息显示到jta
				jta.append("客户端："+infoFromClient+"\r\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//摁下button
		if(e.getSource()==jb)
		{
			//接收服务器在jtf写的信息
			String info=jtf.getText();
			//把客户端发送的信息显示到jta
			jta.append("服务器："+info+"\r\n");
			//回复信息给客户端
			pw.println(info);
			//清空jtf
			jtf.setText("");
		}
	}
}
