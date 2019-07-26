package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

import lombok.Data;

@Data
public class GoodsDetail implements Serializable {
	private static final long serialVersionUID = -2225704600669923145L;
	private Integer goodsdetail_id;
	private double goodsdetail_price;
	private Integer goods_count;
	private Goods goods;
	private List<Image> images;
	
	private List<Attribute> attribute;
	
	private String attr_name;
	
	private String contactStr;
	@Field
	public String goods_name;
	@Field
	public String type_name;
	private String goods_desc;
	private String goods_id;
	private String goods_price;
}
