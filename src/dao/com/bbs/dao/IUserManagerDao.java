package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.User;

public interface IUserManagerDao {
       public boolean addUser(User user,Session session) throws Exception;
       public User getUserByName(String userName,Session session) throws Exception;
       public void updateUserById(User user,Session session) throws Exception;
       public User getUserById(int userId,Session session) throws Exception;
       public List getAllUser(int pageSize,Session session) throws Exception;
       public List<User> getUserByType(String by,String param,int pageSize,Session session) throws Exception;
       public int getAllUserCount(Session session) throws Exception;
       public void deleteUser(User user,Session session) throws Exception;
}
