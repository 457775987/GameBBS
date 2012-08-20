package com.bbs.gameElementAction;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.GameElement;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IGEManagerService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller @Scope("prototype")
public class GameElementSuperQuery extends ActionSupport {
	@Resource private IGEManagerService gEService = null;
	@Resource private Gson gson = null;
	private int pageSize;
	private String by;
	private String param;
	private String type;
	private String errorPage;
	@Override
    public String execute() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
		try{
			if(!by.equals("all")){
				 ResultHelper gEs = gEService.getGEByType(by, param, pageSize);
				 ServletActionContext.getResponse().getWriter().println(gson.toJson(gEs));
				}else{
				 ResultHelper helper = gEService.getAllGE(pageSize);
				 List<Object> list = helper.getList();
				 ServletActionContext.getResponse().getWriter().println(gson.toJson(helper));
				}
		}catch(ServiceException ex){
			ex.printStackTrace();
			this.addActionError("³ö´íÁË£¡"+ex.getErrorMsg());
			if(errorPage!=null){
				return errorPage;
			}
		}
    	   return null;
    }
	
    public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
