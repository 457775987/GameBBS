package com.bbs.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.bbs.bean.Address;
import com.bbs.dao.IAddressManagerDao;
@Repository("addressDao")
public class AddressManagerDaoImpl implements IAddressManagerDao {

	public List<Address> getAllAddress(Session session) throws Exception {
		return session.createCriteria(Address.class).list();
	}

}
