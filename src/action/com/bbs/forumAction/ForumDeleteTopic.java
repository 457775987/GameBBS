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
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ForumDeleteTopic <br>  
* �������� ɾ������<br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-12 ����10:19:45 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
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
