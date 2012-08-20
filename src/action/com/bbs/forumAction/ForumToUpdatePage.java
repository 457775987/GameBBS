package com.bbs.forumAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
public class ForumToUpdatePage extends ActionSupport {
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource(name="user") private User user = null;
	@Resource(name="board") private Board board = null;
	@Resource ITopicManagerService services = null;
	@Resource IReplyTopicManagerService replyservice = null;
	
	private int topicId;
	private int replyTopicId;
	private int userid;
	private int boardId;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public Topic getTopic() {
		return topic;
	}
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	public ReplyTopic getReplyTopic() {
		return replyTopic;
	}
	public void setReplyTopic(ReplyTopic replyTopic) {
		this.replyTopic = replyTopic;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public int getReplyTopicId() {
		return replyTopicId;
	}
	public void setReplyTopicId(int replyTopicId) {
		this.replyTopicId = replyTopicId;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String update()throws Exception
	{
		user.setUserId(userid);
		topic.setTopicId(topicId);
		board.setBoardId(boardId);
		replyTopic = replyservice.getReplyTopicById(replyTopicId);
		return SUCCESS;
	}
	
	@Override
	public String execute() throws Exception {
		user.setUserId(userid);
		board.setBoardId(boardId);
		List list = services.getTopicById(topicId);
		list = services.newAddTopic(list, services, replyservice, replyTopic);
		topic = (Topic)list.get(0);
		
		
		return SUCCESS;
	}
}
