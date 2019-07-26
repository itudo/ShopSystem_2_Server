package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class Attribute implements Serializable {
	private static final long serialVersionUID = 7373892511325501333L;
	private Integer attribute_id;
	private String attribute_name;
	private Integer pid;
	private SecondType secondType;
}
