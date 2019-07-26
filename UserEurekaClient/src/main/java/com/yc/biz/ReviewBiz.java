package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Goods;
import com.yc.bean.OrderDetail;
import com.yc.bean.Review;
import com.yc.bean.Users;
import com.yc.model.PageBean;

public interface ReviewBiz {
	
	public boolean insertReview(Review review);
	
	public boolean delReview(Review review);
	
	public List<Review> getMyReview(Users user);
	
	public List<Review> getReviewByGoods(Goods goods);
	
	public PageBean getAllReview(Map<String,Object>map);
	
	public boolean updateStatus(OrderDetail orderDetail);
}
