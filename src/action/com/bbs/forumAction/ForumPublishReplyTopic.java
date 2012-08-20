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
* 项目名称：GameBBS<br>
* 类名称：ForumPublishReplyTopic <br>  
* 类描述：  回帖 <br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午09:49:58 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
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
