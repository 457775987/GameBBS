package com.bbs.service;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.ReplyTopic;
import com.bbs.bean.Topic;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

public interface ITopicManagerService {
	public boolean addTopic(Topic topic) throws ServiceException;
	public boolean updateTopic(Topic topic)throws ServiceException;
	public boolean deleteTopic(Topic topic)throws ServiceException;
	public List getTopicById(int topicid)throws ServiceException;
	public List<Topic> getAllTopic(Topic topic) throws ServiceException;
	public List<Topic> newAddTopic(List<Topic> list,ITopicManagerService services,IReplyTopicManagerService replyservice,ReplyTopic replyTopic)throws ServiceException;
	public String lastReplyTime(List<ReplyTopic> listReplyTopic)throws ServiceException;
	public int replyNumber(List<ReplyTopic> listReplyTopic)throws ServiceException;
	public int getTopicCount(Topic topic)throws ServiceException;
	public ResultHelper getAllTopic(Topic topic,int page) throws ServiceException;
	public List<Topic> getSearchAllTopic(Topic topic)throws ServiceException;
}
