package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.Topic;

public interface ITopicManagerDao {
	public boolean addTopic(Topic topic,Session session) throws Exception;
	public boolean updateTopic(Topic topic,Session session)throws Exception;
	public boolean deleteTopic(Topic topic,Session session)throws Exception;
	public List getTopicById(int topicid,Session session)throws Exception;
	public List<Topic> getAllTopic(Topic topic,Session session) throws Exception;
	public int getTopicCount(Topic topic,Session session)throws Exception;
	public List<Topic> getAllTopic(Topic topic,Session session,int page) throws Exception;
	public List<Topic> getSearchAllTopic(Topic topic,Session session)throws Exception;
}
