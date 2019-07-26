package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
@Data
public class Cart implements Serializable {
	
	private static final long serialVersionUID = -2960105512000790976L;
	private Integer cart_id;
	private Users user;
	
	
	
	private List<CartDetail> cartDetail;
	 
}