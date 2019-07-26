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
import com.yc.bean.CartDetail;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Users;
import com.yc.biz.CartBiz;
import com.yc.dao.BaseDao;
import com.yc.model.PageBean;
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
@Service
public class CartBizImpl implements CartBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	
	
	@Override
	public List<CartDetail> getCart(Users user) {
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		return	this.baseDao.findAll(Cart.class, "findCart", map);
		 
	}

	@Override
	public boolean addCart(Users user) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		this.baseDao.save(Cart.class, "saveCart",map);
		return true;
	}


	@Override
	public boolean addCartDetail(Users user,GoodsDetail goodsDetail) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		int cart_id = (int) this.baseDao.findOne(Cart.class, "selectCartByUserId", map);
		map.put("goodsdetail_id", goodsDetail.getGoodsdetail_id());
		CartDetail cartdetail = (CartDetail) this.baseDao.findOne(Cart.class, "selectCartDetailById",map);
		if(cartdetail==null) {
			Map<String,Object> map2 = new HashMap<String,Object>();
			map2.put("goodsdetail_price", goodsDetail.getGoodsdetail_price());
			map2.put("goodsdetail_id", goodsDetail.getGoodsdetail_id());
			map2.put("goods_count", goodsDetail.getGoods_count());
			map2.put("cart_id", cart_id);
			System.out.println("要添加的购物车信息为："+map2);
			this.baseDao.save(Cart.class, "saveCartDetail",map2);
			return true;
		} else {
			cartdetail.setGoods_count(cartdetail.getGoods_count()+goodsDetail.getGoods_count());
			if(updateCartDetailcount(cartdetail)) {
				return true;
			}
			return false;
		}
	}
	
	
	
	
	@Override
	public boolean deleteCartDetail(Users user) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", user.getUser_id());
		int cart_id = (int) this.baseDao.findOne(Cart.class, "selectCartByUserId", map);
		this.baseDao.del(Cart.class,cart_id+"","delMutilCartDetail");
		return true;
	}
	
	@Override
	public boolean deleteCartDetail(CartDetail cartDetail) {
		this.baseDao.del(Cart.class, cartDetail.getCartdetail_id()+"", "delCartDetail");
		return false;
	}

	@Override
	public boolean updateDetailStatus(CartDetail cartDetail) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cartdetail_id", cartDetail.getCartdetail_id());
		this.baseDao.update(Cart.class, "updateCartDetailstatus",map);
		return true;
	}

	@Override
	public boolean updateCartDetailstatusByList(List<CartDetail> list) {
		this.baseDao.update(Cart.class, "updateCartDetailstatusByList", list);
		return true;
	}
	
	@Override
	public boolean updateCartDetailcount(CartDetail cartDetail) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("goodsdetail_id", cartDetail.getCartdetail_id());
		int goods_count = this.baseDao.getCount(Cart.class,map, "selectGoodsDetailCount");
		if(cartDetail.getGoods_count()<=goods_count) {
			map.put("goods_count", cartDetail.getGoods_count());
			System.out.println(cartDetail.getGoods_count());
			this.baseDao.update(Cart.class, "updateCartDetailcount",map);
			return true;
		}
		return false;
	}

	@Override
	public  List<CartDetail> selectCartDetailListById(List<String> cartDetailList) {
		Map<String,Object> map  = new HashMap<String,Object>();
		map.put("cartDetailList", cartDetailList);
		return baseDao.findAll(Cart.class,"selectCartDetailListById",map);
	}
}
