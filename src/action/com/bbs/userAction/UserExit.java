package com.bbs.userAction;

import java.util.List;

import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.User;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserExit extends ActionSupport {
       @Override
    public String execute() throws Exception {
    	ServletActionContext.getRequest().getSession().invalidate();
    	List<User> userGroup=(List)ServletActionContext.getServletContext().getAttribute("userGroup");
    	User user = (User)ServletActionContext.getRequest().getSession().getAttribute("currentUser");
    	if(user!=null){
    	userGroup.remove(user);
    	}
		Cookie coo1 = new Cookie("userName","");
		Cookie coo2 = new Cookie("password","");
		Cookie coo3 = new Cookie("code","");
		coo1.setMaxAge(0);
		coo2.setMaxAge(0);
		coo3.setMaxAge(0);
		ServletActionContext.getResponse().addCookie(coo1);
		ServletActionContext.getResponse().addCookie(coo2);
		ServletActionContext.getResponse().addCookie(coo3);
    	return "index";
    }
}
