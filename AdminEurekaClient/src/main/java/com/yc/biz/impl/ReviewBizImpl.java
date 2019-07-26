package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Cart;
import com.yc.bean.Goods;
import com.yc.bean.OrderDetail;
import com.yc.bean.Review;
import com.yc.bean.Users;
import com.yc.biz.ReviewBiz;
import com.yc.dao.BaseDao;
import com.yc.model.PageBean;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
public class ReviewBizImpl implements ReviewBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	@Resource(name="pageBean")
	private PageBean pageBean;
	@Override
	public boolean insertReview(Review review) {
		this.baseDao.save(review, "addReview");
		return true;
	}

	@Override
	public boolean delReview(OrderDetail orderDetail) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderdetail_id", orderDetail.getOrderdetail_id());
		this.baseDao.save(Review.class, "delReview",map);
		return true;
	}

	@Override
	public List<Review> getMyReview(Users user) {
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		return	 baseDao.findAll(Review.class, "myReview", map);
	}

	@Override
	public List<Review> getReviewByGoods(Goods goods) {
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("goods_id", goods.getGoods_id());
		return	 baseDao.findAll(Review.class, "myReview", map);
	}

	@Override
	public PageBean getAllReview(Map<String,Object>map) {
		List<Review> list = this.baseDao.findAll(Review.class, "getAllReview",map);
		int total = this.baseDao.getCount(Review.class, "SelectReviewConditionCount");
		pageBean.setRows(list);
		pageBean.setTotal(total);
		return pageBean;
		 
	}

}
