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
import com.yc.biz.SecondTypeBiz;
import com.yc.dao.BaseDao;

/**
 * 
 * @author adeline
 * @date 2018年8月28日
 * @TODO
 */
@Service
public class SecondTypeBizImpl implements SecondTypeBiz {

	@Autowired
	private BaseDao baseDao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<SecondType> findAllSecondType() {
		return baseDao.findAll(SecondType.class, "findAllSecondType");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public SecondType findSecondTypeById(Integer secondtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype_id);
		return (SecondType) baseDao.findOne(SecondType.class,
				"findSecondTypeById", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int addSecondType(SecondType secondType) {

		return baseDao.save(secondType, "addSecondType");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int delSecondType(Integer secondtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype_id);
		return baseDao.del(SecondType.class, "delSecondType", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateSecondType(SecondType secondtype) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype);
		return baseDao.update(secondtype, "updateSecondType");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<SecondType> findThirdTypeBySecondTypeId(Integer secondtype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("secondtype_id", secondtype_id);
		return baseDao.findAll(SecondType.class, "findThirdTypeBySecondTypeId",
				map);
	}

	@Override
	public List<SecondType> findSecondTypeByFirstTypeId(Integer  firsttype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firsttype_id", firsttype_id);
		return baseDao.findAll(SecondType.class, "findSecondTypeByFirstTypeId",
				map);
	}
}
