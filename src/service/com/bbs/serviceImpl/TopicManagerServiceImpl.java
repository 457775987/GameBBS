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
import com.bbs.dao.ITopicManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IReplyTopicManagerService;
import com.bbs.service.ITopicManagerService;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�TopicManagerServiceImpl <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����03:01:47 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */

@Service @Scope("prototype") @Transactional
public class TopicManagerServiceImpl implements ITopicManagerService {
	
	 @Resource(name="topicDao") ITopicManagerDao dao = null;
	 @Resource ResultHelper helper = null;
	 @Resource SessionFactory sessionFactory = null;
	 /**
	  * 
	  * <p>Title: addTopic</p> 
	  * <p>Description: ��������</p> 
	  * @param topic
	  * @return
	  * @throws ServiceException 
	  * @see com.bbs.service.ITopicManagerService#addTopic(com.bbs.bean.Topic) 
	  * ����:Cake
	  */
	public boolean addTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.addTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("��������ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: deleteTopic</p> 
	 * <p>Description:ɾ������ </p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#deleteTopic(com.bbs.bean.Topic) 
	 * ����:Cake
	 */
	public boolean deleteTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.deleteTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("ɾ������ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: getAllTopic</p> 
	 * <p>Description: ��ȡ��������</p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#getAllTopic(com.bbs.bean.Topic) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Topic> getAllTopic(Topic topic) throws ServiceException {
		List<Topic> topicList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topicList = dao.getAllTopic(topic,session);
		}catch(Exception ex){
			throw new ServiceException("��ȡ��������ʧ��!");
		}
		return topicList;
	}
	
	/**
	 * 
	 * <p>Title: getTopicById</p> 
	 * <p>Description: ��������ID�����Ӧ������</p> 
	 * @param topicid
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#getTopicById(int) 
	 * ����:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List getTopicById(int topicid) throws ServiceException {
		List topic = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topic = dao.getTopicById(topicid, session);
		}catch(Exception ex){
			throw new ServiceException("��ȡ����ʧ��!");
		}
		return topic;
	}
	
	/**
	 * 
	 * <p>Title: updateTopic</p> 
	 * <p>Description: �޸�����</p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#updateTopic(com.bbs.bean.Topic) 
	 * ����:Cake
	 */
	public boolean updateTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.updateTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("�޸�ʧ��!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: replyNumber</p> 
	 * <p>Description:�õ��ظ����� </p> 
	 * @param listReplyTopic
	 * @return
	 * @throws ServiceException 
	 * ����:Cake
	 */
	public int replyNumber(List<ReplyTopic> listReplyTopic)throws ServiceException
	{
		return listReplyTopic.size();
	}
	
	/**
	 * 
	 * <p>Title: lastReplyTime</p> 
	 * <p>Description:�õ���󷢱�ظ��� </p> 
	 * @param listReplyTopic
	 * @return
	 * @throws ServiceException 
	 * ����:Cake
	 */
	public String lastReplyTime(List<ReplyTopic> listReplyTopic)throws ServiceException
	{
		Iterator<ReplyTopic> it =listReplyTopic.iterator();
		long lasttime =0;
		String lastReplyUserInfo = "��ʱû�˻ظ�";
		while(it.hasNext())
		{
			ReplyTopic replytopic = (ReplyTopic)it.next();
			long time =(replytopic.getReplyTCreateTime()).getTime();
			System.out.println("time:"+time);
			if(lasttime==0)
			{
				lasttime=time;
				lastReplyUserInfo = replytopic.getReplyTUFK().getUserNickName()+" "+replytopic.getReplyTCreateTime();
			}
			else
			{
				if(lasttime>=time)
				{
					lastReplyUserInfo = replytopic.getReplyTUFK().getUserNickName()+" "+replytopic.getReplyTCreateTime();
				}
				else
				{
					lasttime = time;
				}
			}
		}
		return lastReplyUserInfo;
	}
	
	/**
	 * 
	 * <p>Title: TopicID</p> 
	 * <p>Description: �õ��������ӵ�id</p> 
	 * @param list
	 * @return 
	 * ����:Cake
	 */
	public List<Topic> newAddTopic(List<Topic> list,ITopicManagerService services,IReplyTopicManagerService replyservice,ReplyTopic replyTopic)throws ServiceException
	{
		List<Topic> newlist = new ArrayList<Topic>();
		Iterator it =list.iterator();
		while(it.hasNext())
		{
			Object[] obj = (Object[]) it.next();
			Topic topic =(Topic)obj[0];
			User user = (User)obj[1];
			topic.setTopicUFK(user);
			
			replyTopic.setReplyTTFK(topic);
			List<ReplyTopic> replyList =replyservice.getAllReplyTopic(replyTopic);
			int replyNum =services.replyNumber(replyList);
			String lastReplyUserInfo = services.lastReplyTime(replyList);
			topic.setLastReplyUserName(lastReplyUserInfo);
			topic.setReplyNumber(replyNum);
			newlist.add(topic);
		}
		return newlist;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public int getTopicCount(Topic topic) throws ServiceException {
		int count =0;
		try{
			Session session = sessionFactory.getCurrentSession();
			count = dao.getTopicCount(topic, session);
		}catch(Exception ex){
			throw new ServiceException("��÷�������ʧ��!");
		}
		return count;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getAllTopic(Topic topic, int page)
			throws ServiceException {
		List<Topic> topicList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topicList = dao.getAllTopic(topic,session,page);
			helper.setList(topicList);
			helper.setMaxPage(dao.getTopicCount(topic, session));
		}catch(Exception ex){
			throw new ServiceException("��ȡ��������ʧ��!");
		}
		return helper;
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Topic> getSearchAllTopic(Topic topic) throws ServiceException {
		List<Topic> topicList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topicList = dao.getSearchAllTopic(topic, session);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("��ȡ��ѯ�������ʧ��!");
		}
		return topicList;
	}
}
