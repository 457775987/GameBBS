package com.bbs.boardAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;

import com.bbs.exception.ServiceException;
import com.bbs.service.IBoardManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class BoardSimpleQuery extends ActionSupport {
	@Resource IBoardManagerService boardService = null;
	private String page;
	private int boardId;
	private Board board = null;
	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		if(this.page==null){
		this.page = page;
		}
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	@Override
	public String execute() throws Exception {
		try{
			board = boardService.getBoardByID(boardId);
		}catch(ServiceException ex){
			this.addActionError("¥ÌŒÛ–≈œ¢£∫"+ex.getErrorMsg());
			return INPUT;
		}
		return page;
	}
}
