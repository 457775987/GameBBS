package com.bbs.gameElementAction;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.exception.ServiceException;
import com.bbs.service.IGEManagerService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller @Scope("prototype")
public class GameElementDelete extends ActionSupport {
	@Resource private IGEManagerService gEService = null;
	private String imagePath;
	private int gameId;
    @Override
    public String execute() throws Exception {
    	ServletActionContext.getResponse().setCharacterEncoding("utf-8");
    	try{
    		gEService.deleteGE(gameId);
    		ServletActionContext.getResponse().getWriter().println("É¾³ý³É¹¦£¡");
    	}catch(ServiceException ex){
    		ex.printStackTrace();
			ServletActionContext.getResponse().getWriter().println(ex.toString());
    	}
    	return null;
    }
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
}
