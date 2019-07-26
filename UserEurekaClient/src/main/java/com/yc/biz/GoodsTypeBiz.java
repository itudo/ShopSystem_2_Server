package com.yc.biz;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.yc.bean.GoodsType;

@Repository
public interface GoodsTypeBiz {
	
	/**
	 * 查找所有的商品类型
	 * @return
	 */
	public List<GoodsType>  findAllGoodsType();
	
	
	/**
	 * 根据id查找所有的商品类别
	 * @param typeid
	 * @return
	 */
	public  GoodsType  findGoodsTypeById(Integer  typeid);

}
