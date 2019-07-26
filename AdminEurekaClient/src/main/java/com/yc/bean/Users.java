package com.yc.bean;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Users implements Serializable{
	private static final long serialVersionUID = 7072805719866647848L;
	private Integer user_id;   
	private String user_name;
	private String user_pwd;
	private String user_sex;

	private String user_tel;
	private String user_email;
	private String user_addr;
	private String user_idcard;
	private String user_level;
	
	private List<Address> adress;
	
	private String code;
	
	private String name;
	
	private String user_head;
	
}
