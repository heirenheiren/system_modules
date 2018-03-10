package org.system.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception 
	{
		// 资源销毁
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception 
	{
		arg3.addObject("msg","这里传回的是被拦截器修改之后的消息！");
		arg3.setViewName("/login.jsp");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception 
	{
		//乱码拦截器
		arg0.setCharacterEncoding("utf-8");
		
		//session拦截器
		if(arg0.getSession().getAttribute("user") == null)
		{
			arg0.getRequestDispatcher("/login.jsp").forward(arg0, arg1);
			return false;
		}
		return true;
	}

}
