package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Contact;
import com.yc.biz.ContactBiz;
import com.yc.dao.BaseDao;

@Service
public class ContactBizImpl implements ContactBiz {

	@Autowired
	private BaseDao BaseDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int addContact(Contact contact) {
		return BaseDao.save(contact, "addContact");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<Contact> findAllContact() {
		return BaseDao.findAll(Contact.class, "findAllContact");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public boolean findContactById(Integer contact_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("contact_id", contact_id);
		List<Contact> contact = (List<Contact>) BaseDao.findAll(Contact.class,
				"findContactById", map);
		if(contact.size() >0){
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public boolean findContactByGoodsDetailId(Integer goodsdetail_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsdetail_id", goodsdetail_id);
		List<Contact> list =  (List<Contact>) BaseDao.findAll(Contact.class,
				"findContactByGoodsDetailId", map);
		if(list.size()>0){
			return true ;
		}else{
			return false ;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<Contact> findContactByAttributeId(Integer attribute_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute_id", attribute_id);
		return (List<Contact>) BaseDao.findAll(Contact.class,
				"findContactByAttributeId", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateContactByGoodsDetailId(Contact contact) {
		return BaseDao.update(contact, "updateContactByGoodsDetailId");
	}

}
