package com.yc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class CartDetail implements Serializable{
	private static final long serialVersionUID = -1014373879619533921L;
	private Integer cartdetail_id;
	private double goods_money;
	private Integer goods_count;
	private Integer cartdetail_status;
    private GoodsDetail goodsDetail;
    private Cart cart;
}
