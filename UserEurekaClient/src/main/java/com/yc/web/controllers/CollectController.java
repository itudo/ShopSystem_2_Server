package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.yc.bean.Goods;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Users;
import com.yc.biz.GoodsBiz;
import com.yc.biz.GoodsDetailBiz;
import com.yc.biz.impl.RedisService;
import com.yc.model.JsonModel;
@Slf4j
@Controller
public class CollectController {

	@Autowired
	private RedisService redisService;

	@Autowired
	private GoodsBiz goodsBiz;
	
	@Resource(name="goodsDetailBizImpl")
	private GoodsDetailBiz goodsDetailBiz;

	/**
	 * 添加收藏
	 * @Description
	 */
	@RequestMapping("addCollect.action")
	@ResponseBody
	public JsonModel setCollectGoods(Users users,Integer goods_id, HttpSession session) {
		//Users users = (Users) session.getAttribute("user");
		JsonModel jsonModel = new JsonModel();
		if (users != null && !users.equals("")) {
			redisService.sAdd(users.getUser_id()+"", goods_id);
			jsonModel.setCode(1);
		}
		return jsonModel;
	}

	 
	/**
	 * 获取收藏列表
	 * @Description
	 */
	@RequestMapping("getCollect.action")
	@ResponseBody
	public JsonModel getCollectGoods(Users users,HttpSession session) {

		//Users users = (Users) session.getAttribute("user");
		JsonModel jsonModel = new JsonModel();

		List<Goods> list = new ArrayList<Goods>();
		if (users != null && !users.equals("")) {
			Set<Integer> set = redisService.sGet(users.getUser_id()+"");
			for (Integer goods_id : set) {
				Goods goods = goodsBiz.getGoodsById(goods_id);
				list.add(goods);
			}
			
		}
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		log.info("list{}",list);
		return jsonModel;
	}

	/**
	 * 删除收藏
	 * @Description
	 */
	@RequestMapping("delCollect.action")
	@ResponseBody
	public JsonModel delCollectGoods(String goodsdetail_id, HttpSession session) {
		Users users = (Users) session.getAttribute("user");
		JsonModel jsonModel = new JsonModel();
		if (users != null && !users.equals("")) {
			long resilt = redisService.setRemove(users.getUser_name(),goodsdetail_id);
			if (resilt > 0) {
				jsonModel.setCode(1);
			}
		}
		return jsonModel;
	}

}
