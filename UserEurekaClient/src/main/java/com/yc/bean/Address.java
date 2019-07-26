package com.yc.bean;

import java.io.Serializable;

import lombok.Data;

@Data
	public class Address implements Serializable {
		private Integer address_id;
		private String address_name;
		private String address_code;
		private Integer address_status;
		private String address_tel;
		private String address_user;
		private Users user;
}
