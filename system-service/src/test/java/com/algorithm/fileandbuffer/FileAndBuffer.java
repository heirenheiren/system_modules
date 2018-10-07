package com.algorithm.fileandbuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JTextArea;

/** 
* @Txtcom.hyq
* @author 作者: perlin
* @version 创建时间：2012-3-5 上午01:36:20
*/
public class FileAndBuffer {
	public static void main(String[] args) throws IOException{
		//创建txt文件并且写入内容，再把txt内容读取出来，最后把txt文件删除
		System.out.println("--------------------------------------------------------------------");
		CreateTextFile1();
		
		System.out.println("--------------------------------------------------------------------");
		CreateTextFile2();
		
		System.out.println("--------------------------------------------------------------------");
		//产生随机字符串 
		CreateTextFile3();
		
		/**
		 * 有一个txt文件，里面有若干条记录，每个记录分别有四个字段为：编号，姓名，年龄，性别，格式如下：
		 * 0000001|aa|19|f
		 * 0000002|bb|20|m 
		 * 请问我如何将这个文件内的每一条记录的每一个字段都读出来，赋给相应的变量？
		 * @param args
		 */
		System.out.println("--------------------------------------------------------------------");
		CreateTextFile4();
		
		/*
		 * 使用BufferedWriter和BufferedReader copy file
		 */
		System.out.println("--------------------------------------------------------------------");
		CreateTextFile5();
		
		/*
		 * 读取一段英文文档统计每个单词出现的次数和单词的总数
		 */
		System.out.println("--------------------------------------------------------------------");
		UserTreeMap();
		
		/**
		 * 编写一个Java应用程序，使用RandomAccessFile流统计Hello.txt中的单词，要求如下：
		 * （1）计算全文中共出现了多少个单词（重复的单词只计算一次）； （2）统计出有多少个单词只出现了一次；
		 * （3）统计并显示出每个单词出现的频率，并将这些单词按出现频率高低顺序显示在一个TextArea中。
		 */
		System.out.println("--------------------------------------------------------------------");
		UserArrayList();
	}
	private static void UserArrayList() {
		// TODO Auto-generated method stub
		class WordFreq {
			private String word;
			private int count;
			public WordFreq(String word, int count) {
				this.word = word;
				this.count = count;
			}
			public int getCount() {
				return count;
			}
			public String toString() {
				return "\t"+word + "\t" + count;
			}
		}
		
		try {
			String fileName = "D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\english.txt";
			RandomAccessFile file = new RandomAccessFile(new File(fileName), "r");
			String content = null;// 存储文章内容
			Map<String, Integer> map = new HashMap<String, Integer>();
			while ((content = file.readLine()) != null) {
				String[] ary = content.replaceAll("'|\\?|,|\\.|","").split("\\s+");
				for (String str : ary) {
					if (map.containsKey(str.trim())) {
						map.put(str, new Integer(map.get(str).intValue() + 1));
					} else {
						map.put(str.trim(), new Integer(1));
					}
				}
			}

			List<WordFreq> list = new ArrayList<WordFreq>();

			for (Iterator<?> iter = map.entrySet().iterator(); iter.hasNext();) {
				Map.Entry<String, Integer> element = (Map.Entry<String, Integer>)iter.next();
				list.add(new WordFreq(element.getKey(), element.getValue()));
			}

			Collections.sort(list, new Comparator<WordFreq>() {
				public int compare(WordFreq o1, WordFreq o2) {
					return o1.getCount() < o2.getCount() ? 1 : -1;
				}
			});

			int uniqueCount = 0;
			final StringBuilder sb = new StringBuilder();
			final String NEW_LINE = "\r\n";

			for (Object obj : list) {
				WordFreq item = (WordFreq) obj;
				uniqueCount += (item.getCount() == 1 ? 1 : 0);
				sb.append(item.toString());
				//System.out.println(item.toString());
				sb.append(NEW_LINE);
			}

			JFrame f = new JFrame();
			JTextArea result = new JTextArea();

			result.append("Total " + list.size() + " words found in " + fileName);
			result.append(NEW_LINE);
			result.append("Total " + uniqueCount + " words appear only once");
			result.append(NEW_LINE);
			result.append(NEW_LINE);
			result.append(sb.toString());

			f.add(result);
			f.setVisible(true);
			f.pack();
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("统计单词数量");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static void UserTreeMap() {
		// TODO Auto-generated method stub
		try {
			BufferedReader bf = new BufferedReader(new FileReader("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\english.txt"));
			System.out.println("Read under this dir English.txt");
			StringBuffer sb = new StringBuffer();// 缓冲字符串
			String line = null;
			while ((line = bf.readLine()) != null) {
				sb.append(line);// 追加到缓冲字符串中
			}
			bf.close();// 读取结束
			
			Pattern expression = Pattern.compile("[a-zA-Z]+");// 定义正则表达式匹配单词.包含数字"[1-9a-zA-Z]+"
			String str = sb.toString().toLowerCase();// 转换成小写
			Matcher matcher = expression.matcher(str);// 定义string1的匹配器
			TreeMap<Object, Integer> myTreeMap = new TreeMap<Object, Integer>();// 创建树映射 存放键/值对
			int n = 0;// 文章中单词总数
			Object word = null;// 文章中的单词
			Object num = null;// 出现的次数
			while (matcher.find()) {// 是否匹配单词
				word = matcher.group();// 得到一个单词-树映射的键
				n++;// 单词数加1
				if (myTreeMap.containsKey(word)) {// 如果包含该键，单词出现过
					num = myTreeMap.get(word);// 得到单词出现的次数
					Integer count = (Integer) num;// 强制转化
					myTreeMap.put(word, new Integer(count.intValue() + 1));
				} else {
					myTreeMap.put(word, new Integer(1));// 否则单词第一次出现，添加到映射中
				}
			}
			
			BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\result.txt"));
			Iterator<Object> iter = myTreeMap.keySet().iterator();// 得到树映射键集合的迭代器
			Object key = null;
			int m=0,k=0;
			while (iter.hasNext()) {// 使用迭代器遍历树映射的键
				key = iter.next();
				m++;
				bw.write("第"+m+"个单词（出现"+myTreeMap.get(key)+"次）：" + (String) key);// 键/值写到文件中
				if(myTreeMap.get(key)==1){
					k++;
				}
				bw.newLine();
			}
			bw.write("english.txt中的单词总数" + n + "个");
			bw.newLine();
			bw.write("english.txt中不同单词" + myTreeMap.size() + "个");
			bw.close();
			
			System.out.println("统计分析如下：");
			System.out.println("文章中单词总数" + n + "个");
			System.out.println("文章中不同单词"+myTreeMap.size()+"个");
			System.out.println("只出现一次的单词数:"+k);
			System.out.println("具体的信息在当前目录的result.txt文件中");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static void CreateTextFile5() {
		// TODO Auto-generated method stub
		try{
			FileReader fr = new FileReader("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\reader.txt");
			BufferedReader br = new BufferedReader(fr);
	       
			FileWriter fw = new FileWriter("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\newreader.txt"); //写文件操作，把得到的fr对应的文件中内容写入，writerfile中去。
			BufferedWriter bw = new BufferedWriter(fw);
			String readoneline;
			readoneline = br.readLine();
			while (readoneline != null)
			{ 
				bw.write(readoneline);
				bw.newLine();
				System.out.println(readoneline); 
				readoneline = br.readLine();
			}

			bw.flush();
			br.close();
			bw.close();
			fw.close();
			fr.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	private static void CreateTextFile4() {
		// TODO Auto-generated method stub
		try {
			String fname = "D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\reader.txt";
			BufferedReader reader = new BufferedReader(new FileReader(fname));
			String line;
			System.out.println("编号\t"+"姓名\t"+"年龄\t"+"性别");
			while ((line = reader.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(line, "|");
				while (tokenizer.hasMoreElements()) {
					//Object object = (Object) tokenizer.nextElement();
					Object object = (Object) tokenizer.nextToken();
					System.out.print(object+"\t");
				}
				System.out.println();
			}
			reader.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static void CreateTextFile3() {
		// TODO Auto-generated method stub
		Random rand=new Random();  
        int randname=rand.nextInt(100);
		String str = randomString(randname);
		System.out.println("random char:"+str+" "+randname);
		try {
			int randname1 = rand.nextInt(100000);
			String fname = "D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\"+randname1+str+".txt";
			File file = new File(fname);
			FileWriter fw = new FileWriter(file);
			
//			fw.write(fname);
//			fw.write("\r\n"); //给写进去txt的内容换行  
//			fw.write("你好，中国");  
//			fw.append("---hello world---"); 
//			fw.close(); 
			
			BufferedWriter bw=new BufferedWriter(fw);  
            bw.append("nihao-");  
            bw.newLine();  
            bw.write("我是中国人");
            bw.close();
            
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			do {
				String show = br.readLine();
				System.out.println("读出CreateTxtFile.txt里面的内容为："+show);
			} while (br.ready());
			br.close();
			fr.close();
			
//			FileReader fr=new FileReader(file);  
//          System.out.println("FileReader---:"+fr.read());
//          fr.close();  
			
			file.delete();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private static String randomString(int length) {
		Random randGen = null;
		char[] numbersAndLetters = null;
		Object initLock = new Object();
		if(length<1){
			return null;
		}
		if(randGen == null){
			synchronized (initLock) {
				 if (randGen == null) {  
	                    randGen = new Random();  
	                    numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz" + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();  
	                    //numbersAndLetters = ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();  
	                } 
			}
		}
		char [] randBuffer = new char[length];  
        for (int i=0; i<randBuffer.length; i++) {  
            randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];  
          //randBuffer[i] = numbersAndLetters[randGen.nextInt(35)];  
        }  
        return new String(randBuffer); 
	}
	private static void CreateTextFile2() {
		// TODO Auto-generated method stub
		try {
			long start_time = System.currentTimeMillis();
			System.out.println("Start Time:"+start_time);
			File f = new File("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\CreateTxtFile.txt");
			FileWriter fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("first cteate xml file");
			bw.write("\n");
			bw.write("first cteate xm");
			bw.close();
			System.out.println("写入CreateTxtFile.txt的内容为："+bw);
			
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			do {
				String show = br.readLine();
				System.out.println("读出CreateTxtFile.txt里面的内容为："+show);
			} while (br.ready());
			br.close();
			f.delete();
			long end_time = System.currentTimeMillis();
			System.out.println("end Time:"+end_time);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private static void CreateTextFile1() {
		// TODO Auto-generated method stub
		try {
			File file = new File("D:\\Program Files\\MyEclipse-9.0M1\\Workspaces\\Algorithm\\txt\\test.txt");
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("cbuf \\  \\r \\n i am ni");
			//bw.newLine();//换行
			bw.write("cbuf \\  \\r \\n i am ni666666666");
			bw.close();
			
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String show = br.readLine();
			System.out.println(show);
			br.close();
			//file.delete();//删除txt文件
			file.deleteOnExit();//这个方法和上面一个一样，但是比较严重，慎用。
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
