package org.system.ftp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;

public class FtpTest
{

	public static void main(String[] args)
	{
		try {
			URL url = new URL("ftp://szftp:szftp@210.22.12.21");
			PrintWriter pw = new PrintWriter(url.openConnection().getOutputStream());
			pw.write("this is a test!");
			pw.flush();
			pw.close();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
