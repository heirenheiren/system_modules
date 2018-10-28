package org.system.tomcat;

public class HelloWorldServlet extends MyServlet
{
	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse)
	{
		myResponse.write("get HelloWorlServlet...");
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse)
	{
		myResponse.write("get HelloWorlServlet...");
	}

}
