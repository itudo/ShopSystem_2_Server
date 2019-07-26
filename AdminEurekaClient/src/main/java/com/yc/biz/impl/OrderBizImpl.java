package com.yc.biz.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Cart;
import com.yc.bean.CartDetail;
import com.yc.bean.GoodsDetail;
import com.yc.bean.OrderDetail;
import com.yc.bean.Orders;
import com.yc.bean.Users;
import com.yc.biz.CartBiz;
import com.yc.biz.OrderBiz;
import com.yc.dao.BaseDao;
import com.yc.model.PageBean;
@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class OrderBizImpl implements OrderBiz {
	
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao baseDao;
	@Resource(name="cartBizImpl")
	private CartBiz cartBiz;
	
	@Override
	/**
	 *	从购物车里增加订单
	 * @param orders
	 * @return
	 */
	public boolean insertOrderFromCart(Users user,List<CartDetail> cartDetailList1) {
		Orders order = new Orders();
		double totalmoney = 0.0;
		String orderId = createOrderId();
		order.setOrder_id(orderId);
		List<CartDetail> cartDetailList = cartBiz.selectCartDetailListById(cartDetailList1);
		/*List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
		OrderDetail orderDetail = null;
		for(CartDetail cartDetail:cartDetailList){
			orderDetail = new OrderDetail();
			orderDetail.setGoods_count(cartDetail.getGoods_count());
			orderDetail.setGoods_buyprice(cartDetail.getGoods_money());
			orderDetail.setGoodsDetail(cartDetail.getGoodsDetail());
			orderDetailList.add(orderDetail);
		}*/
		for(CartDetail cartDetailMon:cartDetailList ){
			totalmoney+=cartDetailMon.getGoods_money()*cartDetailMon.getGoods_count();
		}
		order.setUser(user);
		order.setTo_userName(user.getName());
		order.setTo_addr(user.getUser_addr());
		order.setTo_tel(user.getUser_tel());
		order.setOrder_totalmoney(totalmoney);
		order.setOrder_status(0);
		order.setCartDetail(cartDetailList);
		insertOrder(order);
		return true;
	}

	
	
	
	public String createOrderId(){
		//我要获取当前的日期
        Date date = new Date();
        //设置要获取到什么样的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        //获取String类型的时间
        String nowdate = sdf.format(date);
        int num = (int)(Math.random()*90+10);
		String orderId = nowdate+(num+"");
        return orderId; 
	}
	
	/**
	 * 增加订单及其详情
	 */
	@Override
	public boolean insertOrder(Orders orders) {
		List<OrderDetail> list = orders.getOrderDetail();
		this.baseDao.save(orders, "insertOrder");
		this.baseDao.save(orders, "insertDetail");
		//this.baseDao.save(Orders.class, "insertDetail", list);
		return true;
	}

	
	/**
	 * 传入一个orderID，删除此订单及其详情
	 */
	@Override
	public boolean DeleteOrderAndOrderDetail(Orders orders) {
		//删除订单
		this.baseDao.del(Orders.class, orders.getOrder_id()+"", "deleteOrder");
		//删除订单详情
		this.baseDao.del(orders, "deleteDetail");
		return true;
	}

	@Override
	/**
	 * 传入一个orderID，判断是否未付款，否则删除此订单及其详情
	 */
	public boolean DeleteOrderDetailListByStatus(Orders orders) {
		Orders order = selectOrderById(orders);
		int state = order.getOrder_status();
		if(state==0){
			this.baseDao.del(Orders.class, orders.getOrder_id()+"", "deleteOrder");
			this.baseDao.del(orders, "deleteDetail");
		}
		return true;
	}

	
	/**
	 * 批量删除订单
	 */
	@Override
	public boolean deleteOrderList(List<String> order_ids) {
		this.baseDao.del(Orders.class, order_ids, "delMutilOrder");
		this.baseDao.del(Orders.class, order_ids, "delMutilDetail");
		return true;
	}

	

	@Override
	/**
	 * 更新订单状态
	 */
	public boolean updateOrderstatus(Orders orders) {
		this.baseDao.update(orders, "updateOrderstatus");
		return true;
	}

	@Override
	public boolean updateOrderstatusByList(List<String> list) {
		this.baseDao.update(Orders.class, "updateOrderstatusByList", list);
		return true;
	}
	
	/**
	 * 根据订单ID查订单
	 */
	@Override
	public Orders selectOrderById(Orders orders) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("order_id", orders.getOrder_id());
		Orders order = (Orders) this.baseDao.findOne(Orders.class, "selectOrder", map);
		return order;
	}
	/**
	 * 根据订单ID查订单详情
	 */
	@Override
	public List<OrderDetail> selectOrderDetailByOrderId(Orders orders) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("order_id",orders.getOrder_id());
		List<OrderDetail> details =  this.baseDao.findAll(Orders.class, "selectDetail", map);
		return details;
	}
	
	
	
/**************************************************************************/	
	
	/**
	 * 分页查询订单
	 */
	@Override
	public PageBean<Orders> selectOrder(Map<String, Object> map) {
		List<Orders> list = (List<Orders>) this.baseDao.findAll(Orders.class, "selectOrder", map);
		int total = this.baseDao.getCount(Orders.class, map, "SelectOrderConditionCount");
		PageBean pageBean = new PageBean();
		pageBean.setRows(list);
		pageBean.setTotal(total);
		if(map.get("pages")!=null && map.get("pages") !=""){
			pageBean.setPages(Integer.parseInt(  map.get("pages").toString()  ));
		}
		if(map.get("pagesize")!=null && map.get("pagesize") !=""){
			pageBean.setPagesize(Integer.parseInt( map.get("pagesize").toString() ));
			int totalpages = pageBean.getTotal()%(int)map.get("pagesize")==0?pageBean.getTotal()/(int)map.get("pagesize"):pageBean.getTotal()/(int)map.get("pagesize")+1;
			pageBean.setTotalpages(totalpages);
		}
		
		return pageBean;
	}
	/**
	 * 分页查询订单详情
	 */
	@Override
	public PageBean<OrderDetail> selectOrderDetail(Map<String, Object> map) {
		List<Orders> list =  this.baseDao.findAll(Orders.class, "selectDetail", map);
		int total = this.baseDao.getCount(Orders.class, map, "SelectDetailConditionCount");
		PageBean pageBean = new PageBean();
		pageBean.setRows(list);
		pageBean.setTotal(total);
		if(map.get("pages")!=null&&map.get("pages")!=""){
			pageBean.setPages(Integer.parseInt(map.get("pages").toString()));
		}
		
		if(map.get("pagesize")!=null&&map.get("pagesize")!=""){
			pageBean.setPagesize(Integer.parseInt(map.get("pagesize").toString()));
			int totalpages = pageBean.getTotal()%pageBean.getPagesize()==0?pageBean.getTotal()/pageBean.getPagesize():pageBean.getTotal()%pageBean.getPagesize()+1;
			pageBean.setTotalpages(totalpages);
		}
		return pageBean;
	}

}
