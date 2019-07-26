package com.yc.biz;

import java.util.List;

import com.yc.bean.Attrvalue;

public interface AttrvalueBiz {
	
	/**
	 * 通过pid查找属性值
	 * @Description
	 */
	public List<Attrvalue>  getAttrvalueByPid(Integer pid );
	 

}
