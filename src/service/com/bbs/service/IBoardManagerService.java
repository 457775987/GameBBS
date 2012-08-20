package com.bbs.service;

import java.util.List;

import com.bbs.bean.Board;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：IBoardManagerService <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午04:05:33 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */
public interface IBoardManagerService {
	public boolean addBoard(int boardGEFK,String adminAccount,Board board)throws ServiceException;
	public boolean updateBoard(Board board,String adminAccount)throws ServiceException;
	public boolean deleteBoard(int boardId)throws ServiceException;
	public Board getBoardByID(int boardid)throws ServiceException;
	public List<Board> getAllBoard(Board board)throws ServiceException; 
	public ResultHelper getBoardByBoardGEFK(int param,int pageSize) throws ServiceException;
	
	public User getboardAdmin(Board board)throws ServiceException;
	
	public List<Board> newBoardList(List<Board> list,ITopicManagerService services,IReplyTopicManagerService replyservice,ReplyTopic replyTopic,Topic topic)throws ServiceException;
	
	
}
