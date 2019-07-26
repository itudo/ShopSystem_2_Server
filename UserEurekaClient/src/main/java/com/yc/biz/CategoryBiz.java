package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Category;
import com.yc.bean.Goods;
import com.yc.bean.GoodsType;

public interface CategoryBiz {
	
	
	/**
	 * 查询所有的三级分类
	 * @return
	 */
	public  List<Goods>  findGoodsBycategoryId(Integer category_id);
	
	/**
	 * 查询所有的三级分类
	 * @return
	 */
	public  List<Category>  findAllSecondAndThird();
	
	/**
	 * 查询所有的三级分类
	 * @return
	 */
	public  List<Category>  findAllThirdCategory();
	/**
	 * 查询所有的分类
	 * @return
	 */
	public  List<Category>  findAllCategory();
	
	
	/**
	 * 通过category id  查找分类
	 * @param categoryid
	 * @return
	 */
	public   Category   findCategoryById(Integer  categoryid);
	
	/**
	 * 通过pid 查找分类
	 * @param pid
	 * @return
	 */
	public List<Category> findCategoryByPid(Integer  pid);
	/**
	 * 找到一二三级类
	 * @return
	 */
	public Map<String,Map<String,List>> getCategoryAndType();
	/**
	 * 找到所有的二级类的ID（去重后的）
	 * @param pid
	 * @return
	 */
	public List<GoodsType> findTypeByPid(Integer pid);
	
	public List<Category> findCategoryByTypeId(Integer type_id);
}
