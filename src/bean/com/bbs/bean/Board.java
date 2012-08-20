package com.bbs.bean;

import java.util.Date;
import java.util.Set;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
@Component("board") @Scope("prototype")
public class Board {
       private int boardId;
       private String boardName;
       private Date boardCreateTime;
       private GameElement boardGEFK;
       private Admin boardCreateAFK;
       private Admin boardUpdateAFK;
       private User boardAdminUFK;
   	   private Set<Topic> topics;
   	   private int subjectCount;
   	   private int allTopicCount;
   	   private Date lastTopic;
   	   
   	   
    public Date getLastTopic() {
		return lastTopic;
	}
	public void setLastTopic(Date lastTopic) {
		this.lastTopic = lastTopic;
	}
	public int getSubjectCount() {
		return subjectCount;
	}
	public void setSubjectCount(int subjectCount) {
		this.subjectCount = subjectCount;
	}
	public int getAllTopicCount() {
		return allTopicCount;
	}
	public void setAllTopicCount(int allTopicCount) {
		this.allTopicCount = allTopicCount;
	}
	public User getBoardAdminUFK() {
		return boardAdminUFK;
	}
	public void setBoardAdminUFK(User boardAdminUFK) {
		this.boardAdminUFK = boardAdminUFK;
	}
	public int getBoardId() {
		return boardId;
	}
	public Set<Topic> getTopics() {
		return topics;
	}
	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
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
	public Date getBoardCreateTime() {
		return boardCreateTime;
	}
	public void setBoardCreateTime(Date boardCreateTime) {
		this.boardCreateTime = boardCreateTime;
	}
	public GameElement getBoardGEFK() {
		return boardGEFK;
	}
	public void setBoardGEFK(GameElement boardGEFK) {
		this.boardGEFK = boardGEFK;
	}
	public Admin getBoardCreateAFK() {
		return boardCreateAFK;
	}
	public void setBoardCreateAFK(Admin boardCreateAFK) {
		this.boardCreateAFK = boardCreateAFK;
	}
	public Admin getBoardUpdateAFK() {
		return boardUpdateAFK;
	}
	public void setBoardUpdateAFK(Admin boardUpdateAFK) {
		this.boardUpdateAFK = boardUpdateAFK;
	}
}
