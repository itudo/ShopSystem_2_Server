package com.yc.biz;

import java.util.List;
import java.util.Map;

import com.yc.bean.Goods;
import com.yc.model.PageBean;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * 商品类
 * @author adeline
 * @date 2018年8月28日
 * @TODO
 */
public interface GoodsBiz {
	
	/**
	 * 添加商品
	 * @Description
	 */
	public int addGoods (Goods goods);
	
	/**
	 * 更新商品信息
	 * @Description
	 */
	public int updateGoods(Goods  goods);
	 

	/**
	 * 查新所有的商品信息
	 * @Description
	 */
	public List<Goods>  findAllGoods();

	/**
	 * 根据条件查询商品
	 * @Description
	 */
	public PageBean<Goods> findGoodsByCondition(Map<String, Object> map);
	
	/**
	 * 根据商品id查商品信息
	 * @Description
	 */
	public Goods  getGoodsById(Integer goods_id);

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	List<Goods> findGoodsList(Map<String, Object> map);

	/**
	 * 查条件查询的数量
	 * @Description
	 */
	public Integer  findGoodsConditionCount(Map<String, Object> map);
	
	/**
	 * 根据商品id删除商品
	 * @Description
	 */
	public boolean delSingleGoods(Integer goods_id);
	
	/**
	 * 批量删除商品信息
	 * @Description
	 */
	public boolean delManyGoods(List<Goods> goods) ;
}
