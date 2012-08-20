package com.bbs.service;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

/**
 * 
* 项目名称：GameBBS<br>
* 类名称：IReplyTopicManagerService <br>  
* 类描述：  TODO(请输入类的描述) <br>
* 创建人：Cake   
* 创建时间：2012-6-11 下午03:32:26 <br> 
* 修改人：   
* 修改时间：                  <br>  
* 修改备注：   
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
