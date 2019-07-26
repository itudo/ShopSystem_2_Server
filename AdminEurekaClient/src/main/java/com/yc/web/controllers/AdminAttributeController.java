package com.yc.web.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.Attribute;
import com.yc.bean.Attrvalue;
import com.yc.bean.GoodsDetail;
import com.yc.bean.ThirdType;
import com.yc.biz.AttributeBiz;
import com.yc.biz.AttrvalueBiz;
import com.yc.biz.FirstTypeBiz;
import com.yc.biz.ThirdTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
@Slf4j
public class AdminAttributeController {

	@Autowired
	private AttributeBiz attributeBiz;

	@Autowired
	private AttrvalueBiz attrvalueBiz;

	@Autowired
	private FirstTypeBiz categoryBiz;
	
	@Autowired
	private ThirdTypeBiz  thirdtypeBiz;

	@RequestMapping(value = "/admin/getAllAttribute.action")
	@ResponseBody
	public PageBean<Attribute> getAllAttribute(Integer page, Integer rows,
			String order, String sort) {
		List<Attribute> attributeList = attributeBiz.getAllAttribute();
		Map<String, Object> map = PageBeanUtils.setMap(page, rows, sort, order);
		PageBean<Attribute> pageBean = PageBeanUtils.setPageBean(page, rows,
				sort, order, attributeList);
		return pageBean;
	}

	@RequestMapping(value = "/admin/getAttrvalue.action")
	@ResponseBody
	public PageBean<Attrvalue> getAttrvalue(Integer page, Integer rows,
			String order, String sort, Integer attribute_id) {
		List<Attrvalue> attrvalueList = attrvalueBiz
				.getAttrvalueByPid(attribute_id);
		Map<String, Object> map = PageBeanUtils.setMap(page, rows, sort, order);
		PageBean<Attrvalue> pageBean = PageBeanUtils.setPageBean(page, rows,
				sort, order, attrvalueList);
		return pageBean;

	}

	@RequestMapping("admin/getAttributeBySecondType.action")
	@ResponseBody
	public JsonModel<Attribute> getAttributeBySecondType(Integer secondtype_id) {
		List<Attribute> attributeList = attributeBiz
				.getAttributeBySecondType(secondtype_id);
		JsonModel<Attribute> jsonModel = new JsonModel<>();
		jsonModel.setCode(1);
		jsonModel.setRows(attributeList);
		return jsonModel;

	}

	/**
	 * 三级分类查找二级分类 二级分类查找属性
	 * 
	 * @param type_id
	 * @return
	 */
	@RequestMapping("/admin/getAttributeList.action")
	@ResponseBody
	public JsonModel<Attribute> getAttributeList(Integer thirdtype_id) {
		JsonModel<Attribute>  jsonModel = new JsonModel<Attribute>();
		if(thirdtype_id!=-1) {
		
		// 查找对应的属性列表
		ThirdType thirdType = thirdtypeBiz.findThirdTypeById(thirdtype_id);
		List<Attribute> attributesList = attributeBiz
				.getAttributeBySecondType(thirdType.getSecondType()
						.getSecondtype_id());
		jsonModel.setCode(1);
		jsonModel.setObj(attributesList);
		}
		return jsonModel;
	}

}
