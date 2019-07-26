package com.yc.biz;

import java.util.List;

import com.yc.bean.Contact;

/**
 * 
 * @author adeline
 * @date 2018年9月3日
 * @TODO
 */
public interface ContactBiz {

	/**
	 * 添加关系表信息
	 * 
	 * @Description
	 */
	public int addContact(Contact contact);

	/**
	 * 查询所有的关系
	 * 
	 * @Description
	 */
	public List<Contact> findAllContact();

	/**
	 * 通过关系id查找关系
	 * 
	 * @Description
	 */
	public boolean findContactById(Integer contact_id);

	/**
	 * 通过商品详情id查找 关系   查看关系是否存在
	 * 
	 * @Description
	 */
	public boolean findContactByGoodsDetailId(Integer goodsdetail_id);

	/**
	 * 通过属性id查找对应的关系
	 * @Description
	 */
	public List<Contact> findContactByAttributeId(Integer attribute_id);
	
	/**
	 * 通过id更新关系列表
	 * @Description
	 */
	public int updateContactByGoodsDetailId(Contact contact);
}
