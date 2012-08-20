package com.bbs.daoImpl;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.Admin;
import com.bbs.bean.User;
import com.bbs.dao.IAdminManagerDao;
@Repository("adminDao")
public class AdminManagerDaoImpl implements IAdminManagerDao {

	public Admin getAdminById(int adminId, Session session) throws Exception {
		return (Admin)session.get(Admin.class, adminId);
	}

	public Admin getAdminByAccount(String adminAccount, Session session)
			throws Exception {
		return (Admin)session.createCriteria(Admin.class).add(Restrictions.eq("adminAccount", adminAccount))
		.uniqueResult();
	}

	public void updateAdmin(Admin admin, Session session) throws Exception {
		session.update(admin);
	}

}
