package org.system.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * 程序的入口，负责启动应用
 * 
 * @author https://segmentfault.com/a/1190000007282628
 *
 */
public class MyWebSocket
{
	public static void main(String[] args)
	{
		EventLoopGroup bossGroup = new NioEventLoopGroup();// 初始化用于Acceptor的主"线程池"以及用于I/O工作的从"线程池"；
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try
		{
			ServerBootstrap b = new ServerBootstrap();//初始化ServerBootstrap实例， 此实例是netty服务端应用开发的入口
			b.group(bossGroup, workGroup)
			 .channel(NioServerSocketChannel.class)
			 //.option(ChannelOption.SO_BACKLOG, 100) // 设置tcp协议的请求等待队列
			 //.handler(new LoggingHandler(LogLevel.INFO))
		     .childHandler(new ChannelInitializer<SocketChannel>()
			{

				@Override
				protected void initChannel(SocketChannel sc) throws Exception
				{
					ChannelPipeline cp = sc.pipeline();
					cp.addLast("http-codec", new HttpServerCodec());
					cp.addLast("aggregator", new HttpObjectAggregator(65536));
					cp.addLast("http-chunked", new ChunkedWriteHandler());
					cp.addLast("handler", new MyWebSocketHandler());
				}
			});
			
			System.out.println("服务端开启等待客户端连接....");
			
			Channel ch = b.bind(8888).sync().channel();
			ch.closeFuture().sync();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			// 优雅的退出程序
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
	}
}
