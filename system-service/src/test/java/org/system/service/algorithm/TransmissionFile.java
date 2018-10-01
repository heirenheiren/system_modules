package org.system.service.algorithm;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//https://zhidao.baidu.com/question/112118386.html
public class TransmissionFile
{
	public static String movePath = "E:\\红鞋子";

	public static void main(String[] args) throws IOException
	{
		new TransmissionFile().sendFile(movePath);
	}

	private void readFile(String filePath, DataOutputStream dos, DataInputStream dis, FileInputStream fis,Socket socket) throws IOException
	{
		File file = new File(filePath);
		File[] files = file.listFiles();// 获取目录下的所有文件或文件夹
		if (files == null)
		{// 如果目录为空，直接退出
			System.out.println(filePath + "为空");
			return;
		}
		// 遍历，目录下的所有文件
		for (File f : files)
		{
			if (f.isFile())
			{
				String fileName = "fileName:" + f.getPath().replace(movePath, "").replace("\\", "/");
				// 1.发送文件名和文件相对路径并等待回复
				byte[] fileNameByte = fileName.getBytes();
				dos.write(fileNameByte);
				dos.flush();
				socket.shutdownOutput();
				byte[] answerByte = new byte[6];
				int answerLen = dis.read(answerByte);
				String answer = new String(answerByte, 0, answerLen);
				//System.out.println(answer);

				if (answer.equals("answer"))
				{
					 fis = new FileInputStream(f);
					 System.out.println(fis.available());
					 socket.getOutputStream();
					 dos.writeInt(fis.available());//传输一个整型值,指明将要传输的文件的大小
					 dos.flush();
					 dis.read();
				}
				
				//
				// // 开始传送
				// byte[] b = new byte[1024*10];
				// while (fis.available()>0)
				// {
				// int n = fis.read(b);
				// dos.write(b, 0, n);
				// dos.flush();
				// //dis.read();
				// System.out.println(fis.available());
				// }
			}
			else if (f.isDirectory())
			{
				readFile(f.getPath(), dos, dis, fis, socket);
			}
		}
	}

	public void sendFile(String filePath)
	{
		Socket socket = null; // 套接字
		FileInputStream fis = null;// 此输入流负责读取本机上要传输的文件
		DataOutputStream dos = null;// 此输出流负责向另一台电脑(服务器端)传输数据
		DataInputStream dis = null;// 此输入流负责读取另一台电脑的回应信息

		try
		{
			// 连接服务器
			socket = new Socket("192.168.0.102", 8080);// must Target's IP
			System.out.println("已连接");
			dos = new DataOutputStream(socket.getOutputStream());
			dis = new DataInputStream(socket.getInputStream());

			readFile(filePath, dos, dis, fis,socket);

			String s = "finish";// 提示传输完毕的标记
			byte bt[] = s.getBytes();
			dos.write(bt, 0, s.length());
			dos.flush();
			System.out.println(s);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 关闭流
			try
			{
				if (dos != null)
					dos.close();
				if (dis != null)
					dis.close();
				if (fis != null)
					fis.close();
				if (socket != null)
					socket.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
