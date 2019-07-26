package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class FirstType implements Serializable {
	private static final long serialVersionUID = 2166401252104783841L;
	private Integer firsttype_id;
	private String firsttype_name;
	private List<SecondType> secondType;
}
