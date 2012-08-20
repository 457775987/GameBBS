package com.bbs.daoImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.Topic;
import com.bbs.dao.ITopicManagerDao;
import com.bbs.file.PropertiesFileRead;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：TopicManagerDaoImpl <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake
* 创建时间：2012-6-11 下午03:00:39 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */
@Repository("topicDao")
public class TopicManagerDaoImpl implements ITopicManagerDao {
	@Resource(name="proFileRead") PropertiesFileRead pro = null;
	public boolean addTopic(Topic topic, Session session) throws Exception {
		return (Integer)session.save(topic)>0?true:false;
	}

	public boolean deleteTopic(Topic topic, Session session) throws Exception {
		Topic topic1 = (Topic)session.get(Topic.class, topic.getTopicId());
		session.delete(topic1);
		return true;
	}

	public List<Topic> getAllTopic(Topic topic,Session session)
			throws Exception {
		
		Query query = session.createQuery("select t,u from Topic t,User u where t.topicUFK.userId=u.userId and t.topicBFK.boardId="+topic.getTopicBFK().getBoardId());
		return query.list();
	}

	public List getTopicById(int topicid, Session session) throws Exception {
		return session.createQuery("select t,u from Topic t,User u where t.topicUFK.userId=u.userId and t.topicId="+topicid).list();
	}

	public boolean updateTopic(Topic topic, Session session) throws Exception {
		session.update(topic);
		return true;
	}

	public int getTopicCount(Topic topic, Session session) throws Exception {
		Query query = session.createQuery("from Topic t where t.topicBFK.boardId="+topic.getTopicBFK().getBoardId());
		int count = query.list().size();
		return count;
	}

	public List<Topic> getAllTopic(Topic topic, Session session, int page)
			throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		Query query = session.createQuery("select t,u from Topic t,User u where t.topicUFK.userId=u.userId and t.topicBFK.boardId="+topic.getTopicBFK().getBoardId());	
		return query.setMaxResults(size).setFirstResult(size*(page-1)).list();
	}

	public List<Topic> getSearchAllTopic(Topic topic, Session session)
			throws Exception {
		Query query =session.createQuery("select t,u from Topic t,User u where t.topicUFK.userId=u.userId and t.topicBFK.boardId=? and t.topicName like ?");
		query.setInteger(0,topic.getTopicBFK().getBoardId());
		query.setString(1, "%"+topic.getTopicName()+"%");
		return query.list();
	}


}
