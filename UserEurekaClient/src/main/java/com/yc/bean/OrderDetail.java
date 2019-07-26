package com.yc.bean;

import java.io.Serializable;

import lombok.Data;


@Data
/**
 * 订单详情表detail   
 * @author Administrator
 *
 */
public class OrderDetail implements Serializable {
	private static final long serialVersionUID = 5841289004765949746L;
	private Integer orderdetail_id ;
	private Integer goods_count ;
	private double goods_buyprice ;
	private String goods_name;
	private GoodsDetail goodsDetail  ;
	private Orders orders;
	private String order_id = "";
	
	private String orderdetail_status;
}
