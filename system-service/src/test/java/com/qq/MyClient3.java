package com.qq;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;


public class MyClient3 extends JFrame implements ActionListener{

	JTextArea jta=null;
	JTextField jtf=null;
	JButton jb=null;
	JScrollPane jsp=null;
	JPanel jp=null;
	
	PrintWriter pw=null;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClient3 mc3=new MyClient3();
	}
	public MyClient3()
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
		this.setTitle("QQ1.0版Client");
		this.setLocation(600, 200);
		this.setSize(300,200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		try {
			//连接服务器
			Socket s=new Socket("127.0.0.1",9999);
			
			//接收服务器端信息
			InputStreamReader isr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(isr);
			
			//向服务器发送信息
			pw=new PrintWriter(s.getOutputStream(),true);
			
			while(true)
			{
				//接收服务器信息
				String infoFromServer=br.readLine();
				//把客户端接收到的信息显示到jta
				jta.append("服务器："+infoFromServer+"\r\n");
			}
		} catch (Exception e) {
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
			//接收客户端在jtf写的信息
			String info=jtf.getText();
			//把客户端发送的信息显示到jta
			jta.append("客户端："+info+"\r\n");
			//向服务器发送信息
			pw.println(info);
			//清空jtf
			jtf.setText("");
		}
	}
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		if(e.getKeyCode() == KeyEvent.VK_ENTER)
//		{
//			//接收客户端在jtf写的信息
//			String info=jtf.getText();
//			//把客户端发送的信息显示到jta
//			jta.append("客户端："+info+"\r\n");
//			//向服务器发送信息
//			pw.println(info);
//			//清空jtf
//			jtf.setText("");
//		}
//	}
}
