package com.bbs.service;

import java.util.List;

import com.bbs.bean.User;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;

public interface IUserManagerService {
       public boolean addUser(User user) throws ServiceException;
       public User getUserByName(String userName) throws ServiceException;
       public void updateUserById(User user) throws ServiceException;
       public User getUserById(int userId) throws ServiceException;
       public ResultHelper getAllUser(int pageSize) throws ServiceException;
       public ResultHelper getUserByType(String by,String param,int pageSize)throws ServiceException;
       public void deleteUser(int userId) throws ServiceException;
}
