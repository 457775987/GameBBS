package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�IReplyTopicManagerDao <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����03:26:40 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */
public interface IReplyTopicManagerDao {
	public boolean addReplyTopic(ReplyTopic replyTopic,Session session) throws Exception;
	public boolean updateReplyTopic(ReplyTopic replyTopic,Session session)throws Exception;
	public boolean deleteReplyTopic(ReplyTopic replyTopic,Session session)throws Exception;
	public ReplyTopic getReplyTopicById(int replyTopicid,Session session)throws Exception;
	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic,Session session) throws Exception;
	public int getReplyTopicCount(ReplyTopic replyTopic,Session session)throws Exception;
	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic,Session session,int page) throws Exception;
}
