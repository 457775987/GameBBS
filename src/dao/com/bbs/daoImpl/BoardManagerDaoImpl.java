package com.bbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.Board;
import com.bbs.bean.User;
import com.bbs.dao.IBoardManagerDao;
import com.bbs.file.PropertiesFileRead;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：BoardManagerDaoImpl <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午04:05:02 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Repository("boardDao")
public class BoardManagerDaoImpl implements IBoardManagerDao {
    @Resource(name="proFileRead") PropertiesFileRead pro = null;
	public boolean addBoard(Board board, Session session) throws Exception {
		int index = (Integer)session.save(board);
		System.out.println(index+"   "+board.getBoardGEFK().getName()+"  "+board.getBoardAdminUFK().getUserName());
		return index>0?true:false;
	}

	public boolean deleteBoard(Board board, Session session) throws Exception {
		session.delete(board);
		return true;
	}

	public List<Board> getAllBoard(Board board,Session session)
	throws Exception {
		Query query = session.createQuery("from Board b where b.boardGEFK.id="+board.getBoardGEFK().getId());
		return query.list();
}

	public Board getBoardByID(int boardid, Session session) throws Exception {
		return (Board)session.get(Board.class,boardid);
	}

	public boolean updateBoard(Board board, Session session) throws Exception {
		session.update(board);
		return true;
	}

	public List<Board> getBoardByBoardGEFK(int param,int pageSize, Session session)
			throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		return session.createCriteria(Board.class).add(Restrictions.eq("boardGEFK.id", param))
		.setFirstResult(size*pageSize)
		.setMaxResults(size).list();
	}
	public int getBoardByBoardGEFKCount(int param,Session session){
		return (Integer)session.createCriteria(Board.class)
		.add(Restrictions.eq("boardGEFK.id", param))
		.setProjection(Projections.rowCount())
		.uniqueResult();
	}

	public User getboardAdmin(Board board,Session session) throws Exception {
		Query query = session.createQuery("select u from Board b,User u where u.userId=b.boardAdminUFK.userId and b.boardId="+board.getBoardId());
		return (User)query.uniqueResult();
	}
}
