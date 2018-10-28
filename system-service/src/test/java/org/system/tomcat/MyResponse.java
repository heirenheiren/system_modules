package org.system.tomcat;

import java.io.IOException;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基于HTTP协议的格式进行输出写入
 * @author Administrator
 *
 */
public class MyResponse
{
	private static Logger logger = LoggerFactory.getLogger(MyResponse.class);
	
	private OutputStream outputStream;
	public MyResponse(OutputStream outputStream)
	{
		this.outputStream = outputStream;
	}
	public void write(String content)
	{
		StringBuffer httpResponse = new StringBuffer();
		httpResponse.append("HTTP/1.1 200 OK\n")
		.append("Content-Type: text/html\n")
		.append("\r\n")
		.append("<html><body>")
		.append(content)
		.append("<body><html>");
		
		try
		{
			outputStream.write(httpResponse.toString().getBytes());
			outputStream.close();
		}
		catch (IOException e)
		{
			logger.debug(e.getMessage());
		}
		finally
		{
			if(outputStream != null)
			{
				try
				{
					outputStream.close();
				}
				catch (IOException e)
				{
					logger.debug(e.getMessage());
				}
			}
		}
	}
}
