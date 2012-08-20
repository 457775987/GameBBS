package com.bbs.forumAction;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.service.IBoardManagerService;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：ForumDeleteTopic <br>  
* 类描述： 删除发帖<br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午10:19:45 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Controller
public class ForumDeleteTopic extends ActionSupport{
	@Resource(name="topic") private Topic topic = null;
	@Resource ITopicManagerService services = null;
	
	private int topicid;
	private int boardid;
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	
	@Override
	public String execute() throws Exception {
		
		topic.setTopicId(topicid);
		if(services.deleteTopic(topic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
}
