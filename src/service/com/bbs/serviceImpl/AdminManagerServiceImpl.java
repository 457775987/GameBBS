package com.bbs.serviceImpl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.Admin;
import com.bbs.dao.IAdminManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.service.IAdminManagerService;
@Service("adminService") @Transactional
public class AdminManagerServiceImpl implements IAdminManagerService{
    @Resource(name="adminDao") IAdminManagerDao adminDao = null;
    @Resource SessionFactory sessionFactory = null;
    @Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Admin getAdminById(int adminId) throws ServiceException {
				try{
		    	    Session session = sessionFactory.getCurrentSession();
					Admin admin = adminDao.getAdminById(adminId, session);
					return admin;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("管理员查询失败！");
				}
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Admin getAdminByAccount(String adminAccount) throws ServiceException {
				try{
                    Session session = sessionFactory.getCurrentSession();
					Admin admin = adminDao.getAdminByAccount(adminAccount, session);
					return admin;
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("管理员查询失败！");
				}
	}

	public void updateAdmin(Admin admin) throws ServiceException {
				try{
					Session session = sessionFactory.getCurrentSession();
					adminDao.updateAdmin(admin, session);
				}catch(Exception ex){
					ex.printStackTrace();
					throw new ServiceException("更新管理员信息失败！");
				}
	}

}
