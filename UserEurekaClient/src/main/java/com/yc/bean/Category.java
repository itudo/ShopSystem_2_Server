package com.yc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class Category implements Serializable{
	private static final long serialVersionUID = -4213143187495581068L;
	private Integer category_id;
	private String category_name;
	private Integer pid;
	private GoodsType type;
}
