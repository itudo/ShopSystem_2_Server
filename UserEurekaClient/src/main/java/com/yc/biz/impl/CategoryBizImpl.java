package com.yc.biz.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Category;
import com.yc.bean.Goods;
import com.yc.bean.GoodsType;
import com.yc.biz.CategoryBiz;
import com.yc.dao.BaseDao;

@Service
@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)
public class CategoryBizImpl  implements  CategoryBiz{
	
	@Autowired
	private BaseDao  baseDao ;

	
	@Override
	public List<Goods> findGoodsBycategoryId(Integer category_id) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("category_id", category_id);
		return baseDao.findAll(Category.class, "findGoodsBycategoryId", map);
		
	}
	
	
	@Override
	/**
	 * 查所有的二级类和三级类
	 */
	public List<Category> findAllSecondAndThird() {
		return baseDao.findAll(Category.class, "findAllSecondAndThird");
	}
	
	@Override
	/**
	 * 查所有的三级类
	 */
	public List<Category> findAllThirdCategory() {
		return baseDao.findAll(Category.class, "findAllThirdCategory");
	}
	/**
	 * 查所有的一级类和三级类
	 */
	public List<Category> findAllCategory() {
		return baseDao.findAll(Category.class, "findAllCategory");
	}
	@Override
	/**
	 * 根据categoryid查类
	 */
	public  Category  findCategoryById(Integer categoryid) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("category_id", categoryid);
		return (Category) baseDao.findOne(Category.class, "findCategoryById", map);
	}

	@Override
	/**
	 * 根据pid查类
	 */
	public List<Category> findCategoryByPid(Integer pid) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("category_id", pid);
		return baseDao.findAll(Category.class, "findCategoryByPid", map);
	}
	
	@Override
	/**
	 * 根据pid查所欲的二级类
	 */
	public List<GoodsType> findTypeByPid(Integer pid) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("category_id", pid);
		return baseDao.findAll(Category.class, "findTypeByPid", map);
	}
	
	@Override
	/**
	 * 根据二级类的ID查三级类
	 */
	public List<Category> findCategoryByTypeId(Integer type_id) {
		Map<String, Object>  map = new HashMap<String, Object>();
		map.put("type_id", type_id);
		return baseDao.findAll(Category.class, "findCategoryByTypeId", map);
	}
	@Override
	public Map<String, Map<String, List>> getCategoryAndType() {
		Map<String,Map<String,List>> map = new LinkedHashMap<String,Map<String,List>>();
		List<Category> firstList = findCategoryByPid(0);
		//System.out.println("111"+firstList);
		for(Category first:firstList){
			String categoryName = first.getCategory_name();
			List<GoodsType> secondList = findTypeByPid(first.getCategory_id());
			//System.out.println("222"+secondList);
			Map<String,List> map1 = new LinkedHashMap<String,List>();
			for(GoodsType second:secondList){
				String typeName = second.getType_name();
				List<Category> thirdList = findCategoryByTypeId(second.getType_id());
				//System.out.println("333"+thirdList);
				map1.put(typeName,thirdList );
			}
			map.put(categoryName, map1);
		}
		
		return map;
	}


}
