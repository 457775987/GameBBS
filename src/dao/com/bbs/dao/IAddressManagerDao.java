package com.bbs.dao;

import java.util.List;

import org.hibernate.Session;

import com.bbs.bean.Address;

public interface IAddressManagerDao {
	   public List<Address> getAllAddress(Session session) throws Exception;
}
