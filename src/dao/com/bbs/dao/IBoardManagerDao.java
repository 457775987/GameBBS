package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.Board;
import com.bbs.bean.User;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：IBoardManagerDao <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午04:01:55 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
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
