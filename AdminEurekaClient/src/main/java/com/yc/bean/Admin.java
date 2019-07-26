package com.yc.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class Admin {
	private Integer admin_id;
	private String admin_name;

	private String admin_password;
}
