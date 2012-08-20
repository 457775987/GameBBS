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

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.bean.User;
import com.bbs.dao.IReplyTopicManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IReplyTopicManagerService;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ReplyTopicManagerServiceImpl <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����03:32:38 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */

@Service @Scope("prototype") @Transactional
public class ReplyTopicManagerServiceImpl implements IReplyTopicManagerService{
	
	@Resource(name="replyTopicDao") IReplyTopicManagerDao dao = null;
	 @Resource ResultHelper helper = null;
	 @Resource SessionFactory sessionFactory = null;
	/**
	 * 
	 * <p>Title: addReplyTopic</p> 
	 * <p>Description: ���ӻظ�����</p> 
	 * @param replyTopic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IReplyTopicManagerService#addReplyTopic(com.bbs.bean.ReplyTopic) 
	 * ����:Cake
	 */
	public boolean addReplyTopic(ReplyTopic replyTopic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.addReplyTopic(replyTopic, session);
		}catch(Exception ex){
			throw new ServiceException("�ظ�����ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: deleteReplyTopic</p> 
	 * <p>Description:ɾ������ </p> 
	 * @param replyTopic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IReplyTopicManagerService#deleteReplyTopic(com.bbs.bean.ReplyTopic) 
	 * ����:Cake
	 */
	public boolean deleteReplyTopic(ReplyTopic replyTopic)
			throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.deleteReplyTopic(replyTopic, session);
		}catch(Exception ex){
			throw new ServiceException("ɾ������ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: getAllReplyTopic</p> 
	 * <p>Description: ��ȡ���лظ�����</p> 
	 * @param replyTopic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IReplyTopicManagerService#getAllReplyTopic(com.bbs.bean.ReplyTopic) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic)
			throws ServiceException {
		List<ReplyTopic> replyTopicList = new ArrayList<ReplyTopic>();
		try{
			Session session = sessionFactory.getCurrentSession();
			List list = dao.getAllReplyTopic(replyTopic,session);
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Object[] obj = (Object[])it.next();
				ReplyTopic rt = (ReplyTopic)obj[0];
				User user = (User)obj[1];
				rt.setReplyTUFK(user);
				replyTopicList.add(rt);
			}
		}catch(Exception ex){
			throw new ServiceException("��ȡ���лظ�����ʧ��!");
		}
		return replyTopicList;
	}
	
	/**
	 * 
	 * <p>Title: getReplyTopicById</p> 
	 * <p>Description: ����id��ûظ�������</p> 
	 * @param replyTopicid
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.IReplyTopicManagerService#getReplyTopicById(int) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ReplyTopic getReplyTopicById(int replyTopicid) throws ServiceException {
		ReplyTopic replyTopic = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			replyTopic = dao.getReplyTopicById(replyTopicid, session);
		}catch(Exception ex){
			throw new ServiceException("��������ʧ��!");
		}
		return replyTopic;
	}

	public boolean updateReplyTopic(ReplyTopic replyTopic)
			throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.updateReplyTopic(replyTopic, session);
		}catch(Exception ex){
			throw new ServiceException("�޸Ļ���ʧ��!");
		}
		return flag;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public int getReplyTopicCount(ReplyTopic replyTopic)
			throws ServiceException {
		int count =0;
		try{
			Session session = sessionFactory.getCurrentSession();
			count = dao.getReplyTopicCount(replyTopic, session);
		}catch(Exception ex){
			throw new ServiceException("��û�������ʧ��!");
		}
		return count;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getAllReplyTopic(ReplyTopic replyTopic, int page)
			throws ServiceException {
		List<ReplyTopic> replyTopicList = new ArrayList<ReplyTopic>();
		try{
			Session session = sessionFactory.getCurrentSession();
			List list = dao.getAllReplyTopic(replyTopic,session,page);
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Object[] obj = (Object[])it.next();
				ReplyTopic rt = (ReplyTopic)obj[0];
				User user = (User)obj[1];
				rt.setReplyTUFK(user);
				replyTopicList.add(rt);
			}
			helper.setList(replyTopicList);
			helper.setMaxPage(dao.getReplyTopicCount(replyTopic, session));
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("��ȡ���лظ�����ʧ��!");
		}
		return helper;
	}
	


}
