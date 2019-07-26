package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.Data;
@Data
@Component
public class Attribute implements Serializable {
	private static final long serialVersionUID = 7373892511325501333L;
	private Integer attribute_id;
	private String attribute_name;
	private Integer pid;
	private SecondType secondType;
	private List<Attrvalue>  attrvalue ;
	
}
