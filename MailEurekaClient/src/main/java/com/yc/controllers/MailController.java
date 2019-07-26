package com.yc.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.freemaker.DataBaseBiz;
import com.yc.freemaker.DataBaseBizImpl;
import com.yc.freemaker.FreeMarkerService;
import com.yc.mail.SendMailService;
import com.yc.mail.SendMailServiceImpl;

@RestController
public class MailController {
	
	@Resource(name="sendMailServiceImpl")
	private SendMailService sms;
	
	@Resource(name="dataBaseBizImpl")
	private DataBaseBiz dataBaseBiz;
	
	@Resource(name="freeMarkerServiceImpl")
	private FreeMarkerService fms;
	
	@RequestMapping("sendEmailtoReg.action")
    public boolean send(int code,String email){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("code", code);
		map.put("email", email);
		fms.getHtml(map,"mailTemp.html", "mail.html");
		String sys = System.getProperty("user.dir");
		String path = sys+"\\freeMarker\\mail.html";
		String html = dataBaseBiz.readFile(path);
		sms.sendHtmlMail("欢迎使用轻松购",html,email);
		return true;
    }
	
}
