package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class GoodsDetail implements Serializable {
	private static final long serialVersionUID = -2225704600669923145L;
	private Integer goodsdetail_id;
	private double goodsdetail_price;
	private Integer goods_count;
	private Goods goods;
	private List<Image> images;
}
