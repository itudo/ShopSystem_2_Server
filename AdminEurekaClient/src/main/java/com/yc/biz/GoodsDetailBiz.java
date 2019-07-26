package com.yc.biz;

import java.util.List;

import com.yc.bean.Goods;
import com.yc.bean.GoodsDetail;

/**
 * 
 * @author adeline
 * @date 2018年8月28日
 * @TODO
 */
public interface GoodsDetailBiz {
	
	/**
	 * 添加商品信息详情
	 * @Description
	 */
	public int addGoodsDetail(GoodsDetail goodsDetail);
	
	/**
	 * 更新商品详情
	 * @Description
	 */
	public int updateGoodsDetail(GoodsDetail goodsDetail);
	
	/**
	 * 通过goodsid查找商品详情
	 * @Description
	 */
	public List<GoodsDetail>  findGoodsDetailByGoodsId(Integer  goods_id);
	
	/**
	 * 根据id删除商品详情
	 * @Description
	 */
	public int  delGoodsDetail(Integer goodsdetail_id);

	/**
	 * 通过id查找详情
	 * @Description
	 */
	public GoodsDetail findGoodsDetailById(Integer goodsdetail_id);
}
