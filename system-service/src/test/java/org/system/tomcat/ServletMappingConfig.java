package org.system.tomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig
{

	public static List<ServletMapping> servletMappingList = new ArrayList<>();
	
	static
	{
		servletMappingList.add(new ServletMapping("findGril", "/girl", "org.system.tomcat.FindGirlServlet"));
		servletMappingList.add(new ServletMapping("helloWorld", "/world", "org.system.tomcat.HelloWorldServlet"));
	}

}
