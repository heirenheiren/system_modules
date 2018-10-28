package org.system.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 能够看到 Tomcat 的处理流程，即把 URL 对应处理的 Servlet 关系形成，解析 HTTP 协议，封装请求/响应对象，利用反射实例化具体的 Servlet 进行处理即可。
 * @author Administrator
 *
 */
public class MyTomcat
{
	private static Logger logger = LoggerFactory.getLogger(MyTomcat.class);
	
	private int port = 8080;
	private Map<String,String> urlServletMap = new HashMap<String,String>();
	
	public MyTomcat(int port)
	{
		this.port = port;
	}

	public static void main(String[] args)
	{
		//http://127.0.0.1:8080/girl
		//http://127.0.0.1:8080/world
		new MyTomcat(8080).start();
	}
	
	public void start()
	{
		//初始化：url与对应处理的servlet的关系
		initServletMapping();
		
		ServerSocket serverSocket = null;
		try
		{
			serverSocket = new ServerSocket(port);
			logger.debug("MyTomcat is starting...");
			
			while(true)
			{
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				
				MyRequest myRequest = new MyRequest(inputStream);
				MyResponse myResponse = new MyResponse(outputStream);
				
				//请求分发
				dispatch(myRequest,myResponse);
				socket.close();
			}
		}
		catch (IOException e)
		{
			logger.error(e.getMessage());
		}
		finally
		{
			if(serverSocket != null)
			{
				try
				{
					serverSocket.close();
				}
				catch (IOException e)
				{
					logger.error(e.getMessage());
				}
			}
		}
	}

	private void dispatch(MyRequest myRequest, MyResponse myResponse)
	{
		String clazz = urlServletMap.get(myRequest.getUrl());
		
		try
		{
			Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
			MyServlet myServlet = myServletClass.newInstance();
			myServlet.service(myRequest, myResponse);
		}
		catch (NullPointerException e)
		{
			logger.error(e.getMessage());
		}
		catch (ClassNotFoundException e)
		{
			logger.error(e.getMessage());
		}
		catch (InstantiationException e)
		{
			logger.error(e.getMessage());
		}
		catch (IllegalAccessException e)
		{
			logger.error(e.getMessage());
		}
	}

	private void initServletMapping()
	{
		for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList)
		{
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
		
	}
}
