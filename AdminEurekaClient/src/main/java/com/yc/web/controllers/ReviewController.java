package com.yc.web.controllers;


import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yc.biz.ReviewBiz;
import com.yc.model.PageBean;
@RestController
public class ReviewController {
	
	@Resource(name="reviewBizImpl")
	private ReviewBiz reviewBiz;
	
	@Resource(name="pageBean")
	private PageBean pageBean;
	
	@RequestMapping(value={"admin/selectReview.action"})
	public PageBean selectReview(@RequestParam(name="sort") String sort,
			@RequestParam(name="order") String order) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("orderby", sort);
		map.put("orderway", order);
		pageBean = reviewBiz.getAllReview(map);
		pageBean.setCode(1);
		return pageBean;
	}
	
}
