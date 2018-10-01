package org.system.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class App1 
{

	public static void main(String[] args) 
	{
		Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol","smtp");
        props.setProperty("mail.host", "smtp.sina.com");
        Session session = Session.getInstance(props, 
        		new Authenticator()
        		{
        			protected PasswordAuthentication getPasswordAuthentication()
        			{
						return new PasswordAuthentication("zhouboliang88@sina.com","邮箱密码");
        			}
        		}
        );
        session.setDebug(true);
        
        Message msg = new MimeMessage(session);
        try {
			msg.setFrom(new InternetAddress("zhouboliang88@sina.com"));
			msg.setSubject("This's subject!");
	        msg.setRecipients(RecipientType.TO, InternetAddress.parse("383446184@qq.com,909484474@qq.com"));
	        msg.setContent("<span style='color:red'>red word!hahaha!呵呵！</span>", "text/html;charset=utf-8");
	        Transport.send(msg);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
