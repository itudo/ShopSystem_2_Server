package com.yc.biz;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.yc.bean.FirstType;
import com.yc.bean.SecondType;
import com.yc.bean.ThirdType;

/**
 * 
 * @author adeline
 * @date 2018年8月27日
 * @TODO
 */
@Repository
public interface ThirdTypeBiz {
	
	/**
	 * 查找所有三级表
	 * @return
	 */
	public List<ThirdType>  findAllThirdType();
	
	
	/**
	 * 根据id查找二级表
	 * @param typeid
	 * @return
	 */
	public  ThirdType  findThirdTypeById(Integer  thirdtype_id);
	
	/**
	 * 通过二级id查找
	 * @Description
	 */
	public List<ThirdType>  findThirdTypeBySecondTypeId(Integer secondtype_id);
	
	/**
	 * 添加二级表信息
	 * @Description
	 */
	public int addThirdtype(ThirdType thirdType);
	
	/**
	 * 根据id删除二级表
	 * @Description
	 */
	public int  delThirdType(Integer thirdtype_id);
	
	/**
	 * 根据id更新二级表
	 * @Description
	 */
	public int updateThirdType(ThirdType thirdType);
	
	 
}
