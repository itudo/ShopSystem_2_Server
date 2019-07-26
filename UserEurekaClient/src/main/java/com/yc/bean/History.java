package com.yc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class History implements Serializable{
	private static final long serialVersionUID = -7609804589936282365L;
	private Integer history_id;
	private String history_name;
	private User user;
}
