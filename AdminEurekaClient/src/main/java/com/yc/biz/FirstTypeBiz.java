package com.yc.biz;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.yc.bean.FirstType;

/**
 * 
 * @author adeline
 * @date 2018年8月27日
 * @TODO
 */
@Repository
public interface FirstTypeBiz {

	/**
	 * 查询所有的分类
	 * 
	 * @return
	 */
	public List<FirstType> findAll();

	/**
	 * 查找所有一级分类
	 * 
	 * @Description
	 */
	public List<FirstType> findAllFirstType();

	/**
	 * 通过id查找一级分类
	 * 
	 * @Description
	 */
	public FirstType findFirstTypeById(Integer id);

	/**
	 * 添加一级分类
	 * 
	 * @Description
	 */
	public int addFirstType(FirstType firstType);

	/**
	 * 通过一级表id找到 二级表list
	 * 
	 * @Description
	 */
	public List<FirstType> findSecondTypeByFirstTypeId(Integer firsttype_id);

	/**
	 * 根据id删除一级表
	 * 
	 * @Description
	 */
	public int delFirstType(Integer firsttype_id);

	/**
	 * 根据id更新一级表
	 * 
	 * @Description
	 */
	public int updateFirstType(FirstType firsttype);
}
