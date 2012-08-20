package com.bbs.adminAction;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Admin;

import com.bbs.service.IAdminManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class AdminLogin extends ActionSupport {
	@Resource(name="adminService") IAdminManagerService adminService = null;
	private String adminAccount;
	private String password;
	private boolean save = false;
	@Resource(name="dateFormat") private SimpleDateFormat dateFormat = null;
	@Override
    public String execute() throws Exception {
		Admin admin = adminService.getAdminByAccount(adminAccount);
		if(admin==null){
			this.addActionError("用户名不存在！");
			return LOGIN;
		}
		if(!admin.getAdminPassword().equals(password)){
			this.addActionError("密码不匹配！");
			return LOGIN;
		}
		admin.setAdminLastTime(dateFormat.parse(dateFormat.format(new Date())));
		adminService.updateAdmin(admin);
		if(save){
		Cookie coo1 = new Cookie("adminName",adminAccount);
		Cookie coo2 = new Cookie("adminPassword",password);
		coo1.setMaxAge(604800);
		coo2.setMaxAge(604800);
		ServletActionContext.getResponse().addCookie(coo1);
		ServletActionContext.getResponse().addCookie(coo2);
		}else{
			Cookie coo1 = new Cookie("adminName","");
			Cookie coo2 = new Cookie("adminPassword","");
			coo1.setMaxAge(0);
			coo2.setMaxAge(0);
			ServletActionContext.getResponse().addCookie(coo1);
			ServletActionContext.getResponse().addCookie(coo2);
		}
		ServletActionContext.getRequest().getSession().setAttribute("currentAdmin", admin);
		return "index";
    }
	
	
	public String getAdminAccount() {
		return adminAccount;
	}


	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isSave() {
		return save;
	}

	public void setSave(boolean save) {
		this.save = save;
	}
	
}
