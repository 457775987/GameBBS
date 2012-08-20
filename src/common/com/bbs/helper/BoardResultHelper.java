package com.bbs.helper;

import java.util.Date;

public class BoardResultHelper {
       private String boardName;
       private String adminName;
       private Date createTime;
       private String createAdminName;
       private String adminEmail;
       private int boardId;
       private String updateAdminName;
    
	public String getUpdateAdminName() {
		return updateAdminName;
	}
	public void setUpdateAdminName(String updateAdminName) {
		this.updateAdminName = updateAdminName;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getCreateAdminName() {
		return createAdminName;
	}
	public void setCreateAdminName(String createAdminName) {
		this.createAdminName = createAdminName;
	}
	public String getAdminEmail() {
		return adminEmail;
	}
	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
       
}
