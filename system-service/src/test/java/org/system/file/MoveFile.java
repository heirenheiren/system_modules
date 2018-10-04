package org.system.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MoveFile {
	private static int i=1;
	public static void main(String[] args) throws IOException {
		String fileName="G:\\编程语言\\2011年LAMP兄弟连\\php分享网ecshop二次开发视频教程";
		File filepath = new File(fileName);
		File[] files = filepath.listFiles();
		for(File file:files){
			if(file.isDirectory()){
				File[] subFiles = new File(file.getPath()).listFiles();
				for(File subfile:subFiles){
					//1.移动文件
					//System.out.println(fileName+File.separator+file.getName());
					System.out.println(subfile.getName());
					//copy(subfile.getPath(),fileName+File.separator+subfile.getName());
					
					//2.修改文件名
					//System.out.println(subfile.getParent());
					//System.out.println(subfile.getPath());
					//rename(subfile.getPath(),subfile.getParent(),file.getName());

					//3.删除文件
					//subfile.delete();
				}
			}
		}
		i=1;
	}

	private static void rename(String path, String parent, String name) throws IOException {
		// TODO Auto-generated method stub
		File oldFile = new File(path);
		if(!oldFile.exists()){
			oldFile.createNewFile();
		}
		File newFile = new File(parent + File.separator + name +".avi");
		if(oldFile.renameTo(newFile)){
			System.out.println("第"+(i++)+"文件修改成功！");
		}else{
			System.out.println("第"+(i++)+"文件修改失败！");
		}
	}

	private static void copy(String from, String to) throws IOException {
		// TODO Auto-generated method stub
		int BUFFER_SIZE=100000;
		byte[] buffer = new byte[BUFFER_SIZE];
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new FileInputStream(from);
			out = new FileOutputStream(to);
			while(true){
				synchronized (buffer) {
					int amoutRead = in.read(buffer);
					if(amoutRead == -1){
						break;
					}
					out.write(buffer);
					System.out.println("第"+(i++)+"文件移动成功！");
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			if(in!=null){
				in.close();
			}
			if(out!=null){
				out.close();
			}
		}
	}
}

