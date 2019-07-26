package com.yc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
public class ThirdType implements Serializable {
	private static final long serialVersionUID = 5403207451861880665L;
	private Integer thirdtype_id;
	private String 	thirdtype_name;
	private SecondType secondType;
}
