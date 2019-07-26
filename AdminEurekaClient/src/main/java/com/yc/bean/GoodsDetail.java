package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class GoodsDetail implements Serializable {
	private static final long serialVersionUID = -2225704600669923145L;
	private Integer goodsdetail_id;
	private double goodsdetail_price;
	private Integer goods_count;
	private String attr_name;
	private String contactStr;
	private Goods goods;
	private List<Contact>  contact;
	private List<Image> images;
	private List<Attribute>  attribute;
}
