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
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�ReplyTopicManagerDaoImpl <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����03:29:43 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
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
