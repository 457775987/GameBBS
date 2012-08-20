/**
 * 
 */
package com.bbs.daoImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.User;
import com.bbs.dao.IUserManagerDao;
import com.bbs.file.PropertiesFileRead;

/**
 * @author sxp
 *
 */
@Repository("userDao")
public class UserManagerDaoImpl implements IUserManagerDao {
    @Resource(name="proFileRead") PropertiesFileRead pro = null;
	public boolean addUser(User user, Session session) throws Exception {
		return (Integer)session.save(user)>0?true:false;
	}

	public User getUserByName(String userName, Session session)
			throws Exception {
		return (User)session.createCriteria(User.class).add(Restrictions.eq("userName", userName))
		.uniqueResult();
	}

	public void updateUserById(User user, Session session) throws Exception {
		session.update(user);
	}

	public User getUserById(int userId, Session session) throws Exception {
		return (User)session.get(User.class, userId);
	}

	public List getAllUser(int pageSize, Session session)
			throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		return session.createQuery("from User")
		.setMaxResults(size)
		.setFirstResult(size*pageSize).list();
	}

	public List<User> getUserByType(String by, String param, int pageSize,
			Session session) throws Exception {
		int size = Integer.parseInt(pro.getValue("pageSize"));
		return session.createCriteria(User.class).add(Restrictions.like(by, "%"+param+"%"))
		.setFirstResult(size*pageSize).setMaxResults(size).list();
	}
	public int getAllUserCount(Session session) throws Exception{
		   return (Integer)session.createCriteria(User.class).setProjection(Projections.rowCount())
		   .uniqueResult();
	}

	public void deleteUser(User user, Session session) throws Exception {
		   session.delete(user);
	}
}
