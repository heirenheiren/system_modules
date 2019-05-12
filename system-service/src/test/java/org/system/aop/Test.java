package org.system.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvocationHandler handler = new JdkInvokeHandler(null);
	     Foo f = (Foo) Proxy.newProxyInstance(Foo.class.getClassLoader(),
	                                          new Class[] { Foo.class },
	                                          handler);
	}

}
