package org.system.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkInvokeHandler extends Proxy implements InvocationHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JdkInvokeHandler(InvocationHandler h) {
		super(h);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}

}
