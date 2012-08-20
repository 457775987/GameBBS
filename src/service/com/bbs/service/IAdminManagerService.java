package com.bbs.service;


import com.bbs.bean.Admin;
import com.bbs.exception.ServiceException;

public interface IAdminManagerService {
    public Admin getAdminById(int adminId) throws ServiceException;
    public Admin getAdminByAccount(String adminAccount) throws ServiceException;
    public void updateAdmin(Admin admin) throws ServiceException;
}
