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
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�IBoardManagerService <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����04:05:33 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
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
