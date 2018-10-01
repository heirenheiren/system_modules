package org.system.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationTest
{
	@MyAnnotation(comments = "111", date = "")
	public String testField;
	
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		try
		{
			Field field = AnnotationTest.class.getField("testField");
			Annotation[] anotation = field.getAnnotations();
			for (int i = 0; i < anotation.length; i++)
			{
				System.out.println(anotation[i]);
			}
		}
		catch (NoSuchFieldException | SecurityException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			for(Method method:MyAnnotation.class.getClassLoader().loadClass("org.system.annotation.MyAnnotation").getMethods())
			{
				//System.out.println(method);
				if(method.isAnnotationPresent(MyAnnotation.class))
				{
					System.out.println(method.getDeclaredAnnotations());
					for(Annotation annotation : method.getDeclaredAnnotations())
					{
						System.out.println(annotation);
					}
					
					MyAnnotation ma = method.getAnnotation(MyAnnotation.class);
					if(ma.revision() == 1)
					{
						System.out.println(method);
					}
				}
			}
		}
		catch (SecurityException | ClassNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
