package com.collection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class Nio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Nio nio = new Nio();
		try {
			nio.startServer();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void startServer() throws IOException {
		// TODO Auto-generated method stub
		int channels = 0;
		int nKeys = 0;
		
		Selector selector = Selector.open();
		
		//create channel and bind to 9000 port
		ServerSocketChannel ssc = ServerSocketChannel.open();
		InetSocketAddress address = new InetSocketAddress(InetAddress.getLocalHost(),9000);
		
		ssc.socket().bind(address);
		ssc.configureBlocking(false);
		
		SelectionKey sk = ssc.register(selector, SelectionKey.OP_ACCEPT);
		printKeyInfo(sk);
		
		while(true){
			debug("Nio:Starting select");
			
			nKeys = selector.select();
			if(nKeys>0){
				debug("Nio:Number of nKeys after select operation "+nKeys);
				
				Set<?> selectedKeys = selector.selectedKeys();
				Iterator<?> it = selectedKeys.iterator();
				
				while(it.hasNext()){
					sk = (SelectionKey)it.next();
					printKeyInfo(sk);
					debug("Nio:Nr Keys in selector " + selector.keys().size());
					
					it.remove();
					
					if(sk.isAcceptable()){
						Socket socket = ((ServerSocketChannel)sk.channel()).accept().socket();
						SocketChannel sc = socket.getChannel();
						
						sc.configureBlocking(false);
						sc.register(selector, SelectionKey.OP_READ|SelectionKey.OP_WRITE);
						
						System.out.println(++channels);
					}else{
						debug("Nio: Select finished without any keys.");
					}
				}
			}
		}
	}

	private static void printKeyInfo(SelectionKey sk) {
		// TODO Auto-generated method stub
		String s = new String();
		s = "Att:"+(sk.attachment()==null?"no":"yes");
		s += ",Read:"+sk.isReadable();
		s += ",Acpt:"+sk.isAcceptable();
		s += ",Conn:"+sk.isConnectable();
		s += ",Wrt:"+sk.isWritable();
		s += ",Valid:"+sk.isValid();
		s += ",Ops:"+sk.interestOps();
		debug(s);
	}

	private static void debug(String s) {
		// TODO Auto-generated method stub
		System.out.println(s);
	}

}
