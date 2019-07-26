package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class Goods implements Serializable{
	private static final long serialVersionUID = -4832979717555703628L;
	private Integer goods_id;
	private String goods_name;
	private String goods_desc;
	private String goods_pubtime;
	private Integer goods_isnew;
	private Integer goods_sale;
	private ThirdType thirdType;
	private List<GoodsDetail> goodsDetails;
}
