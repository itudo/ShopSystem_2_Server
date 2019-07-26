package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.bean.ThirdType;
import com.yc.biz.FirstTypeBiz;
import com.yc.dao.BaseDao;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
public class FirstTypeBizImpl implements FirstTypeBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	
	
	@Override
	public List<FirstType> findAll(){
		return this.baseDao.findAll(FirstType.class, "findTypeBySid");
	}
	
	
	public List<FirstType> findAllFirstType() {
		return baseDao.findAll(FirstType.class, "findAllFirstType");
	}
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public FirstType findFirstTypeById(Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firsttype_id", id);
		return (FirstType) baseDao.findOne(FirstType.class,
				"findFirstTypeById", map);
	}

	@Override
	public int addFirstType(FirstType firstType) {
		return baseDao.save(firstType, "addFirstType");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<FirstType> findSecondTypeByFirstTypeId(Integer firsttype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firsttype_id", firsttype_id);
		return baseDao.findAll(FirstType.class, "findSecondTypeByFirstTypeId",
				map);
	}

	@Override
	public int delFirstType(Integer firsttype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firsttype_id", firsttype_id);
		return baseDao.del(FirstType.class, "delFirstType", map);
	}

	@Override
	public int updateFirstType(FirstType firsttype_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("firsttype_id", firsttype_id);
		return baseDao.update(firsttype_id, "updateFirstType");
	}


}
