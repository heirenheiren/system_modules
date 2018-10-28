package org.system.tomcat;

import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * 通过输入流，对 HTTP 协议进行解析，拿到了 HTTP 请求头的方法以及 URL
 * @author Administrator
 *
 */
public class MyRequest
{
	private static Logger logger = LoggerFactory.getLogger(MyRequest.class);
	private String url;
	private String method;
	
	public MyRequest(InputStream inputStream) throws IOException
	{
		String httpRequest = "";
		byte[] httpRequestByte = new byte[1024];
		int length = 0;
		if((length = inputStream.read(httpRequestByte))>0)
		{
			httpRequest = new String(httpRequestByte,0,length);
		}
		
		String httpHead = httpRequest.split("\n")[0];
		this.url = httpHead.split("\\s")[1];
		this.method = httpHead.split("\\s")[0];
		logger.debug("this:",this);
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getMethod()
	{
		return method;
	}

	public void setMethod(String method)
	{
		this.method = method;
	}
	
}
