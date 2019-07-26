package com.yc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class Attrvalue implements Serializable {
	private static final long serialVersionUID = 5957906081637871784L;
	private Integer attrvalue_id;
	private String attrvalue_value;
	private Integer attribute_id;
	private Goods goods;
}
