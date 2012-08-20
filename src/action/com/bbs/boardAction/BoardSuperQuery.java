package com.bbs.boardAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IBoardManagerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class BoardSuperQuery extends ActionSupport {
       private int param;
       private int pageSize;
   	   @Resource IBoardManagerService boardService = null;
   	   private Gson gson = null;
   	   @Resource(name="gsonBuilder") private GsonBuilder gsonBuilder = null;
   	@Override
   	public String execute() throws Exception {
   		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
   		gson = gsonBuilder.setDateFormat("yyyy-MM-dd").create();
   		try{
   			ResultHelper boards = boardService.getBoardByBoardGEFK(param, pageSize);
   			ServletActionContext.getResponse().getWriter().println(gson.toJson(boards));
   			gson=null;
   		}catch(ServiceException ex){
   			this.addActionError("¥ÌŒÛ–≈œ¢£∫"+ex.getErrorMsg());
   		}
   		return null;
   	}
   	
   	
    public int getParam() {
		return param;
	}
	public void setParam(int param) {
		this.param = param;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
