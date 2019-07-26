package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JMenu;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.Attribute;
import com.yc.bean.FirstType;
import com.yc.bean.Goods;
import com.yc.bean.ThirdType;
import com.yc.biz.AttributeBiz;
import com.yc.biz.FirstTypeBiz;
import com.yc.biz.GoodsBiz;
import com.yc.biz.SecondTypeBiz;
import com.yc.biz.ThirdTypeBiz;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;

@Controller
@Slf4j
public class AdminGoodsController {

	@Autowired
	private GoodsBiz goodsBiz;

	@Autowired
	private FirstTypeBiz firsttypeBiz;
	@Autowired
	private SecondTypeBiz  secondtypeBiz;

	@Autowired
	private AttributeBiz attributeBiz;
	@Autowired
	private ThirdTypeBiz  thirdtypeBiz;

	@RequestMapping("/admin/addGoodsInfo.action")
	@ResponseBody
	public JsonModel<Goods> addGoodsInfo(Goods goods, Integer thirdtype_id ,
			Integer secondtype_id, HttpServletRequest request) {
		ThirdType thirdType = new ThirdType();
		thirdType.setThirdtype_id(thirdtype_id);
		goods.setThirdType(thirdType);
		int result = goodsBiz.addGoods(goods);
		JsonModel<Goods> jsonModel = new JsonModel<Goods>();
		if (result > 0) {
			jsonModel.setCode(goods.getGoods_id());
			jsonModel.setObj(goods);
			jsonModel.setCode(1);

		}
		return jsonModel;

	}

	@PostMapping("/admin/getAllType.action")
	@ResponseBody
	public PageBean<FirstType> getAllType() {
		PageBean<FirstType> pageBean = new PageBean<FirstType>();
		List<FirstType> firstTypeslist = firsttypeBiz.findAll();
		pageBean.setCode(1);
		pageBean.setRows(firstTypeslist);
		return pageBean;
	}

	@RequestMapping(value = "/admin/getGoodsByThirdtype.action")
	@ResponseBody
	public PageBean getGoodsByThirdtype(Integer page, Integer rows,
			String sort, String order, Integer thirdtype_id, HttpSession session) {
		Map<String, Object> map = PageBeanUtils.setMap(page, rows, sort, order);
		map.put("thirdtype_id", thirdtype_id);

		PageBean pageBean = goodsBiz.findGoodsByCondition(map);
		return pageBean;
	}

	@PostMapping("/admin/searchGoods.action")
	@ResponseBody
	public PageBean<Goods> searchGoods(Integer goods_id, Integer goods_sale,
			Integer goods_isnew, String startPubtime, Integer page,
			Integer rows, String sort, String order) {

		Map<String, Object> map = PageBeanUtils.setMap(page, rows, sort, order);
		if (goods_id != null) {
			map.put("goods_id", goods_id);
		}
		if (startPubtime != null && !startPubtime.equals("")) {
			map.put("startPubtime", startPubtime);
		}
		if (goods_sale != null) {
			map.put("goods_sale", goods_sale);
		}
		if (goods_isnew != null) {
			map.put("goods_isnew", goods_isnew);
		}
		PageBean<Goods> pageBean = goodsBiz.findGoodsByCondition(map);

		return pageBean;
	}

	@RequestMapping("/admin/updateGoodsInfo.action")
	@ResponseBody
	public JsonModel<Goods> getGoodsByCategory(Integer goods_id,
			String goods_name, String goods_desc, Integer goods_sale,
			Integer goods_isnew) {
		JsonModel<Goods> jsonModel = new JsonModel<Goods>();
		Goods goods = new Goods(goods_id, goods_name, goods_desc, goods_isnew,
				goods_sale);
		int result = goodsBiz.updateGoods(goods);
		if (result > 0) {
			jsonModel.setCode(1);
		}
		return jsonModel;
	}

	@RequestMapping("/admin/delGoodsInfo.action")
	@ResponseBody
	public JsonModel<Goods> GoodsOrderBySale(String goods_id) {
		Integer id = Integer.parseInt(goods_id);
		boolean result = goodsBiz.delSingleGoods(id);
		JsonModel<Goods> jsonModel = new JsonModel<Goods>();
		if (result) {
			jsonModel.setCode(1);
		}
		return jsonModel;

	}

	@RequestMapping("/admin/goodsOrderBySale.action")
	@ResponseBody
	public PageBean<Goods> goodsOrderBySale(Integer page, Integer rows,
			String sort, String order) {
		Map<String, Object> map = PageBeanUtils.setMap(page, rows, sort, order);
		PageBean<Goods> pageBean = goodsBiz.findGoodsByCondition(map);
		return pageBean;

	}
}
