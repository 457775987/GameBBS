package com.bbs.bean;

import java.util.Date;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("topic") @Scope("prototype")
public class Topic {
       private int topicId;
       private String topicName;
       private String topicContent;
       private int topicScanCount;
       private Date topicCreateTime;
       private Date topicUpdateTime;
	   private User topicUFK;
       private Board topicBFK;
       private boolean topicIsTop;
       private int replyNumber;
       private String lastReplyUserName;
       
    public boolean isTopicIsTop() {
		return topicIsTop;
	}
	public void setTopicIsTop(boolean topicIsTop) {
		this.topicIsTop = topicIsTop;
	}
	private Set<ReplyTopic> replyTopics;
       
    public Date getTopicCreateTime() {
   		return topicCreateTime;
   	}
   	public void setTopicCreateTime(Date topicCreateTime) {
   		this.topicCreateTime = topicCreateTime;
   	}
   	public Date getTopicUpdateTime() {
   		return topicUpdateTime;
   	}
   	public void setTopicUpdateTime(Date topicUpdateTime) {
   		this.topicUpdateTime = topicUpdateTime;
   	}
    public User getTopicUFK() {
		return topicUFK;
	}
	public void setTopicUFK(User topicUFK) {
		this.topicUFK = topicUFK;
	}
	public Board getTopicBFK() {
		return topicBFK;
	}
	public void setTopicBFK(Board topicBFK) {
		this.topicBFK = topicBFK;
	}
	public Set<ReplyTopic> getReplyTopics() {
		return replyTopics;
	}
	public void setReplyTopics(Set<ReplyTopic> replyTopics) {
		this.replyTopics = replyTopics;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	public String getTopicContent() {
		return topicContent;
	}
	public void setTopicContent(String topicContent) {
		this.topicContent = topicContent;
	}
	public int getTopicScanCount() {
		return topicScanCount;
	}
	public void setTopicScanCount(int topicScanCount) {
		this.topicScanCount = topicScanCount;
	}
	public int getReplyNumber() {
		return replyNumber;
	}
	public void setReplyNumber(int replyNumber) {
		this.replyNumber = replyNumber;
	}
	public String getLastReplyUserName() {
		return lastReplyUserName;
	}
	public void setLastReplyUserName(String lastReplyUserName) {
		this.lastReplyUserName = lastReplyUserName;
	}
	
}
