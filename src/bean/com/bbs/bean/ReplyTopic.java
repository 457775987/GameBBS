package com.bbs.bean;

import java.util.Date;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("replyTopic") @Scope("prototype")
public class ReplyTopic {
       private int replyTId;
       private String replyTContent;
       private Date replyTCreateTime;
       private User replyTUFK;
       private Topic replyTTFK;
	public Topic getReplyTTFK() {
		return replyTTFK;
	}
	public void setReplyTTFK(Topic replyTTFK) {
		this.replyTTFK = replyTTFK;
	}
	public int getReplyTId() {
		return replyTId;
	}
	public void setReplyTId(int replyTId) {
		this.replyTId = replyTId;
	}
	public String getReplyTContent() {
		return replyTContent;
	}
	public void setReplyTContent(String replyTContent) {
		this.replyTContent = replyTContent;
	}
	public Date getReplyTCreateTime() {
		return replyTCreateTime;
	}
	public void setReplyTCreateTime(Date replyTCreateTime) {
		this.replyTCreateTime = replyTCreateTime;
	}
	public User getReplyTUFK() {
		return replyTUFK;
	}
	public void setReplyTUFK(User replyTUFK) {
		this.replyTUFK = replyTUFK;
	}
       
}
