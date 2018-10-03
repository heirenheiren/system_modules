package org.system.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.web.context.support.XmlWebApplicationContext;

public class BeanFactoryTest
{
	private static ApplicationContext context;
	
	static
	{
		//该容器从 XML 文件中加载已被定义的 bean。在这里，你不需要提供 XML 文件的完整路径，只需正确配置 CLASSPATH 环境变量即可，因为，容器会从 CLASSPATH 中搜索 bean 配置文件。
		context = new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml", "applicationContext-part2.xml"});
		//该容器从 XML 文件中加载已被定义的 bean。在这里，你需要提供给构造器 XML 文件的完整路径
		context = new FileSystemXmlApplicationContext("C:/applicationContext.xml");
		//该容器会在一个 web 应用程序的范围内加载在 XML 文件中已被定义的 bean。
		context = new XmlWebApplicationContext();
	}
	
	public static BeanFactory getBeanFactory()
	{
		return (BeanFactory) context;
	}
	
	public static void main(String[] args)
	{
		//XmlBeanFactory已经被抛弃
		Resource resource = new FileSystemResource("beans.xml");
		XmlBeanFactory factory = new XmlBeanFactory(resource);
		
		ClassPathResource resource1 = new ClassPathResource("beans.xml,beans1.xml");
		XmlBeanFactory factory1 = new XmlBeanFactory(resource1);
		
		
		//根据Xml配置文件创建Resource资源对象，该对象中包含了BeanDefinition的信息
		 ClassPathResource resource2 =new ClassPathResource("application-context.xml");
		//创建DefaultListableBeanFactory
		 DefaultListableBeanFactory factory2 =new DefaultListableBeanFactory();
		//创建XmlBeanDefinitionReader读取器，用于载入BeanDefinition。之所以需要BeanFactory作为参数，是因为会将读取的信息回调配置给factory
		 XmlBeanDefinitionReader reader =new XmlBeanDefinitionReader(factory2);
		//XmlBeanDefinitionReader执行载入BeanDefinition的方法，最后会完成Bean的载入和注册。完成后Bean就成功的放置到IOC容器当中，以后我们就可以从中取得Bean来使用
		 reader.loadBeanDefinitions(resource2);
		 reader.getBeanFactory();
	}
}
