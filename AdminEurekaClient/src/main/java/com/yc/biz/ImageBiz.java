package com.yc.biz;

import java.util.List;

import com.yc.bean.Image;

public interface ImageBiz {

	/**
	 * 添加图片信息
	 * 
	 * @Description
	 */
	public int addImage(Image image);

	/**
	 * 查找所有的图片
	 * 
	 * @Description
	 */
	public List<Image > findAllImage();

	/**
	 * 通过id查找图片信息
	 * 
	 * @Description
	 */
	public ImageBiz findImageById(Integer image_id);

	/**
	 * 通过商品详情id查找图片信息
	 * 
	 * @Description
	 */
	public  boolean   findImageByGoodsdetailId(Integer goodsdetail_id);

	/**
	 * 更新图片信息
	 * 
	 * @Description
	 */
	public int updateImage(Image image);

	/**
	 * 通过id删除图片信息
	 * 
	 * @Description
	 */
	public int delImage(Integer image_id);

}
