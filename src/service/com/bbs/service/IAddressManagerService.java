package com.bbs.service;

import java.util.List;

import com.bbs.bean.Address;

import com.bbs.exception.ServiceException;

public interface IAddressManagerService {
	   public List<Address> getAllAddress() throws ServiceException;
}
