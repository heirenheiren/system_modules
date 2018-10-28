package org.system.tomcat;

public class FindGirlServlet extends MyServlet
{
	@Override
	public void doGet(MyRequest myRequest, MyResponse myResponse)
	{
		myResponse.write("get girl...");
	}

	@Override
	public void doPost(MyRequest myRequest, MyResponse myResponse)
	{
		myResponse.write("get girl...");
	}

}
