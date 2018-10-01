package org.system.mail;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Properties props = new Properties();
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol","smtp");
        Session session = Session.getInstance(props);
        session.setDebug(true);
        
        Message msg = new MimeMessage(session);
        try {
			msg.setText("你好吗！");
			msg.setSubject("主题");
			msg.setFrom(new InternetAddress("853450031@qq.com"));
			
			Transport transport = session.getTransport();

			//邮箱	POP3服务器（端口995）	SMTP服务器（端口465或587）
			//qq.com	pop.qq.com	smtp.qq.com
			transport.connect("smtp.qq.com", 587, "853450031@qq.com", "邮箱密码");
			transport.sendMessage(msg, new Address[]{new InternetAddress("853450031@qq.com")});
			//transport.send(msg, new Address[]{new InternetAddress("853450031@qq.com")});
			transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
