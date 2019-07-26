package com.yc.bean;

import java.io.Serializable;

import lombok.Data;
@Data
public class Hot implements Serializable {
	private static final long serialVersionUID = -4858954883551081573L;
	private Integer hot_id;
	private Goods goods;
}
