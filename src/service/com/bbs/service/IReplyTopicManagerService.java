package com.bbs.service;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

/**
 * 
* ��Ŀ���ƣ�GameBBS<br>
* �����ƣ�IReplyTopicManagerService <br>  
* ��������  TODO(�������������) <br>
* �����ˣ�Cake   
* ����ʱ�䣺2012-6-11 ����03:32:26 <br> 
* �޸��ˣ�   
* �޸�ʱ�䣺                  <br>  
* �޸ı�ע��   
* @version V1.0
 */
public interface IReplyTopicManagerService {
	public boolean addReplyTopic(ReplyTopic replyTopic) throws ServiceException;
	public boolean updateReplyTopic(ReplyTopic replyTopic)throws ServiceException;
	public boolean deleteReplyTopic(ReplyTopic replyTopic)throws ServiceException;
	public ReplyTopic getReplyTopicById(int replyTopicid)throws ServiceException;
	public List<ReplyTopic> getAllReplyTopic(ReplyTopic replyTopic) throws ServiceException;
	public int getReplyTopicCount(ReplyTopic replyTopic)throws ServiceException;
	public ResultHelper getAllReplyTopic(ReplyTopic replyTopic,int page) throws ServiceException;
}
