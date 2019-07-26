/*package com.yc.web.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Goods;
import com.yc.biz.FirstTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
public class AdminCategoryController {

	@Autowired
	private FirstTypeBiz categoryBiz;
	
	@RequestMapping(value="/admin/getCategoryByPid",method = RequestMethod.GET)
	@ResponseBody
	public  JsonModel<Category>  getCategoryByPid(Integer pid){
		List<Category> categoryList =  categoryBiz.findCategoryByPid(pid);
		JsonModel<Category > jModel = new JsonModel<Category>();
		jModel.setCode(1);
		jModel.setObj(categoryList);
		
		return jModel;
	}
	 

	@RequestMapping("/admin/getAllCategory")
	@ResponseBody
	public PageBean<Category> getAllCategory(Integer page, Integer rows,
			String sort, String order) {
		List<Category> rowsList = categoryBiz.findAllCategory();
		PageBean<Category> pageBean = new PageBean<Category>();
		pageBean = PageBeanUtils.setPageBean(page, rows, sort, order, rowsList);
		return pageBean;
	}

	@RequestMapping("/admin/getThirdCategory")
	@ResponseBody
	public PageBean<Category> getThirdCategory(Integer page, Integer rows,
			String sort, String order,Integer pid){
		List<Category> list = categoryBiz.findCategoryByPid(pid);
		PageBean<Category>  pageBean = PageBeanUtils.setPageBean(page, rows, sort, order, list);
		return pageBean;
	}
}
*/