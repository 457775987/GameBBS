package com.bbs.service;

import org.hibernate.Session;

import com.bbs.bean.Role;

public interface IRoleManagerService {
    public Role getRoleById(int roleId) throws Exception;
    public Role getRoleByName(String roleName) throws Exception;
}
