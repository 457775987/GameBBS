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
* �����ƣ�ForumPublishReplyTopic <br>  
* ��������  ���� <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-12 ����09:49:58 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */
@Controller
public class ForumPublishReplyTopic extends ActionSupport {
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource IReplyTopicManagerService replyservice = null;
	@Resource(name="user") private User user = null;
	
	private int userid;
	private int topicid;
	private String content;
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
		replyTopic.setReplyTTFK(topic);
		replyTopic.setReplyTUFK(user);
		replyTopic.setReplyTContent(content);
		replyTopic.setReplyTCreateTime(new Date());
		if(replyservice.addReplyTopic(replyTopic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
}
