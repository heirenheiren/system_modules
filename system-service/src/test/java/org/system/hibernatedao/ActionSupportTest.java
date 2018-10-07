package org.system.hibernatedao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ActionSupportTest extends ActionSupport
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception
	{
		ActionContext context= ActionContext.getContext();
		context.getSession().put("userList", "userInfo");
		return super.execute();
	}

}
