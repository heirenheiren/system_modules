package org.system.file;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Administrator
 *
 */
public class JavaCode {
	private static final String PROJECT_DIR = "C:\\test";
	private static int totle = 0;		//总行数				
	private static int source  = 0;		//代码行数			
	private static int blank  = 0;		//空白行数				
	private static int comments = 0;	//注释行数
	
	/**
	 * 读取文件夹内java文件
	 * @param dir
	 */
	private static void listNext(File dir) {
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			//判断是否是文件夹，如果是文件夹继续向下检索
			if (files[i].isDirectory()) {
				listNext(files[i]);
			} else {
				try {
					if (files[i].getName().endsWith(".java")) {
						System.out.println(files[i].getAbsolutePath());
						javaLine(files[i]);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * 读取java文件总行数，代码行数，空白行数，注释行数
	 * @param f
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	private static void javaLine(File f) throws FileNotFoundException, IOException{
		String strLine = "";
		String str = fromFile(f);
		if (str.length() > 0) {
			while (str.indexOf('\n') != -1) {
				totle++;
				//System.out.println(totle);
				strLine = str.substring(0, str.indexOf('\n')).trim();
				//str = str.substring(str.indexOf('\n') + 1, str.length());
				if (strLine.length() == 0 ) {
					blank++;
				}else if (strLine.charAt(0) == '*' || strLine.charAt(0) == '/') {
					comments++;
				}else{
					source++;
					String regEx = "^*//";
					if(regEx(strLine,regEx)){
						comments++;
					}
				}
				str = str.substring(str.indexOf('\n') + 1, str.length());
			}
		}	
	}
	
	/**
	 * 将java文件以字符数组形式读取
	 * @param f
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static String  fromFile(File f) throws FileNotFoundException,IOException {
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[(int) f.length()];
		fis.read(b);
		fis.close();
		return new String(b);
	}
	
	/**
	 * 正则匹配
	 * @param str 输入字符串
	 * @param regEx 正则匹配字符串
	 * @return
	 */
	private static boolean regEx(String str,String regEx){
		Pattern p=Pattern.compile(regEx);
		Matcher m=p.matcher(str);
		boolean result=m.find();
		return result;
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		//File root = new File(PROJECT_DIR);
		File directory = new File("");//参数为空 
		//获取项目路径
		String projectFile = directory.getCanonicalPath() ;
		System.out.println(projectFile+"===============");
		listNext(new File(projectFile));
		System.out.println(totle+1);
		System.out.println(source);
		System.out.println(blank);
		System.out.println(comments);
	}


}






