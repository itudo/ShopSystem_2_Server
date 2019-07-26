package com.yc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class GoodsType implements Serializable{
	private static final long serialVersionUID = -4640677101915290308L;
	private Integer type_id;
	private String type_name;
}
