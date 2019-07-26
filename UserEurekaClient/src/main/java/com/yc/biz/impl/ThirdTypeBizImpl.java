package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.bean.ThirdType;
import com.yc.biz.FirstTypeBiz;
import com.yc.biz.SecondTypeBiz;
import com.yc.biz.ThirdTypeBiz;
import com.yc.dao.BaseDao;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
@Service
public class ThirdTypeBizImpl implements ThirdTypeBiz {

	@Autowired
	private BaseDao baseDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<ThirdType> findAllThirdType() {

		return baseDao.findAll(ThirdType.class, "findAllThirdType");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public ThirdType findThirdTypeById(Integer thirdtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("thirdtype_id", thirdtype_id);
		return (ThirdType) baseDao.findOne(ThirdType.class,
				"findThirdTypeById", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int addThirdtype(ThirdType thirdType) {
		return baseDao.save(thirdType, "addThirdtype");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int delThirdType(Integer thirdtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("thirdtype_id", thirdtype_id);
		return baseDao.del(ThirdType.class, "delThirdType", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateThirdType(ThirdType thirdType) {
		 
		return baseDao.update(thirdType, "updateThirdType");
	}

	@Override
	public List<ThirdType> findThirdTypeBySecondTypeId(Integer secondtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype_id);
		return baseDao.findAll(ThirdType.class, "findThirdTypeBySecondTypeId", map);
	}

}
