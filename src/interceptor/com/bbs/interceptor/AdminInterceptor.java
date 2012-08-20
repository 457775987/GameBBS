package com.bbs.interceptor;

import org.apache.struts2.ServletActionContext;

import com.bbs.bean.Admin;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class AdminInterceptor implements Interceptor {
    private String type="";
    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void destroy() {
	}

	public void init() {
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		   Admin admin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("currentAdmin");
		   if(admin!=null){
			   return invocation.invoke();
		   }
		   if(type.equals("json")){
			   ServletActionContext.getResponse().getWriter().println("{\"errorMessage\":\"当前离线状态，请重新登录。\"}");
			   return null;
		   }
		   return "adminError";
	}

}
