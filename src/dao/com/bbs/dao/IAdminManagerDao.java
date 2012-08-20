package com.bbs.dao;

import org.hibernate.Session;

import com.bbs.bean.Admin;

public interface IAdminManagerDao {
       public Admin getAdminById(int adminId,Session session) throws Exception;
       public Admin getAdminByAccount(String adminAccount,Session session) throws Exception;
       public void updateAdmin(Admin admin,Session session) throws Exception;
}
