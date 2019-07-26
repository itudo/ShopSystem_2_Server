package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.Address;
import com.yc.bean.OrderDetail;
import com.yc.bean.Orders;
import com.yc.bean.Users;
import com.yc.biz.OrderBiz;
import com.yc.biz.ReviewBiz;
import com.yc.biz.UsersBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;

@RestController
@Slf4j
public class OrderController {
	@Resource(name="orderBizImpl")
	private OrderBiz orderBiz;
	
	@Resource(name="reviewBizImpl")
	private ReviewBiz reviewBiz;
	
	@RequestMapping(value="showOrder.action")
	public PageBean showOrder(@RequestParam(name="type")int type,HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		Map<String, Object> map = new HashMap<String,Object>();
		PageBean<Orders> list = new PageBean<Orders>();
		map.put("user_id", user.getUser_id());
		if(type==10) {
			list = orderBiz.selectOrder(map);
		} else {
			map.put("order_status", type);
			list = orderBiz.selectOrder(map);
		}
		list.setCode(1);
		return list;
	}

	@RequestMapping("changeOrder.action")
	public JsonModel changeOrder(@RequestParam(name="status")String status,Orders order) {
		JsonModel jsonModel = new JsonModel();
		if(status.trim().equals("还原")) {
			order.setOrder_status(4);
			orderBiz.updateOrderstatus(order);
			jsonModel.setCode(1);
		} else if(status.trim().equals("删除")) {
			order.setOrder_status(6);
			orderBiz.updateOrderstatus(order);
			jsonModel.setCode(1);
		} else if(status.trim().equals("取消")) {
			order.setOrder_status(5);
			orderBiz.updateOrderstatus(order);
			jsonModel.setCode(1);
		}else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	@RequestMapping(value={"admin/showOrder.action"})
	public PageBean adminShowOrder(Orders order) {
		Map<String, Object> map = new HashMap<String,Object>();
		PageBean<Orders> list = new PageBean<Orders>();
		
				map.put("order_status", order.getOrder_status());
				map.put("order_id", order.getOrder_id());
				map.put("order_time", order.getOrder_time());
				list = orderBiz.selectOrder(map);
		
		list.setCode(1);
		return list;
	}
	@RequestMapping(value={"admin/showOrderDetail.action"})
	public PageBean<OrderDetail> adminShowOrderDetail(Orders order) {
		Map<String, Object> map = new HashMap<String,Object>();
		PageBean<OrderDetail> orderDetailList = new PageBean<OrderDetail>();
		map.put("order_id", order.getOrder_id());
		orderDetailList = orderBiz.selectOrderDetail(map);
		orderDetailList.setCode(1);	
		return orderDetailList;
	}
	@RequestMapping(value={"admin/updateOrderStatus.action"})
	public JsonModel adminUpdateOrderStatus(Orders order) {
		JsonModel jsonModel = new JsonModel();
		order.setOrder_status(2);
		orderBiz.updateOrderstatus(order);
		jsonModel.setCode(1);
		return jsonModel;
	}
	@RequestMapping(value={"admin/mulUpdateStatus.action"})
	public JsonModel mulUpdateStatus(@RequestParam(name="order_ids") String order_ids) {
		JsonModel jsonModel = new JsonModel();
		List order_idList = new ArrayList<String>();
		if(order_ids!=null&&order_ids!=""){
			String[] orderid = order_ids.split(",");
			//System.out.println("orderids"+order_ids);
			for(int i=0;i<orderid.length;i++){
				order_idList.add(orderid[i]);
				System.out.println("---"+order_idList);
			}
			orderBiz.updateOrderstatusByList(order_idList);
			jsonModel.setCode(1);
		}else{
			jsonModel.setCode(0);
		}
		
		return jsonModel;
	}
	@RequestMapping(value={"admin/mulDelOrder.action"})
	public JsonModel mulDelOrder(@RequestParam(name="order_ids") String order_ids) {
		JsonModel jsonModel = new JsonModel();
		List order_idList = new ArrayList<String>();
		String[] orderid = order_ids.split(",");
		for(int i=0;i<orderid.length;i++){
			Orders o = new Orders();
			o.setOrder_id(orderid[i]);
			List<OrderDetail> od = orderBiz.selectOrderDetailByOrderId(o);
			for(OrderDetail d : od) {
				reviewBiz.delReview(d);
			}
			order_idList.add(orderid[i]);
		}
		orderBiz.deleteOrderList(order_idList);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
}
