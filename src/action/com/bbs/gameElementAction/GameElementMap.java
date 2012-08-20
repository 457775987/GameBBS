package com.bbs.gameElementAction;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.exception.ServiceException;
import com.bbs.service.IGEManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller @Scope("prototype")
public class GameElementMap extends ActionSupport {
	@Resource private IGEManagerService gameService = null;
	private List games = null;
	private String page;

	public List getGames() {
		return games;
	}

	public void setGames(List games) {
		this.games = games;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		if(this.page==null){
		this.page = page;
		}
	}

	@Override
    public String execute() throws Exception {
    	   try{
    		   games = gameService.getAllGEMap();
    	   }catch(ServiceException ex){
    		   ex.printStackTrace();
    	   }
    	   return page;
    }
}
