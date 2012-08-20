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
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�BoardManagerDaoImpl <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����04:05:02 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
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
