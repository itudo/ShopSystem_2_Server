package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 订单表order  订单号  下单用户  收货人  收货地址  联系电话  创建时间  下单状态
 * @author Administrator
 *
 */
@Data
public class Orders implements Serializable {
	private static final long serialVersionUID = -2841047532985472037L;

	private  String order_id ;
	
	private String to_userName ;
	private String to_addr ;
	private String to_tel ;
	private String order_time ;
	private Integer order_status ;
	private double order_totalmoney;
	private Users user ;
	private List<OrderDetail> orderDetail;
	
	private List<CartDetail> cartDetail;

}
