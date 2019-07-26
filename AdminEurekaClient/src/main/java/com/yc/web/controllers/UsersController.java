package com.yc.web.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;

@RestController
//@Scope(value="prototype")
@Slf4j
public class UsersController {
	@Resource(name="usersBizImpl")
	private UsersBiz usersBiz;

	@RequestMapping("checkCode.action")
	public JsonModel checkCode(@RequestParam(name = "code")String code,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		String rand = (String) session.getAttribute("rand");
		if(rand.trim().equals(code.trim())) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("checkName.action")
	public JsonModel checkName(Users user) {
		JsonModel jsonModel = new JsonModel();
		if(usersBiz.namevaliate(user)) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("userReg.action")
	public JsonModel reg(Users user) {
		JsonModel jsonModel = new JsonModel();
		if(usersBiz.telvaliate(user)) {
			jsonModel.setCode(1);
		} else if(usersBiz.emailvaliate(user)) {
			jsonModel.setCode(2);
		} else if(usersBiz.register(user)==0) {
			jsonModel.setCode(3);
		} else {
			jsonModel.setCode(4);
		}
		return jsonModel;
	}
	
	@RequestMapping("login.action")
	public JsonModel login(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users user1 = usersBiz.nameLogin(user);
		Users user2 = usersBiz.telLogin(user);
		Users user3 = usersBiz.emailLogin(user);
		if(user1!=null ) {
			jsonModel.setCode(1);
			session.setAttribute("user", user1);
		} else if(user2!=null ) {
			jsonModel.setCode(1);
			session.setAttribute("user", user2);
		}  else if(user3!=null ) {
			jsonModel.setCode(1);
			session.setAttribute("user", user3);
		}  else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("loginUser.action")
	public JsonModel loginUser(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users user1 = (Users) session.getAttribute("user");
		if(user1!=null) {
			jsonModel.setCode(1);
			jsonModel.setObj(user1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("logout.action")
	public JsonModel logout(HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		session.removeAttribute("user");
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@RequestMapping("admin/selectAllUser.action")
	public PageBean selectAllUser() {
		PageBean pageBean = new PageBean();
		Map<String, Object> map = new HashMap<String,Object>();
		pageBean = usersBiz.selectAllUser(map);
		pageBean.setCode(1);
		return pageBean;
	}
}
