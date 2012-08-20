package com.bbs.gameElementAction;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.bean.GameElement;
import com.bbs.service.IGEManagerService;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
@Controller @Scope("prototype")
public class GameElementSimpleQuery extends ActionSupport {
       @Resource IGEManagerService gEService = null;
       @Resource private Gson gson = null;
       private GameElement game = null;
       private int gameId;
	   private String page;
	   
    public String getPage() {
		return page;
	}
	
	public GameElement getGame() {
		return game;
	}

	public void setGame(GameElement game) {
		this.game = game;
	}

	public void setPage(String page) {
		if(this.page==null){
		this.page = page;
		}
	}
	
	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	@Override
    public String execute() throws Exception {
		ServletActionContext.getResponse().setCharacterEncoding("utf-8");
    	game = gEService.getGEById(gameId);
    	if(page!=null){
    		return page;
    	}
    	if(game!=null){
    		ServletActionContext.getResponse().getWriter().println(gson.toJson(game));
    		game = null;
    	}
    	return null;
    }
}
