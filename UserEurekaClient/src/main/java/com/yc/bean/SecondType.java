package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class SecondType implements Serializable {
	private static final long serialVersionUID = -6138543845558466766L;
	private Integer secondtype_id;
	private String 	secondtype_name;
	private FirstType fristType;
	private List<ThirdType> thirdType;
}
