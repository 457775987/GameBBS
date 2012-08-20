package com.bbs.daoImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.Role;
import com.bbs.dao.IRoleManagerDao;
import com.bbs.exception.ServiceException;
@Repository("roleDao")
public class RoleManagerDaoImpl implements IRoleManagerDao {

	public Role getRoleById(int roleId, Session session) throws Exception {
		return (Role)session.get(Role.class, roleId);
	}

	public Role getRoleByName(String roleName, Session session)
			throws Exception {
		return (Role)session.createCriteria(Role.class).add(Restrictions.eq("roleName", roleName)).uniqueResult();
	}

}
