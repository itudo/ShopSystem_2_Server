package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.Goods;
import com.yc.bean.GoodsDetail;
import com.yc.biz.GoodsDetailBiz;
import com.yc.dao.BaseDao;

/**
 * 
 * @author adeline
 * @date 2018年8月28日
 * @TODO
 */
@Service
public class GoodsDetailBizImpl implements GoodsDetailBiz {

	@Autowired
	private BaseDao baseDao;

	@Override
	public int addGoodsDetail(GoodsDetail goodsDetail) {
		return baseDao.save(goodsDetail, "addGoodsDetail");
	}

	@Override
	public int updateGoodsDetail(GoodsDetail goodsDetail) {
		return baseDao.update(goodsDetail, "updateGoodsDetail");
	}
	
	@Override
	public int updateGoodsDetailCount(GoodsDetail goodsDetail) {
		return baseDao.update(goodsDetail, "updateGoodsDetailCount");
	}

	@Override
	public List<GoodsDetail> findGoodsDetailByGoodsId(Integer goods_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goods_id", goods_id);
		return baseDao.findAll(GoodsDetail.class, "findGoodsDetailByGoodsId",
				map);
	}
	
	@Override
	public GoodsDetail findGoodsDetailById(GoodsDetail goodsDetail) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsdetail_id", goodsDetail.getGoodsdetail_id());
		List<GoodsDetail> list = baseDao.findAll(GoodsDetail.class, "findGoodsDetailById",map);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
