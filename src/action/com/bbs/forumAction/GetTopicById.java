package com.bbs.forumAction;

import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.file.PropertiesFileRead;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：GetTopicById <br>  
* 类描述：  按id获得帖子信息 <br>
* 创建人：Cake   
* 创建时间：2012-6-12 上午10:38:51 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Controller
public class GetTopicById extends ActionSupport {
	@Resource(name="topic") private Topic topic = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource(name="board") private Board board = null;
	@Resource ITopicManagerService services = null;
	@Resource IReplyTopicManagerService replyservice = null;
	@Resource(name="proFileRead") PropertiesFileRead pro = null;
	
	private int topicId;
	private List<ReplyTopic> replyTopicList;
	private int boardId;
	private int flag;
	private int page;
	private int maxPage;
	private int prePage;
	private int nextPage;
	private List<User> userList;
	
	
	
	public List<User> getUserList() {
		return userList;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	private User user;
	
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

	public void setPage(int page) {
		this.page = page;
	}

	public int getMaxPage() {
		return maxPage;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<ReplyTopic> getReplyTopicList() {
		return replyTopicList;
	}

	public void setReplyTopicList(List<ReplyTopic> replyTopicList) {
		this.replyTopicList = replyTopicList;
	}
	
	
	public int getPage() {
		return page;
	}
	
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String execute() throws Exception {
		
		int size = Integer.parseInt(pro.getValue("pageSize"));
		board.setBoardId(boardId);
		List list = services.getTopicById(topicId);
		list = services.newAddTopic(list, services, replyservice, replyTopic);
		topic = (Topic)list.get(0);
		if(flag==0)
		{
			topic.setTopicScanCount(topic.getTopicScanCount()+1);
			services.updateTopic(topic);
		}
		flag=1;
		if(page<=0)
		{
			page =1;
		}
		replyTopic.setReplyTTFK(topic);
		ResultHelper resultHelper= replyservice.getAllReplyTopic(replyTopic,page);
		replyTopicList = resultHelper.getList();
		maxPage = resultHelper.getMaxPage();
		maxPage= (maxPage%size)==0?maxPage/size : (maxPage/size)+1;
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
		
		user = (User)ServletActionContext.getRequest().getSession().getAttribute("currentUser");
		
		userList = (List<User>) ServletActionContext.getServletContext().getAttribute("userGroup");
		
		return SUCCESS;
	}
	
}
