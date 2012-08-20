package com.bbs.forumAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.file.PropertiesFileRead;
import com.bbs.service.IBoardManagerService;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;


/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ForumSearchTopic <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-20 ����10:50:53 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */

@Controller
public class ForumSearchTopic extends ActionSupport {
	@Resource(name="board") private Board board = null;
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource ITopicManagerService services = null;
	@Resource IReplyTopicManagerService replyservice = null;
	@Resource IBoardManagerService boardservice = null;
	
	private int boardid;
	private List<Topic> topicList;
	private User user;
	private String searchName;
	
	
	public User getUser() {
		return user;
	}
	public int getBoardid() {
		return boardid;
	}
	public void setBoardid(int boardid) {
		this.boardid = boardid;
	}
	public List<Topic> getTopicList() {
		return topicList;
	}

	public Board getBoard() {
		return board;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	@Override
	public String execute() throws Exception {
		
		board.setBoardId(boardid);
		topic.setTopicBFK(board);
		topic.setTopicName(searchName);
		user =boardservice.getboardAdmin(board);
		topicList=services.getSearchAllTopic(topic);
		topicList=services.newAddTopic(topicList, services, replyservice, replyTopic);
		board=boardservice.getBoardByID(boardid);
		return SUCCESS;
	}
}
