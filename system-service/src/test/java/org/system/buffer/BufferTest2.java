package org.system.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class BufferTest2
{

	public static void main(String[] args) throws IOException
	{
		String path = "D:\\test.txt";
        //聚集写
        //这是一组数据
        ByteBuffer byteBuffer1 = ByteBuffer.wrap("Java是最好的工具".getBytes(Charset.forName("UTF-8")));
        ByteBuffer byteBuffer2 = ByteBuffer.wrap("像风一样".getBytes(Charset.forName("UTF-8")));
        //记录数据长度
        int length1 = byteBuffer1.limit();
        int length2 = byteBuffer2.limit();
        //用 ByteBuffer 数组存放ByteBuffer实例的引用。
        ByteBuffer[] byteBuffers = new ByteBuffer[]{byteBuffer1, byteBuffer2};
        //获取文件写通道
        FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
        FileChannel channel = fileOutputStream.getChannel();
        //开始写
        channel.write(byteBuffers);
        channel.close();
        
        //散射读
        byteBuffer1 = ByteBuffer.allocate(length1);
        byteBuffer2 = ByteBuffer.allocate(length2);
        byteBuffers = new ByteBuffer[]{byteBuffer1,byteBuffer2};
        //获取文件读通道
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        channel = fileInputStream.getChannel();
        //开始读
        channel.read(byteBuffers);
        //读取
        System.out.println(new String(byteBuffers[0].array(),"utf-8"));
        System.out.println(new String(byteBuffers[1].array(),"utf-8"));
	}

}
