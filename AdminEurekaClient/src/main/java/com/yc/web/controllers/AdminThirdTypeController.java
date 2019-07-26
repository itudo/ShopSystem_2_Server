package com.yc.web.controllers;
  

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.bean.ThirdType;
import com.yc.biz.FirstTypeBiz;
import com.yc.biz.SecondTypeBiz;
import com.yc.biz.ThirdTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
public class AdminThirdTypeController {
	
	@Autowired
	private ThirdTypeBiz thirdTypeBiz ;

	
	@RequestMapping("/admin/getThirdTypeBySecondId.action")
	@ResponseBody
	public JsonModel<ThirdType> getSecondTypeList( Integer secondtype_id){
		List<ThirdType>  list = thirdTypeBiz.findThirdTypeBySecondTypeId(secondtype_id);
		JsonModel<ThirdType > jmJsonModel   = new JsonModel<>();
		jmJsonModel.setCode(1);
		jmJsonModel.setObj(list);
		return jmJsonModel;
	}
	 
}
 