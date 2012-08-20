package com.bbs.forumAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Board;
import com.bbs.bean.GameElement;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.service.IBoardManagerService;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ForumGetAllBoard <br>  
* ��������  ��ȡ���а��id<br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-12 ����09:45:02 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */

@Controller
public class ForumGetAllBoard extends ActionSupport {
	
	@Resource ITopicManagerService services = null;
	@Resource IReplyTopicManagerService replyservice = null;
	@Resource IBoardManagerService boardservice = null;
	@Resource(name="board") private Board board = null;
	@Resource(name="replyTopic") private ReplyTopic replyTopic = null;
	@Resource(name="topic")private Topic topic = null;
	@Resource(name="gameElement") private GameElement gElement = null;
	private int id;
	private List<Board> boardList;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	
	@Override
	public String execute() throws Exception {
		gElement.setId(id);
		board.setBoardGEFK(gElement);
		boardList=boardservice.getAllBoard(board);
		boardList=boardservice.newBoardList(boardList, services, replyservice, replyTopic, topic);
		return SUCCESS;
	}
	
}
