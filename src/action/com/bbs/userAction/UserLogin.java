package com.bbs.userAction;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.User;
import com.bbs.service.IUserManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class UserLogin extends ActionSupport {
	   @Resource IUserManagerService service = null;
       private String userName;
       private String password;
       private boolean isSave;
       private String type;
   	@Resource(name="dateFormat") private SimpleDateFormat dateFormat = null;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean getIsSave() {
		return isSave;
	}
	public void setIsSave(boolean isSave) {
		this.isSave = isSave;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    public String checkUser() throws Exception{
    	User currentUser = service.getUserByName(userName);
    	currentUser.setUserLastTime(dateFormat.parse(dateFormat.format(new Date())));
    	System.out.println("更新时间");
	    service.updateUserById(currentUser);
	    System.out.println("更新结束");
    	if(currentUser==null){
    		ServletActionContext.getResponse().getWriter().println("{\"flag\":\"no\"}");
    	}else{
    		ServletActionContext.getResponse().getWriter().println("{\"flag\":\"yes\"}");
    	}
    	   return null;
    }
	@Override
	public void validate() {
	    ServletActionContext.getResponse().setCharacterEncoding("utf-8");
	}
    @Override
    public String execute() throws Exception {
    	User currentUser = service.getUserByName(userName);
    	if(currentUser==null){
    		this.isSave=false;
    		ServletActionContext.getResponse().getWriter().println("帐号不存在！请重新登录");
    		return null;
    	}
    	if(!currentUser.getUserPassword().equals(password)){
    		this.isSave=false;
    		ServletActionContext.getResponse().getWriter().println("密码错误！请重新登录");
    		return null;
    	}
    	currentUser.setUserLastTime(dateFormat.parse(dateFormat.format(new Date())));
    	service.updateUserById(currentUser);
    	if(isSave){
    		System.out.println("用户登录");
    		Cookie coo1 = new Cookie("userName",userName);
    		Cookie coo2 = new Cookie("password",password);
    		Cookie coo3 = new Cookie("code",currentUser.getUserId()+"");
    		coo1.setMaxAge(604800);
    		coo2.setMaxAge(604800);
    		coo3.setMaxAge(604800);
    		ServletActionContext.getResponse().addCookie(coo1);
    		ServletActionContext.getResponse().addCookie(coo2);
    		ServletActionContext.getResponse().addCookie(coo3);
    	}
    	ServletActionContext.getRequest().getSession().setAttribute("currentUser", currentUser);
    	List<User> userGroup=(List)ServletActionContext.getServletContext().getAttribute("userGroup");
    	if(userGroup==null){
        	userGroup=new ArrayList<User>();
        	ServletActionContext.getServletContext().setAttribute("userGroup", userGroup);
        }
    	User temp=null;
    	for(User userInfo:userGroup){
        	if(userInfo.getUserId()==currentUser.getUserId()){
        		temp=userInfo;
        		break;
        }
    	}
        if(temp!=null){
    		userGroup.remove(temp);
    	}
        userGroup.add(currentUser);
    	
    	if(type.equals("checkCookie")){
    		
    	}else{
    	ServletActionContext.getResponse().getWriter().println("登录成功！");
    	}
    	return null;
    }
}
