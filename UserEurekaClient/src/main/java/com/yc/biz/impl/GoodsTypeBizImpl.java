package com.yc.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.GoodsType;
import com.yc.biz.GoodsTypeBiz;
import com.yc.dao.BaseDao;

@Service
public class GoodsTypeBizImpl implements GoodsTypeBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private   BaseDao  baseDao ;

	@Override
	public List<GoodsType> findAllGoodsType() {
		List<GoodsType>  list = baseDao.findAll(GoodsType.class, "findAllGoodsType");
		return list ;
	}

	@Override
	public GoodsType findGoodsTypeById(Integer typeid) {
		return (GoodsType) baseDao.findOne(GoodsType.class, "findGoodsTypeById");
	}
	
	

}
