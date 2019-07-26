package com.yc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class Review implements Serializable {
	
	private static final long serialVersionUID = -4669937382752000483L;
	private Integer review_id;
	private Float review_level;
	private String review_content;
	private String review_image;
	private String review_date;
	private String review_goods;
	private String review_user;
	private Users users;
	private OrderDetail orderDetail;
}
