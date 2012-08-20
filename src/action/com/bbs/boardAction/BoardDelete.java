package com.bbs.boardAction;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.exception.ServiceException;
import com.bbs.service.IBoardManagerService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class BoardDelete extends ActionSupport {
       @Resource private IBoardManagerService boardService = null;
       private int boardId;
       @Override
    public String execute() throws Exception {
    	try{
        	ServletActionContext.getResponse().setCharacterEncoding("utf-8");
    		boardService.deleteBoard(boardId);
    		ServletActionContext.getResponse().getWriter().println("É¾³ý³É¹¦£¡");
    	}catch(ServiceException ex){
			ServletActionContext.getResponse().getWriter().println(ex.toString());
    	}
    	return null;
    }
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
}
