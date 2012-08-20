package com.bbs.serviceImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.Role;
import com.bbs.dao.IRoleManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.service.IRoleManagerService;
@Service("roleService") @Scope("prototype") @Transactional
public class RoleManagerServiceImpl implements IRoleManagerService {
    @Resource(name="roleDao") IRoleManagerDao roleDao = null;
    @Resource SessionFactory sessionFactory = null;
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Role getRoleById(int roleId) throws Exception {
				try{
					Session session = sessionFactory.getCurrentSession();
					Role role = roleDao.getRoleById(roleId, session);
					return role;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("");
				}
	}
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Role getRoleByName(String roleName)
			throws Exception {
				try{
					Session session = sessionFactory.getCurrentSession();
					Role role = roleDao.getRoleByName(roleName, session);
					return role;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("");
				}
				
	}

}
