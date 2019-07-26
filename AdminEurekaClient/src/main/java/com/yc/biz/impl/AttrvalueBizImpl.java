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
import com.yc.biz.AttrvalueBiz;
import com.yc.dao.BaseDao;

@Service
public class AttrvalueBizImpl implements AttrvalueBiz {
	
	@Autowired
	private BaseDao BaseDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<Attrvalue> getAttrvalueByPid(Integer attribute_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("attribute_id", attribute_id);
		return BaseDao.findAll(Attrvalue.class, "getAttrvalueByPid", map);
	}

}
