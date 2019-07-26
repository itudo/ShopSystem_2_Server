package com.yc.web.listeners;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.yc.bean.FirstType;
import com.yc.biz.FirstTypeBiz;


@Component
@Slf4j
public class InitListener implements ServletContextListener {

	private ApplicationContext context;

	public InitListener() {
		log.info("监听器启动！！！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@EventListener
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// 取application
		ServletContext application = sce.getServletContext();
		context = WebApplicationContextUtils.getWebApplicationContext(application);
		FirstTypeBiz goodsTypeBiz = (FirstTypeBiz) context.getBean("firstTypeBizImpl");
        List<FirstType> firstTypelist = goodsTypeBiz.findAll();
        log.info("{}",firstTypelist);
        application.setAttribute("firstTypelist", firstTypelist);
	}

}
