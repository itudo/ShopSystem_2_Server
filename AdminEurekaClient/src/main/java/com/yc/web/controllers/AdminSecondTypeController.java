package com.yc.web.controllers;
  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.biz.FirstTypeBiz;
import com.yc.biz.SecondTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
public class AdminSecondTypeController {
	
	@Autowired
	private SecondTypeBiz SecondTypeBiz ;

	
	@RequestMapping("/admin/getSecondType.action")
	@ResponseBody
	public JsonModel<SecondType> getSecondTypeList( Integer firsttype_id){
		List<SecondType>  list = SecondTypeBiz.findSecondTypeByFirstTypeId(firsttype_id);
		JsonModel<SecondType > jmJsonModel   = new JsonModel<>();
		jmJsonModel.setCode(1);
		jmJsonModel.setObj(list);
		return jmJsonModel;
	}
	 
}
 