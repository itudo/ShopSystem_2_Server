package com.yc.biz.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.dao.BaseDao;

@Service
public class AdminBizImpl implements AdminBiz {
	@Autowired
	private BaseDao basedao;

	@Override
	public Admin isAdminExists(String admin_name,String admin_password) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("admin_name", admin_name);
		map.put("admin_password", admin_password);
		return (Admin) basedao.findOne(Admin.class, "isAdminExists", map);
	}

}
