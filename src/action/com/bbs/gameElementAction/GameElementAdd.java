package com.bbs.gameElementAction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Admin;
import com.bbs.bean.GameElement;
import com.bbs.exception.ServiceException;
import com.bbs.file.FileUploadType;
import com.bbs.service.IGEManagerService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
@Controller @Scope("prototype")
public class GameElementAdd extends ActionSupport implements ModelDriven<GameElement>{
	private String first_events;
	private String last_events;
	private String first_media;
	private String last_media;
	private String first_strategy;
	private String last_strategy;
	private String page;
	@Resource GameElement game;
	@Resource IGEManagerService gEService = null;
	private File back;
	private String backFileName;
	private String backContentType;
	private int gameId;
	private String oldBackStyle;
	
	public String getOldBackStyle() {
		return oldBackStyle;
	}
	public void setOldBackStyle(String oldBackStyle) {
		this.oldBackStyle = oldBackStyle;
	}

	public File getBack() {
		return back;
	}
	public void setBack(File back) {
		this.back = back;
	}
	public String getBackFileName() {
		return backFileName;
	}
	public void setBackFileName(String backFileName) {
		this.backFileName = backFileName;
	}
	
	public String getBackContentType() {
		return backContentType;
	}
	public void setBackContentType(String backContentType) {
		this.backContentType = backContentType;
	}
	@Override
	public void validate() {
		 if(backFileName!=null){
				if(FileUploadType.IMAGE_Type.split(backContentType).length!=2){
	        		this.addActionError("文件上传传类型错误！允许类型："+FileUploadType.IMAGE_Type);
	        	}
	        	String headName = game.getName()+backFileName.
	        	substring(backFileName.lastIndexOf("."),backFileName.length());
				fileUpload(headName);
				game.setBackStyle(headName);
			}
		if(this.getActionErrors().size()==0){
			try{
			Admin admin = (Admin)ServletActionContext.getRequest().getSession().getAttribute("currentAdmin");
			game.setAdminFK(admin);
			game.setId(gameId);
			}catch(Exception ex){
				this.addActionError("管理员没有登录");
			}
		}
	}
	@Override
	public String execute() throws Exception {
		try{
			if(backFileName==null){
				game.setBackStyle(oldBackStyle);
				}
			if(gEService.addGamaElement(game)==false){
				this.addActionError("新增失败！");
			}
		}catch(ServiceException ex){
			this.addActionError("错误信息："+ex.getErrorMsg());
			page = "add_GE";
			return INPUT;
		}
		return "GE_manage";
	}
	
	public String update() throws Exception{
		try{
		gEService.updateGE(game);
		}catch(ServiceException ex){
			this.addActionError("错误信息："+ex.getErrorMsg());
			page="update_GE";
			return INPUT;
		}
		return "GE_manage";
	}
    
	public void fileUpload(String headName){
		FileInputStream input = null;
    	FileOutputStream output = null;
    	try{
    	String headPath = ServletActionContext.getServletContext().getRealPath("/background");
    	input = new FileInputStream(back);
    	output = new FileOutputStream(new File(headPath+"\\"+headName));
    	byte[] by = new byte[1024];
    	int index = -1 ;
    	while((index=input.read(by))!=-1){
    		output.write(by, 0, index);
    	}
    	}catch(Exception ex){
    		ex.printStackTrace();
    		this.addActionError("头像上传失败！");
    	}finally{
    		try{
    		input.close();
    		output.close();
    		}catch(Exception ex){ex.printStackTrace();}
    	}
	}
	
	public int getGameId() {
		return gameId;
	}
	public void setGameId(int gameId) {
		this.gameId = gameId;
	}
	public String getFirst_events() {
		return first_events;
	}
	public void setFirst_events(String firstEvents) {
		first_events = firstEvents;
	}
	public String getLast_events() {
		return last_events;
	}

	public void setLast_events(String lastEvents) {
		last_events = lastEvents;
	}

	public String getFirst_media() {
		return first_media;
	}

	public void setFirst_media(String firstMedia) {
		first_media = firstMedia;
	}

	public String getLast_media() {
		return last_media;
	}

	public void setLast_media(String lastMedia) {
		last_media = lastMedia;
	}

	public String getFirst_strategy() {
		return first_strategy;
	}

	public void setFirst_strategy(String firstStrategy) {
		first_strategy = firstStrategy;
	}

	public String getLast_strategy() {
		return last_strategy;
	}

	public void setLast_strategy(String lastStrategy) {
		last_strategy = lastStrategy;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}
	public GameElement getModel() {
		return game;
	}
	
}
