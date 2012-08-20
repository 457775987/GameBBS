package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.Board;
import com.bbs.bean.User;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�IBoardManagerDao <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����04:01:55 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */
public interface IBoardManagerDao {
	public boolean addBoard(Board board,Session session)throws Exception;
	public boolean updateBoard(Board board,Session session)throws Exception;
	public boolean deleteBoard(Board board,Session session)throws Exception;
	public Board getBoardByID(int boardid,Session session)throws Exception;
	public List<Board> getAllBoard(Board board,Session session)throws Exception; 
	public List<Board> getBoardByBoardGEFK(int param,int pageSize,Session session) throws Exception;
	public int getBoardByBoardGEFKCount(int param,Session session) throws Exception;
	public User getboardAdmin(Board board,Session session)throws Exception;
}
