package com.bbs.userAction;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.User;
import com.bbs.service.IUserManagerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserSimpleQuery extends ActionSupport {
	   private User user = null;
	   @Resource(name="userService") private IUserManagerService userService = null;
	   @Resource(name="gsonBuilder") private GsonBuilder gsonBuilder = null;
	   private String page;
	   private Gson gson = null;
       private int userId = 0;
    public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	@Override
    public String execute() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm").create();
    	user = userService.getUserById(userId);
    	if(user!=null){
    		ServletActionContext.getResponse().getWriter().println(gson.toJson(user));
    		user = null;
    	}
    	if(page!=null){
    		return page;
    	}
    	return null;
    }
}
