package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.yc.bean.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.biz.OrderBiz;
import com.yc.biz.ReviewBiz;
import com.yc.dao.BaseDao;
import com.yc.model.PageBean;

@Slf4j
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
public class ReviewBizImpl implements ReviewBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	
	@Resource(name="orderBizImpl")
	private OrderBiz orderBiz;
	
	@Resource(name="pageBean")
	private PageBean pageBean;

	@Override
	public boolean insertReview(Review review) {
		this.baseDao.save(review, "addReview");
		updateStatus(review.getOrderDetail());
		Orders orders = new Orders();
		orders.setOrder_id(review.getOrderDetail().getOrder_id());
		log.info("order_id{}",review.getOrderDetail().getOrder_id());
		List<Integer> list = orderBiz.selectOrderDetailStatus(orders);
		log.info("list{}",list);
		if(list == null||list.size()<=0){
			orders.setOrder_status(4);
			orderBiz.updateOrderstatus(orders);
		}
		return true;
	}

	@Override
	public boolean delReview(Review review) {
		this.baseDao.save(review, "delReview");
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
		return	 baseDao.findAll(Review.class, "getReviewByGoods", map);
	}
	
	public boolean updateStatus(OrderDetail orderDetail) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("orderdetail_id", orderDetail.getOrderdetail_id());
		int r = this.baseDao.update(Review.class, "updateStatus", map);
		if(r>0) {
			return true;
		}
		return false;
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
