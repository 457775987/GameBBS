package com.bbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.dao.IReplyTopicManagerDao;
import com.bbs.file.PropertiesFileRead;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：ReplyTopicManagerDaoImpl <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午03:29:43 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
* @version V1.0
 */

@Repository("replyTopicDao")
public class ReplyTopicManagerDaoImpl implements IReplyTopicManagerDao {
	@Resource(name="proFileRead") PropertiesFileRead pro = null;
	public boolean addReplyTopic(ReplyTopic replyTopic, Session session)
			throws Exception {
		return (Integer)session.save(replyTopic)>0?true:false;
	}

	public boolean deleteReplyTopic(ReplyTopic replyTopic, Session session)
			throws Exception {
		ReplyTopic replyTopic1 = (ReplyTopic) session.get(ReplyTopic.class, replyTopic.getReplyTId());
		session.delete(replyTopic1);
		return true;
	}

	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic,Session session)
			throws Exception {
		Query query = session.createQuery("select rt,u from ReplyTopic rt,User u where rt.replyTUFK.userId=u.userId and rt.replyTTFK.topicId="+replyTopic.getReplyTTFK().getTopicId());
		return query.list();
	}

	public ReplyTopic getReplyTopicById(int replyTopicid, Session session)
			throws Exception {
		return (ReplyTopic)session.get(ReplyTopic.class, replyTopicid);
	}

	public boolean updateReplyTopic(ReplyTopic replyTopic, Session session)
			throws Exception {
		session.update(replyTopic);
		return true;
	}

	public int getReplyTopicCount(ReplyTopic replyTopic, Session session)
			throws Exception { 
		Query query = session.createQuery("from ReplyTopic rt where rt.replyTTFK.topicId="+replyTopic.getReplyTTFK().getTopicId());
		int count = query.list().size();
		return count;
	}

	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic,
			Session session, int page) throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		Query query = session.createQuery("select rt,u from ReplyTopic rt,User u where rt.replyTUFK.userId=u.userId and rt.replyTTFK.topicId="+replyTopic.getReplyTTFK().getTopicId());
		return query.setMaxResults(size).setFirstResult(size*(page-1)).list();
	}

}
