package com.bbs.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bbs.bean.Address;
import com.bbs.dao.IAddressManagerDao;
import com.bbs.exception.ServiceException;
import com.bbs.service.IAddressManagerService;
@Service("addressService") @Transactional
public class AddressManagerServiceImpl implements IAddressManagerService{
	@Resource IAddressManagerDao addressDao = null;
	@Resource SessionFactory sessionFactory = null;
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Address> getAllAddress() throws ServiceException {
		try{
			Session session = sessionFactory.getCurrentSession();
			List<Address> address = addressDao.getAllAddress(session);
			return address;
		}catch(Exception ex){
			ex.printStackTrace();
			throw new ServiceException("ÐÂÔöÊ§°Ü!");
		}
	}
}
