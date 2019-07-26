package com.yc.biz;

import java.util.Map;

import com.yc.bean.Admin;

public interface AdminBiz {
	
	public Admin isAdminExists(String admin_name,String admin_password);

}
