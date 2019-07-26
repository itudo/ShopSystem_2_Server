package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Cart;
import com.yc.bean.CartDetail;
import com.yc.bean.OrderDetail;
import com.yc.bean.Orders;
import com.yc.bean.Users;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;

public interface OrderBiz {
	
	
	/**
	 *	从购物车里增加订单
	 * @param orders
	 * @return
	 */
	public String insertOrderFromCart(Users user,List<String> cartDetailList,Orders order);
	
	public String createOrderId();
	/**
	 * 增加订单
	 * @param orders
	 * @return
	 */
	public String insertOrder(Orders orders);
	/**
	 * 批量删除订单
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrderList(List<String> order_ids);
	
	/**
	 * 根据订单ID修改订单状态
	 * @param orders
	 * @return
	 */
	public boolean updateOrderstatus(Orders orders);
	
	public Integer getStatus(Orders orders);
	
	public Integer getOrderMoney(Orders orders);
	
	/**
	 * 查询
	 * @param map
	 * @return
	 */
	public PageBean<Orders> selectOrder(Map<String,Object> map);


	public void updateOrderDetailStatus(Orders order);

	/**
	 * 根据ID查订单
	 * @param orders
	 * @return
	 */
	public Orders selectOrderById(Orders orders);
	
	/***********************************************************************/
	
	/**
	 * 分页查询订单
	 * @param map
	 * @return
	 */
	public PageBean<OrderDetail> selectOrderDetail(Map<String,Object> map);
	
	/**
	 * 根据订单ID查订单详情
	 * @param orders
	 * @return
	 */
	public List<OrderDetail> selectOrderDetailByOrderId(Orders orders);
	
	public List<Integer> selectOrderDetailStatus(Orders orders);
	

	/**
	 * 批量删除一个订单下面的所有的订单详情
	 * @param orders
	 * @return
	 */
	public boolean DeleteOrderAndOrderDetail(Orders orders);
	/**
	 * 批量删除未付款订单及其详情
	 * @param orders
	 * @return
	 */
	public boolean DeleteOrderDetailListByStatus(Orders orders);
}
