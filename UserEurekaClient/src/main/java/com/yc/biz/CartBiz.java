package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Cart;
import com.yc.bean.CartDetail;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Users;
import com.yc.model.PageBean;


public interface CartBiz {
	
	/**
	 * 根据id查购物车信息
	 * @param <T>
	 * @param cart
	 * @return
	 */
	public  List<CartDetail> selectCartDetailListById(List<String> cartDetailList1);
	
	/**
	 * 根据id查购物车信息
	 * @param cart
	 * @return
	 */
	public List<CartDetail> getCart(Users user);
	
	/**
	 * 添加购物车
	 * @return
	 */
	public boolean addCart(Users user);
	
	
	
	/**
	 * 添加购物车详情
	 * @param Cart
	 * @return
	 */
	public boolean addCartDetail(Users user,GoodsDetail goodsDetail);
	
	/**
	 * 更新购物车
	 * @param cart
	 * @return
	 */
	
	public boolean updateCartDetailcount(CartDetail cartDetail);
	/**
	 * 更新购物车
	 * @param cart
	 * @return
	 */
	
	public boolean updateDetailStatus(CartDetail cartDetail);
	
	/**
	 * 批量更新购物车
	 * @param cart
	 * @return
	 */
	
	public boolean updateCartDetailstatusByList(List<CartDetail> cartDetailList);
	/**
	 * 根据购物车ID清空购物车
	 * @param cartdetail_id
	 * @return
	 */
	public boolean deleteCartDetail(Users user);
	
	public boolean deleteCartDetail(CartDetail cartDetail);

}
