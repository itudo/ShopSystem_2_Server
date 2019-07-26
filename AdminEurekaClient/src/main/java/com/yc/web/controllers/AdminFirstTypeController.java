package com.yc.web.controllers;
  

import java.util.List;

import javax.swing.JMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.biz.FirstTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
public class AdminFirstTypeController {
	
	@Autowired
	private FirstTypeBiz firstTypeBiz;

	@RequestMapping("/admin/getAllFirstType.action")
	@ResponseBody
	public JsonModel<FirstType> getGoodsByType( ){
		List<FirstType>  list = firstTypeBiz.findAllFirstType();
		JsonModel< FirstType>  jsonModel = new JsonModel<FirstType>(); 
		jsonModel.setCode(1);
		jsonModel.setRows(list);
		return jsonModel;
	}
	
	@RequestMapping("/admin/getSecondTypeList.action")
	@ResponseBody
	public JsonModel<FirstType> getSecondTypeList( Integer firsttype_id){
		List<FirstType>  list = firstTypeBiz.findSecondTypeByFirstTypeId(firsttype_id);
		JsonModel<FirstType > jmJsonModel   = new JsonModel<>();
		jmJsonModel.setCode(1);
		jmJsonModel.setObj(list);
		return jmJsonModel;
	}
	 
	 
}
 