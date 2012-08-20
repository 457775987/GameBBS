package com.bbs.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.User;
import com.bbs.dao.IRoleManagerDao;
import com.bbs.dao.IUserManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.helper.ResultHelper;
import com.bbs.service.IUserManagerService;
@Service("userService") @Scope("prototype") @Transactional
public class UserManagerServiceImpl implements IUserManagerService {
	   @Resource(name="userDao") IUserManagerDao userDao = null;
	   @Resource(name="roleDao") IRoleManagerDao roleDao = null;
	   @Resource(name="dateFormat") private SimpleDateFormat dateFormat = null;
	   @Resource User user = null;
       @Resource ResultHelper helper = null;
       @Resource SessionFactory sessionFactory = null;
	public boolean addUser(User user) throws ServiceException {
		try{
			Session session = sessionFactory.getCurrentSession();
			user.setUserRoleFK(roleDao.getRoleByName("普通用户", session));
			boolean insert = userDao.addUser(user, session);
			return insert;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("新增失败!");
		}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public User getUserByName(String userName) throws ServiceException {
		try{
			Session session = sessionFactory.getCurrentSession();
			User user = userDao.getUserByName(userName, session);
			return user;
		}catch(Exception ex){
			throw new ServiceException("查询失败!");
		}
	}

	public void updateUserById(User user) throws ServiceException {
		try{
			System.out.println(user.getVersion());
			Session session = sessionFactory.getCurrentSession();
			userDao.updateUserById(user, session);
		}catch(Exception ex){
			throw new ServiceException("更新失败!");
		}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public User getUserById(int userId) throws ServiceException {
		try{
			Session session = sessionFactory.getCurrentSession();
			User user = userDao.getUserById(userId, session);
			user.setPrototype(user);
			Date date = user.getUserUpdateDate();
			Date now = new Date();
			int age = user.getUserAge()+(now.getYear()-date.getYear());
			user.setUserAge(age);
			return user;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("更新失败!");
		}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getAllUser(int pageSize) throws ServiceException {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<User> users = userDao.getAllUser(pageSize, session);
			for(int i = 0;i<users.size();i++ ){
				users.get(i).setPrototype(users.get(i));
			}
			helper.setList(users);
			helper.setMaxPage(userDao.getAllUserCount(session));
			return helper;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("查询所有用户信息失败!");
		}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public ResultHelper getUserByType(String by, String param, int pageSize)
			throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					List<User> users= userDao.getUserByType(by, param, pageSize, session);
					for(int i = 0;i<users.size();i++ ){
						users.get(i).setPrototype(users.get(i));
					}
					helper.setList(users);
					helper.setMaxPage(userDao.getAllUserCount(session));
					return helper;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("查询失败");
				}
	}

	public void deleteUser(int userId) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					User user = userDao.getUserById(userId, session);
					userDao.deleteUser(user, session);
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("");
				}
	}

	   
}
