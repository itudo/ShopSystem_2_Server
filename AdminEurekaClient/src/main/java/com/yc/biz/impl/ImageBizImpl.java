package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Image;
import com.yc.biz.ImageBiz;
import com.yc.dao.BaseDao;

@Service
@Slf4j
public class ImageBizImpl implements ImageBiz {
	@Autowired
	private BaseDao basedao;

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int addImage(Image image) {
		return basedao.save(image, "addImage");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public List<Image> findAllImage() {
		return basedao.findAll(ImageBiz.class, "findAllImage");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public ImageBiz findImageById(Integer image_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("image_id", image_id);
		return (ImageBiz) basedao.findOne(Image.class, "findImageById", map);
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = true)
	@Override
	public boolean findImageByGoodsdetailId(Integer goodsdetail_id) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("goodsdetail_id", goodsdetail_id);
		List<Image> list = (List<Image>) basedao.findAll(Image.class,
				"findImageByGoodsdetailId", map);
		log.info("list:{}", map);
		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int updateImage(Image image) {
		return basedao.update(image, "updateImage");
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int delImage(Integer image_id) {
		return basedao.del(Image.class, image_id + "", "delImage");
	}

}
