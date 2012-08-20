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
* 类名称：ForumDeleteReplyTopic <br>  
* 类描述：  删除回帖 <br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午10:19:26 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Controller
public class ForumDeleteReplyTopic extends ActionSupport{
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource IReplyTopicManagerService replyservice = null;
	
	private int topicid;
	private int boardid;
	private int replyid;
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
	public int getReplyid() {
		return replyid;
	}
	public void setReplyid(int replyid) {
		this.replyid = replyid;
	}
	
	@Override
	public String execute() throws Exception {
		
		replyTopic.setReplyTId(replyid);
		if(replyservice.deleteReplyTopic(replyTopic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}
