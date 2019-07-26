package com.yc.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Contact {
	
	private Integer  contact_id ;
	private Attribute attribute;
	private GoodsDetail goodsdetail;

}
