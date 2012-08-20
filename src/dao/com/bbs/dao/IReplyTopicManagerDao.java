package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：IReplyTopicManagerDao <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午03:26:40 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
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
