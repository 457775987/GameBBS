package com.bbs.adminAction;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
@Controller
public class AdminExit extends ActionSupport {
       @Override
    public String execute() throws Exception {
    	ServletActionContext.getRequest().getSession().invalidate();
    	return SUCCESS;
    }
}
