package com.bbs.userAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.exception.ServiceException;
import com.bbs.service.IUserManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserDelete extends ActionSupport {
       private int userId;
       @Resource IUserManagerService userService = null;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String execute() throws Exception {
		try{
		userService.deleteUser(userId);
		}catch(ServiceException ex){
			
		}
		return null;
	}
}
