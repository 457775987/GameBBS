package com.bbs.bean;

import java.io.File;
import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("user") @Scope("prototype")
public class User {
       private int userId;
       private String userNickName;
	   private String userName;
       private String userPassword;
       private int userAge;
       private String userSex;
	   private String userHead;
       private String userQQ;
       private String userEmail;
       private Date userRegTime;
       private Date userLastTime;
       private String userAddress;
       private String userHomePage;
       private Role userRoleFK;
   	   private int userTCount;
       private String userLabel;
       private Date userUpdateDate;
       private int version;
    public User(){
    	
    }
    public User setPrototype(User user){
    	Role role = null;
    	if(user.getUserRoleFK()!=null){
    	role = new Role(user.getUserRoleFK().getRoleId(),user.getUserRoleFK().getRoleName(),
				user.getUserRoleFK().getRoleCode(),user.getUserRoleFK().isRoleIsUse());
        }
		this.userRoleFK = role;
		this.userName = user.getUserName();
		this.userNickName = user.getUserNickName();
		this.userAge = user.getUserAge();
		this.userAddress = user.getUserAddress();
		this.userEmail = user.getUserEmail();
		this.userHead = user.getUserHead();
		this.userLastTime = user.getUserLastTime();
		this.userRegTime = user.getUserRegTime();
		this.userHomePage  = user.getUserHomePage();
		this.userId = user.getUserId();
		this.userLabel = user.userLabel;
		this.userPassword = user.getUserPassword();
		this.userQQ = user.getUserQQ();
		this.userSex = user.getUserSex();
		this.userTCount = user.getUserTCount();
		this.version = user.getVersion();
		return this;
    }
    public String getUserNickName() {
		return userNickName;
	}
    
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}

	public String getUserSex() {
   		return userSex;
   	}
   	public void setUserSex(String userSex) {
   		this.userSex = userSex;
   	}
    public Role getUserRoleFK() {
		return userRoleFK;
	}
	public void setUserRoleFK(Role userRoleFK) {
		this.userRoleFK = userRoleFK;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public int getUserAge() {
		return userAge;
	}
	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}
	public String getUserHead() {
		return userHead;
	}
	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}
	public String getUserQQ() {
		return userQQ;
	}
	public void setUserQQ(String userQQ) {
		this.userQQ = userQQ;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public Date getUserRegTime() {
		return userRegTime;
	}
	public void setUserRegTime(Date userRegTime) {
		this.userRegTime = userRegTime;
	}
	public Date getUserLastTime() {
		return userLastTime;
	}
	public void setUserLastTime(Date userLastTime) {
		this.userLastTime = userLastTime;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserHomePage() {
		return userHomePage;
	}
	public void setUserHomePage(String userHomePage) {
		this.userHomePage = userHomePage;
	}
	public int getUserTCount() {
		return userTCount;
	}
	public void setUserTCount(int userTCount) {
		this.userTCount = userTCount;
	}
	public String getUserLabel() {
		return userLabel;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public Date getUserUpdateDate() {
		return userUpdateDate;
	}
	public void setUserUpdateDate(Date userUpdateDate) {
		this.userUpdateDate = userUpdateDate;
	}
	
}
