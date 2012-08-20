package com.bbs.userAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.User;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IUserManagerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserSuperQuery extends ActionSupport{
	@Resource IUserManagerService userService = null;
	@Resource(name="gsonBuilder") private GsonBuilder gsonBuilder = null;
	private Gson gson = null;
	private String by;
	private String param;
	private int pageSize;
	private String type;
	
    public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	@Override
	public void validate() {
	}
	@Override
    public String execute() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
		gson = gsonBuilder.setDateFormat("yyyy-MM-dd HH:mm").create();
		try{
		if(!by.equals("all")){
		 ResultHelper helper = userService.getUserByType(by, param, pageSize);
		 ServletActionContext.getResponse().getWriter().println(gson.toJson(helper));
		}else{
		 ResultHelper helper = userService.getAllUser(pageSize);
		 ServletActionContext.getResponse().getWriter().println(gson.toJson(helper));
		}
		}catch(ServiceException ex){
			String msg = "{\"errorMessage\":\""+ex.toString()+"\"}";
			ServletActionContext.getResponse().getWriter().println(gson.toJson(msg));
		}
    	return null;
    }
}
