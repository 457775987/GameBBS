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
* 项目名称：GameBBS<br>
* 类名称：TopicManagerServiceImpl <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午03:01:47 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
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
	  * <p>Description: 增加帖子</p> 
	  * @param topic
	  * @return
	  * @throws ServiceException 
	  * @see com.bbs.service.ITopicManagerService#addTopic(com.bbs.bean.Topic) 
	  * 作者:Cake
	  */
	public boolean addTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.addTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("新增帖子失败!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: deleteTopic</p> 
	 * <p>Description:删除帖子 </p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#deleteTopic(com.bbs.bean.Topic) 
	 * 作者:Cake
	 */
	public boolean deleteTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.deleteTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("删除帖子失败!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: getAllTopic</p> 
	 * <p>Description: 获取所有帖子</p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#getAllTopic(com.bbs.bean.Topic) 
	 * 作者:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Topic> getAllTopic(Topic topic) throws ServiceException {
		List<Topic> topicList = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topicList = dao.getAllTopic(topic,session);
		}catch(Exception ex){
			throw new ServiceException("获取所有帖子失败!");
		}
		return topicList;
	}
	
	/**
	 * 
	 * <p>Title: getTopicById</p> 
	 * <p>Description: 根据帖子ID获得相应的帖子</p> 
	 * @param topicid
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#getTopicById(int) 
	 * 作者:Cake
	 */
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List getTopicById(int topicid) throws ServiceException {
		List topic = null;
		try{
			Session session = sessionFactory.getCurrentSession();
			topic = dao.getTopicById(topicid, session);
		}catch(Exception ex){
			throw new ServiceException("获取帖子失败!");
		}
		return topic;
	}
	
	/**
	 * 
	 * <p>Title: updateTopic</p> 
	 * <p>Description: 修改帖子</p> 
	 * @param topic
	 * @return
	 * @throws ServiceException 
	 * @see com.bbs.service.ITopicManagerService#updateTopic(com.bbs.bean.Topic) 
	 * 作者:Cake
	 */
	public boolean updateTopic(Topic topic) throws ServiceException {
		boolean flag = false;
		try{
			Session session = sessionFactory.getCurrentSession();
			flag = dao.updateTopic(topic, session);
		}catch(Exception ex){
			throw new ServiceException("修改失败!");
		}
		return flag;
	}
	
	/**
	 * 
	 * <p>Title: replyNumber</p> 
	 * <p>Description:得到回复数量 </p> 
	 * @param listReplyTopic
	 * @return
	 * @throws ServiceException 
	 * 作者:Cake
	 */
	public int replyNumber(List<ReplyTopic> listReplyTopic)throws ServiceException
	{
		return listReplyTopic.size();
	}
	
	/**
	 * 
	 * <p>Title: lastReplyTime</p> 
	 * <p>Description:得到最后发表回复人 </p> 
	 * @param listReplyTopic
	 * @return
	 * @throws ServiceException 
	 * 作者:Cake
	 */
	public String lastReplyTime(List<ReplyTopic> listReplyTopic)throws ServiceException
	{
		Iterator<ReplyTopic> it =listReplyTopic.iterator();
		long lasttime =0;
		String lastReplyUserInfo = "暂时没人回复";
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
	 * <p>Description: 得到所有帖子的id</p> 
	 * @param list
	 * @return 
	 * 作者:Cake
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
			throw new ServiceException("获得发帖总数失败!");
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
			throw new ServiceException("获取所有帖子失败!");
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
			throw new ServiceException("获取查询后的帖子失败!");
		}
		return topicList;
	}
}
