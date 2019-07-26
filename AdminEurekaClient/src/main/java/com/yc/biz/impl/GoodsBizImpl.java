package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Goods;
import com.yc.biz.GoodsBiz;
import com.yc.dao.BaseDao;
import com.yc.model.PageBean;

@Service
public class GoodsBizImpl implements GoodsBiz {

	@Autowired
	private BaseDao BaseDao;

	@Override
	public int addGoods(Goods goods) {
		return BaseDao.save(goods, "addGoods");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public Goods getGoodsById(Integer goods_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods_id", goods_id);
		List<Goods> goods = BaseDao.findAll(Goods.class,
				"findGoodsByCondition", map);
		if (goods != null && goods.size() > 0) {
			return goods.get(0);
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public PageBean<Goods> findGoodsByCondition(Map<String, Object> map) {
		List<Goods> list = this.BaseDao.findAll(Goods.class,
				"findGoodsByCondition", map);
		int total = this.BaseDao.getCount(Goods.class, map,
				"findGoodsConditionCount");
		PageBean<Goods> pageBean = new PageBean<Goods>();
		pageBean.setRows(list);
		pageBean.setTotal(total);
		pageBean.setPages(Integer.parseInt(map.get("pages").toString()));
		pageBean.setPagesize(Integer.parseInt(map.get("pageSize").toString()));
		return pageBean;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public Integer findGoodsConditionCount(Map map) {
		return BaseDao.getCount(Goods.class, map, "findGoodsConditionCount");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public boolean delSingleGoods(Integer goods_id) {
		int result = BaseDao.del(Goods.class, goods_id+"", "delSingleGoods");
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public boolean delManyGoods(List<Goods> goods) {
		int result = BaseDao.del(Goods.class, goods, "delManyGoods");
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateGoods(Goods goods) {
		return BaseDao.update(goods, "updateGoods");
		 
	}

	@Override
	public List<Goods> findAllGoods() {
		return BaseDao .findAll(Goods.class, "findAllGoods");
	}

}
