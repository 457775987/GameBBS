package com.bbs.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.Board;
import com.bbs.bean.GameElement;
import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.dao.IBoardManagerDao;
import com.bbs.dao.IGEManagerDao;
import com.bbs.dao.IUserManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.helper.BoardResultHelper;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IBoardManagerService;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�BoardManagerServiceImpl <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����04:10:18 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */
@Service("boardService") @Scope("prototype") @Transactional
public class BoardManagerServiceImpl implements IBoardManagerService {
	 @Resource ResultHelper helper = null;
	 @Resource(name="boardDao") IBoardManagerDao dao = null;
	 @Resource IUserManagerDao userDao= null;
	 @Resource IGEManagerDao gEDao = null;
	 @Resource List<BoardResultHelper> list = null;
	 @Resource SessionFactory sessionFactory = null;
	/**
	 * 
	 * <p>Title: addBoard</p> 
	 * <p>Description:���Ӱ�� </p> 
	 * @param board
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IBoardManagerService#addBoard(com.bbs.bean.Board) 
	 * ����:Cake
	 */
	public boolean addBoard(Board board) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.addBoard(board,session);
		}catch(Exception ex){
			throw new ServiceException("�������ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: deleteBoard</p> 
	 * <p>Description:ɾ�����</p> 
	 * @param board
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IBoardManagerService#deleteBoard(com.bbs.bean.Board) 
	 * ����:Cake
	 */
	public boolean deleteBoard(int boardId) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			Board board = dao.getBoardByID(boardId, session);
			flag = dao.deleteBoard(board,session);
		}catch(Exception ex){
			throw new ServiceException("ɾ�����ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: getAllBoard</p> 
	 * <p>Description: ��ȡ���а��</p> 
	 * @param board
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IBoardManagerService#getAllBoard(com.bbs.bean.Board) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Board> getAllBoard(Board board) throws ServiceException {
		List<Board> boardList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			boardList = dao.getAllBoard(board,session);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("��ȡ���а��ʧ��!");
		}
		return boardList;
	}
	
	/**
	 * 
	 * <p>Title: getBoardByID</p> 
	 * <p>Description:����id��ȡ��� </p> 
	 * @param board
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IBoardManagerService#getBoardByID(com.bbs.bean.Board) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Board getBoardByID(int boardid) throws ServiceException {
		Board board= null;
		try{
			Session session = sessionFactory.getCurrentSession();
			board = dao.getBoardByID(boardid,session);
		}catch(Exception ex){
			throw new ServiceException("���Ұ��ʧ��!");
		}
		return board;
	}

	/**
	 * 
	 * <p>Title: updateBoard</p> 
	 * <p>Description: �޸İ��</p> 
	 * @param board
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IBoardManagerService#updateBoard(com.bbs.bean.Board) 
	 * ����:Cake
	 */
	public boolean updateBoard(Board board,String adminAccount) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			Board boardTemp = dao.getBoardByID(board.getBoardId(), session);
			User user = userDao.getUserByName(adminAccount, session);
			boardTemp.setBoardName(board.getBoardName());
			boardTemp.setBoardAdminUFK(user);
			boardTemp.setBoardUpdateAFK(board.getBoardUpdateAFK());
			flag = dao.updateBoard(boardTemp,session);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("�޸İ��ʧ��!");
		}
		return flag;
	}

	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getBoardByBoardGEFK(int param, int pageSize)
			throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					List<Board> boards = dao.getBoardByBoardGEFK(param, pageSize,session);
					int size = dao.getBoardByBoardGEFKCount(param,session);
					for(int i=0;i<boards.size();i++){
						BoardResultHelper board = new BoardResultHelper();
						board.setAdminEmail(boards.get(i).getBoardAdminUFK().getUserEmail());
						board.setAdminName(boards.get(i).getBoardAdminUFK().getUserName());
						board.setBoardId(boards.get(i).getBoardId());
						board.setBoardName(boards.get(i).getBoardName());
						board.setCreateAdminName(boards.get(i).getBoardCreateAFK().getAdminName());
						board.setUpdateAdminName(boards.get(i).getBoardUpdateAFK().getAdminName());
						board.setCreateTime(boards.get(i).getBoardCreateTime());
						list.add(board);
					}
					boards=null;
					helper.setList(list);
					helper.setMaxPage(size);
					return helper;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("�����������а��ʧ�ܣ�");
				}
	}

	public boolean addBoard(int boardGEFK, String adminAccount, Board board)
			throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					User admin = userDao.getUserByName(adminAccount, session);
					GameElement game = gEDao.getGEById(boardGEFK, session);
					if(admin==null){
						throw new ServiceException("�û������ڣ�");
					}
					board.setBoardAdminUFK(admin);
					board.setBoardGEFK(game);
					boolean boo = dao.addBoard(board, session);
					return boo;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("�������ʧ�ܣ�"+ex.toString());
				}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public User getboardAdmin(Board board) throws ServiceException {
		User user = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			user = dao.getboardAdmin(board, session);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return user;
	}

	public List<Board> newBoardList(List<Board> list,
			ITopicManagerService services,
			IReplyTopicManagerService replyservice, ReplyTopic replyTopic,Topic topic)
			throws ServiceException {
		
		List<Board> newlist = new ArrayList<Board>();
		Iterator it =list.iterator();
		long time = 0;
		while(it.hasNext())
		{
			int allnumTopic=0;
			int subjectCount=0;
			Board board = (Board) it.next();
			topic.setTopicBFK(board);
			int subjectNum = services.getTopicCount(topic);
			List list1 = services.getAllTopic(topic);
			subjectCount+=list1.size();
			Iterator it2 = list1.iterator();
			while(it2.hasNext())
			{
				Object[] obj = (Object[]) it2.next();
				Topic topic1 =(Topic)obj[0];
				User user = (User)obj[1];
						
				if(time==0)
				{
					time=topic1.getTopicUpdateTime().getTime();
					board.setLastTopic(topic1.getTopicUpdateTime());
				}
				else
				{
					if(time<topic1.getTopicUpdateTime().getTime())
					{
						board.setLastTopic(topic1.getTopicUpdateTime());
					}
				}
				
				topic1.setTopicUFK(user);
				replyTopic.setReplyTTFK(topic1);
				List<ReplyTopic> replyList =replyservice.getAllReplyTopic(replyTopic);
				Iterator<ReplyTopic> it3 = replyList.iterator();
				while(it3.hasNext())
				{
					ReplyTopic rt = (ReplyTopic)it3.next();
					if(time<rt.getReplyTCreateTime().getTime())
					{
						board.setLastTopic(rt.getReplyTCreateTime());
					}
				}
				allnumTopic+=replyList.size();
			}
			board.setSubjectCount(subjectCount);
			board.setAllTopicCount(allnumTopic+subjectCount);
			newlist.add(board);
		}
		return newlist;
	}
}
