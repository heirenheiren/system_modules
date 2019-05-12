package org.system.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BufferTest
{
	private static String source = "D://android-sdk-windows-2.1.rar";
	private static String target = "E:\\android-sdk-windows-2.1.rar";
	public BufferTest()
	{
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException
	{
		//写文件通道
        FileOutputStream fileOutputStream = new FileOutputStream(new File(target));
        FileChannel wChannel = fileOutputStream.getChannel();
        
        //读文件通道
        FileInputStream fileInputStream = new FileInputStream(new File(source));
        FileChannel rChannel = fileInputStream.getChannel();
        
        ByteBuffer byteBufferRead = ByteBuffer.allocate(1024);//从堆中分配缓冲区
        
        while(rChannel.read(byteBufferRead)!=-1){
            byteBufferRead.flip();//将Buffer从写状态切换到读状态
            while(byteBufferRead.hasRemaining()){
                wChannel.write(byteBufferRead);
            }
            byteBufferRead.clear();//为读入数据到Buffer做准备
        }
        wChannel.close();
        rChannel.close();
	}

}
