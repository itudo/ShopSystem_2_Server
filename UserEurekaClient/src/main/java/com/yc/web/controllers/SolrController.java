package com.yc.web.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.yc.biz.impl.IndustrySMS;
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
import com.yc.biz.impl.SolrService;
import com.yc.model.JsonModel;
@Slf4j
@Controller
public class SolrController {


	@Autowired
	private SolrService solrService;
	
	@Autowired
	private GoodsBiz goodsBiz;
	
	@RequestMapping("search.action")
	public String search(String search,HttpServletRequest request) throws Exception {
		JsonModel jsonModel = new JsonModel();
		List<Goods> list = solrService.querySolr(search);
		List<Goods> goods = new ArrayList<Goods>();
		if(list!=null&&list.size()>0) {
			for(Goods good:list) {
				Goods g = goodsBiz.getGoodsById(2);
				goods.add(g);
			}
			request.setAttribute("goodsList", goods);
		}
		log.info("goods{}",goods);
		return "search";
	}
	
	@RequestMapping("search2.action")
	@ResponseBody
	public JsonModel search2(String search,HttpServletRequest request) throws Exception {
		JsonModel jsonModel = new JsonModel();
		List<Goods> list = solrService.querySolr(search);
		List<Goods> goods = new ArrayList<Goods>();
		if(list!=null&&list.size()>0) {
			for(Goods good:list) {
				Goods g = goodsBiz.getGoodsById(good.getGoods_id());
				g.setGoods_name(g.getGoods_name()+" "+g.getThirdType().getThirdtype_name());
				goods.add(g);
			}
		}
		jsonModel.setCode(1);
		jsonModel.setObj(goods);
		log.info("goods{}",goods);
		return jsonModel;
	}

	@RequestMapping("sendMail.action")
	@ResponseBody
	public JsonModel sendMail(String code,String sendTo) throws Exception {
		JsonModel jsonModel = new JsonModel();
		IndustrySMS.execute(code,sendTo);
		jsonModel.setCode(1);
		return jsonModel;
	}

}
