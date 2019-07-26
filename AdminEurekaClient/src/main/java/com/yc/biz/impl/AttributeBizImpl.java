package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Attribute;
import com.yc.bean.Attrvalue;
import com.yc.biz.AttributeBiz;
import com.yc.dao.BaseDao;

/**
 * 
 * @author adeline
 * @date 2018年8月29日
 * @TODO
 */
@Service
public class AttributeBizImpl implements AttributeBiz {

	@Autowired
	private BaseDao BaseDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int addAttrinbute(Attribute attribute) {
		return BaseDao.save(attribute, "addAttrinbute");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<Attribute> getAllAttribute() {
		return BaseDao.findAll(Attribute.class, "getAllAttribute");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public Attribute getAttributeById(Integer attribute_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute_id", attribute_id);
		return (Attribute) BaseDao.findOne(Attribute.class, "getAttributeById",
				map);
	}

	 

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateAttribute(Attribute attribute) {
		return BaseDao.update(attribute, "updateAttribute");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int delAttribute(Integer attribute_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute_id", attribute_id);
		return BaseDao.del(Attribute.class, "delAttribute", map);
	}

	@Override
	public List<Attribute> getAttributeBySecondType(Integer secondtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype_id);
		return BaseDao
				.findAll(Attribute.class, "getAttributeBySecondType", map);
	}

}
