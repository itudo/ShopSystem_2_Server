package com.yc.biz;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yc.bean.Attribute;

@Repository
public interface AttributeBiz {
	
	/**
	 * 添加属性
	 * @Description
	 */
	public  int addAttrinbute(Attribute attribute);
	
	/**
	 * 查所有的属性
	 * @Description
	 */
	public  List<Attribute>  getAllAttribute();
	
	/**
	 * 通过二级表查找对应属性
	 * @Description
	 */
	public List<Attribute>  getAttributeBySecondType(Integer secondtype_id);
	
	/**
	 * 通过id查找属性
	 * @Description
	 */
	public  Attribute  getAttributeById(Integer  attribute_id);
	
	/**
	 * 通过pid查找属性
	 * @Description
	 */
	public  List<Attribute>  getAttributeValueByPid(Integer attribute_id);
	
	/**
	 * 更新属性信息
	 * @Description
	 */
	public  int updateAttribute(Attribute  attribute);
	 
	/**
	 * 删除属性
	 * @Description
	 */
	public  int delAttribute(Integer  attribute_id);
}
