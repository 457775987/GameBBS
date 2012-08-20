package com.bbs.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("admin") @Scope("prototype")
public class Admin implements Serializable{
	public Admin(){
		
	}
       private int adminId;
       private String adminName;
       private String adminAccount;
       private String adminPassword;
       private Date adminLastTime;
       private int version;
    public Admin(int adminId,String adminAccount,String adminName,String adminPassword,Date adminLastTime,int version){
    	this.adminId = adminId;
    	this.adminAccount=adminAccount;
    	this.adminName = adminName;
    	this.adminPassword = adminPassword;
    	this.adminLastTime = adminLastTime;
    	this.version = version;
    }
    
	public String getAdminAccount() {
		return adminAccount;
	}

	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}

	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
    public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	/**
     * 管理员最后登录时间
     */
	public Date getAdminLastTime() {
		return adminLastTime;
	}
	public void setAdminLastTime(Date adminLastTime) {
		this.adminLastTime = adminLastTime;
	}
}
