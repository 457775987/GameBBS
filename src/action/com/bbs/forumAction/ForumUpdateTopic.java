package com.bbs.forumAction;

import java.util.Date;
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

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：修改发帖 <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午10:25:51 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */


@Controller
public class ForumUpdateTopic extends ActionSupport {
	@Resource(name="board") private Board board = null;
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="user") private User user = null;
	@Resource ITopicManagerService services = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource IReplyTopicManagerService replyservice = null;
	
	private int userid;
	private int boardid;
	private int topicid;
	private Date createTime;
	private String title;
	private String content;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public int getTopicid() {
		return topicid;
	}
	public void setTopicid(int topicid) {
		this.topicid = topicid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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
		
		user.setUserId(userid);
		board.setBoardId(boardid);	
		topic.setTopicBFK(board);
		topic.setTopicContent(content);
		topic.setTopicCreateTime(createTime);
		topic.setTopicName(title);
		topic.setTopicUFK(user);
		topic.setTopicUpdateTime(new Date());
		topic.setTopicId(topicid);
		if(services.updateTopic(topic))
		{
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
		
	}
}
