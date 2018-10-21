package com.collection;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.Format;

/**
 * des：
 * author: zbl
 * date: 2014年12月17日
 **/
public class LineCount {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String rootUrl = "D:\\workspace_maven\\huawei\\src\\com\\huawei\\inter\\impl\\";
		//Recurisive(rootUrl);
		try {
			String url = "file:/C:\\maven_web.jar";
			URLClassLoader  ucl = new URLClassLoader(new URL[]{new URL(url)},Thread.currentThread().getContextClassLoader());
			Class<?> clazz = ucl.loadClass("com.eliteams.quick4j.web.service.impl.RoleServiceImpl");
			Method[] methods = clazz.getDeclaredMethods();
			for (Method method : methods) {
				System.out.println(method.getName());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static void Recurisive(String rootUrl) {
		// TODO Auto-generated method stub
		File file = new File(rootUrl);
		
		File files[] = file.listFiles();
		try {
			for (int i = 0; i < files.length; i++) {
				if(files[i].isDirectory()==true){
					Recurisive(rootUrl+files[i].getName()+"\\");
				}else{
					if(files[i].getName().endsWith(".java")){
						Class<?> clazz = Class.forName("com.huawei.inter.impl."+files[i].getName().substring(0, files[i].getName().indexOf(".")).toString().trim());
						Method[] fields = clazz.getDeclaredMethods();
						for (Method field : fields) {
							System.out.println(field.getName());
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
