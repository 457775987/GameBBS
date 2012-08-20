package com.bbs.forumAction;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.service.IReplyTopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ForumUpdateReplyTopic <br>  
* �������� �޸Ļ��� <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-12 ����10:20:38 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */

@Controller
public class ForumUpdateReplyTopic extends ActionSupport{
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="user") private User user = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource IReplyTopicManagerService replyservice = null;
	
	private int userid;
	private int topicid;
	private int replyid;
	private int boardid;
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
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	@Override
	public String execute() throws Exception {
		
		user.setUserId(userid);
		topic.setTopicId(topicid);
		replyTopic.setReplyTContent(content);
		replyTopic.setReplyTCreateTime(new Date());
		replyTopic.setReplyTId(replyid);
		replyTopic.setReplyTTFK(topic);
		replyTopic.setReplyTUFK(user);
		
		if(replyservice.updateReplyTopic(replyTopic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
}
