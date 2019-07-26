package com.yc.web.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.Admin;
import com.yc.biz.AdminBiz;
import com.yc.model.Encrypt;

 

@Controller
//@Scope(value="prototype")
public class IndexController {
	@Autowired
	private AdminBiz adminBiz;
	 

	@RequestMapping("/admin/index.action")
	public String index(String admin_name, String admin_password,
			HttpSession session, HttpServletResponse resp) throws IOException {
		String password = Encrypt.md5(Encrypt.md5(admin_password));
		Admin admin = adminBiz.isAdminExists(admin_name, password);
		PrintWriter out=resp.getWriter();
		if(admin!=null) {
			//取session
			session.setAttribute("admin", admin);
		}else {
			out.println("<script>alert('用户名或密码错误');location.href='http://localhost:8763/admin/admin.htm';</script>");
			out.flush();
		}
		return "/admin/index";
	}
	 
}
