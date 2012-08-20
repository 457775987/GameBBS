package com.bbs.bean;

import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("role") @Scope("prototype")
public class Role {
       private int roleId;
       private String roleName;
       private String roleCode;
       private boolean roleIsUse;
       private Set<User> users;
    public Role(){
    	
    }
    public Role(int roleId,String roleName,String roleCode,boolean roleIsUse){
    	this.roleId = roleId;
    	this.roleName = roleName;
    	this.roleCode = roleCode;
    	this.roleIsUse = roleIsUse;
    }
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public boolean isRoleIsUse() {
		return roleIsUse;
	}
	public void setRoleIsUse(boolean roleIsUse) {
		this.roleIsUse = roleIsUse;
	}
}
