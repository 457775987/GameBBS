package com.bbs.forumAction;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ForumPublishTopic <br>  
* �������� ����<br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-12 ����09:48:48 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */


@Controller
public class ForumPublishTopic extends ActionSupport{
	@Resource(name="board") private Board board = null;
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="user") private User user = null;
	@Resource ITopicManagerService services = null;
	
	private int boardid;
	private int userid;
	private String title;
	private String content;
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	@Override
	public String execute() throws Exception {
		
		board.setBoardId(boardid);
		user.setUserId(userid);
		topic.setTopicBFK(board);
		topic.setTopicContent(content);
		topic.setTopicUFK(user);
		topic.setTopicName(title);
		topic.setTopicCreateTime(new Date());
		topic.setTopicUpdateTime(new Date());
		topic.setTopicScanCount(1);
		topic.setTopicIsTop(false);
		
		if(services.addTopic(topic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	
	}
	
	
}
