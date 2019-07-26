package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Goods implements Serializable {

	public Goods() {
		super();
	}

	public Goods(Integer goods_id, String goods_name, String goods_desc,
			Integer goods_isnew,Integer goods_sale) {
		super();
		this.goods_id = goods_id;
		this.goods_name = goods_name;
		this.goods_desc = goods_desc;
        this.goods_sale = goods_sale;
		this.goods_isnew = goods_isnew;

	}

	private static final long serialVersionUID = -4832979717555703628L;
	private Integer goods_id;
	private String goods_name;
	private String goods_desc;
	private String goods_pubtime;
	private Integer goods_isnew;
	private Integer goods_sale;
	private ThirdType thirdType;
	private List<GoodsDetail> goodsDetails;
	
	private Integer sale;
}
