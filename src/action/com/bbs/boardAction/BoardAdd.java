package com.bbs.boardAction;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Admin;

import com.bbs.bean.Board;
import com.bbs.exception.ServiceException;
import com.bbs.service.IBoardManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class BoardAdd extends ActionSupport {
	@Resource private IBoardManagerService boardService = null;
	private String name = null;
	private int boardGEFK;
	private String adminAccount;
	@Resource private Board board = null;
	private int boardId;
	private String page;
	@Resource(name="dateFormat") private SimpleDateFormat dateFormat = null;
	private Admin admin;
	@Override
	public void validate() {
		try{
			admin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("currentAdmin");
			if(admin==null){
			this.addActionError("请先登录！");
			return;
			}
		board.setBoardUpdateAFK(admin);
		board.setBoardId(boardId);
		board.setBoardName(name);
		}catch(Exception ex){
			ex.printStackTrace();
			this.addActionError("新增版块信息不合法！");
		}
	}
	   @Override
	public String execute() throws Exception {
		   try{
				board.setBoardCreateTime(dateFormat.parse(dateFormat.format(new Date())));
				board.setBoardCreateAFK(admin);
				boolean boo = boardService.addBoard(boardGEFK, adminAccount, board);
				if(boo==false){
					page="addBoard";
					return INPUT;
				}
		   }catch(ServiceException ex){
			   page="addBoard";
			   this.addActionError("错误信息："+ex.getErrorMsg());
			   return INPUT;
		   }
		   return SUCCESS;
	}
	public String update(){
		try{
			boardService.updateBoard(board,adminAccount);
		}catch(ServiceException ex){
			 page="update_Board";
			 this.addActionError("错误信息："+ex.getErrorMsg());
			 return INPUT;
		}
		   return SUCCESS;
	}

	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getAdminAccount() {
		return adminAccount;
	}
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	public IBoardManagerService getBoardService() {
		return boardService;
	}

	public void setBoardService(IBoardManagerService boardService) {
		this.boardService = boardService;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBoardGEFK() {
		return boardGEFK;
	}

	public void setBoardGEFK(int boardGEFK) {
		this.boardGEFK = boardGEFK;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	
	   
}
