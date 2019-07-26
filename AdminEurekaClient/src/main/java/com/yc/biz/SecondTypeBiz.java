package com.yc.biz;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;

/**
 * 
 * @author adeline
 * @date 2018年8月27日
 * @TODO
 */
@Repository
public interface SecondTypeBiz {
	
	/**
	 * 查找所有二级表
	 * @return
	 */
	public List<SecondType>  findAllSecondType();
	
	
	/**
	 * 根据id查找二级表
	 * @param typeid
	 * @return
	 */
	public  SecondType  findSecondTypeById(Integer  secondtype_id);
	
	/**
	 * 通过一级表id查找二级列表
	 * @Description
	 */
	public   List<SecondType>  findSecondTypeByFirstTypeId(Integer  firsttype_id);
	
	/**
	 * 添加二级表信息
	 * @Description
	 */
	public int addSecondType(SecondType secondType);
	
	/**
	 * 根据id删除二级表
	 * @Description
	 */
	public int  delSecondType(Integer secondtype_id);
	
	/**
	 * 根据id更新二级表
	 * @Description
	 */
	public int updateSecondType(SecondType secondtype);
	
	/**
	 * 通过二级表id找到 三级表list
	 * @Description
	 */
	public  List<SecondType> findThirdTypeBySecondTypeId(Integer secondtype_id);

}
