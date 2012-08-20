package com.bbs.forumAction;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.file.PropertiesFileRead;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IBoardManagerService;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：ForumGetAllTopic <br>  
* 类描述：  获取版块下的所有帖子 <br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午09:42:18 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Controller
public class ForumGetAllTopic extends ActionSupport {
	@Resource(name="board") private Board board = null;
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="proFileRead") PropertiesFileRead pro = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource ITopicManagerService services = null;
	@Resource IReplyTopicManagerService replyservice = null;
	@Resource IBoardManagerService boardservice = null;
	
	private int boardid;
	private List<Topic> topicList;
	private User user;
	private int number;
	private int page;
	private int maxPage;
	private int prePage;
	private int nextPage;

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public void setPage(int page) {
		this.page = page;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
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
	
	
	public int getPage() {
		return page;
	}

	@Override
	public String execute() throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		if(page<=0)
		{
			page =1;
		}
	
		board.setBoardId(boardid);
		topic.setTopicBFK(board);
		user =boardservice.getboardAdmin(board);
		number = services.getTopicCount(topic);
		ResultHelper resultHelper=services.getAllTopic(topic,page);
		maxPage = resultHelper.getMaxPage();
		maxPage= (maxPage%size)==0?maxPage/size:(maxPage/size)+1;
		
		if(maxPage==0)
		{
			maxPage=1;
		}
		
		prePage = 1;
		nextPage = 1;

		if (page <= 1) {
			prePage = 1;
		} else {
			prePage = page - 1;
		}

		if (prePage < 0)
			prePage = 1;

		if (page >= maxPage) {
			nextPage = maxPage;
		} else {
			nextPage = page + 1;
		}

		
		topicList = resultHelper.getList();
		topicList=services.newAddTopic(topicList, services, replyservice, replyTopic);
		board=boardservice.getBoardByID(boardid);
		return SUCCESS;
	}
}
