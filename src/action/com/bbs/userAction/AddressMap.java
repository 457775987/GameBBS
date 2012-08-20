package com.bbs.userAction;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.bbs.bean.Address;

import com.bbs.exception.ServiceException;
import com.bbs.service.IAddressManagerService;
import com.opensymphony.xwork2.ActionSupport;
@Controller
public class AddressMap extends ActionSupport{
       @Resource IAddressManagerService addressService = null;
       private List<Address> address = null;
       private String page;
       private int userId;
       @Override
    public String execute() throws Exception {
    	try{
    		address = addressService.getAllAddress();
    	}catch(ServiceException ex){
    		
    	}
    	return page;
    }
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
