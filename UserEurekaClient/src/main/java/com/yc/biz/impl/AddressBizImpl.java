package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Address;
import com.yc.bean.Cart;
import com.yc.bean.Goods;
import com.yc.bean.Users;
import com.yc.biz.AddressBiz;
import com.yc.dao.BaseDao;
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
@Service
public class AddressBizImpl implements AddressBiz {
	@Autowired
	private BaseDao BaseDao;
	
	@Override
	public int InsertAddr(Address address) {
		return this.BaseDao.save(address, "addAddress");
	}

	@Override
	public boolean updateAddr(Address address) {
		 this.BaseDao.update(address, "updateAddress");
		 return true;
	}
	
	@Override
	public boolean updateStatus(Address address) {
		 this.BaseDao.update(address, "updateStatus");
		 return true;
	}
	
	@Override
	public boolean setDefault(Address address) {
		Address add = getAddressByStatus(address);
		if(add!=null) {
			add.setAddress_status(0);
			updateStatus(add);
		}
		address.setAddress_status(1);
		updateStatus(address);
		return false;
	}

	@Override
	public List<Address> getAddressById(Users user) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		List<Address> addr = this.BaseDao.findAll(Address.class, "getAddress",map);
		return addr;
	}
	
	@Override
	public Address getAddressByStatus(Address address) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("address_status", 1);
		map.put("user_id",address.getUser().getUser_id());
		List<Address> addr = this.BaseDao.findAll(Address.class, "getAddressByStatus",map);
		if(addr!=null&&addr.size()>0) {
			return addr.get(0);
		}
		return null;
	}

	@Override
	public boolean delSingleAddress(Integer addrid) {
		int result = BaseDao.del(Address.class, addrid + "", "delSingleAddress");
		if (result > 0) {
			return true;
		}
		return false;
	}



}
