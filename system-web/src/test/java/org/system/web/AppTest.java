package org.system.web;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest
{
	public static void main(String[] args)
	{
    	BeanFactory beanFactory = new ClassPathXmlApplicationContext("");
    	beanFactory.getBean("");
	}
}
