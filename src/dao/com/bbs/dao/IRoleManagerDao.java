package com.bbs.dao;

import org.hibernate.Session;

import com.bbs.bean.Role;

public interface IRoleManagerDao {
       public Role getRoleById(int roleId,Session session) throws Exception;
       public Role getRoleByName(String roleName,Session session) throws Exception;
}
