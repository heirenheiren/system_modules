package org.system.domain.httpclient;

import java.io.IOException;

import org.eclipse.jetty.client.ContentExchange;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.HttpExchange;

/**
 * http://www.tuicool.com/articles/ruA7b2
 * http://www.cnblogs.com/zzt-lovelinlin/p/5275168.html
 * @author Administrator
 *
 */
public class JettyClient {

	//同步
	private static void Asynchronous(String method,String url,String port,String content,Class<?> clazz) {
		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		try {
			client.start();
		
			ContentExchange exchange = new ContentExchange();
			exchange.setMethod(method);
			exchange.setURL(url);
			exchange.setTimeout(30000);
			
			client.send(exchange);
			int exchangeState = exchange.waitForDone();
			
			System.err.println("Responsestatus:"+exchange.getResponseStatus());
			System.out.println("Responsecontent:"+exchange.getResponseContent());
			
			client.stop();
			
			if (exchangeState == HttpExchange.STATUS_COMPLETED){
				
			}else if (exchangeState == HttpExchange.STATUS_EXCEPTED){
				
			}else if (exchangeState == HttpExchange.STATUS_EXPIRED){
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//异步
	private static void aAsynchronous(String url) {
		HttpClient client = new HttpClient();
		client.setConnectorType(HttpClient.CONNECTOR_SELECT_CHANNEL);
		try {
			client.start();
		
			//ContentExchange contentExchange = new ContentExchange(cacheFields)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
	}
	
	
}
