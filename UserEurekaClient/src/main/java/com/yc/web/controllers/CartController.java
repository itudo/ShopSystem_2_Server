package com.yc.web.controllers;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.yc.bean.Cart;
import com.yc.bean.CartDetail;
import com.yc.bean.Category;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Users;
import com.yc.biz.CartBiz;
import com.yc.biz.CategoryBiz;
import com.yc.biz.GoodsDetailBiz;
import com.yc.model.JsonModel;
@RestController
@Slf4j
public class CartController {

	@Resource(name="cartBizImpl")
	private CartBiz cartBiz;
	
	@Resource(name="goodsDetailBizImpl")
	private GoodsDetailBiz goodsDetailBiz;
	
	@RequestMapping(value="getCart.action")
	public JsonModel findCategoryType(HttpSession session,Users user){
		JsonModel jsonModel = new JsonModel();
		Users users = (Users) session.getAttribute("user");
		System.out.println(users);
		List<CartDetail> cart = cartBiz.getCart(user);
		if(cart==null) {
			jsonModel.setCode(0);
		} else {
			jsonModel.setCode(1);
			session.setAttribute("cartList", cart);
			log.info("cartList{}",cart);
			jsonModel.setObj(cart);
		}
		System.out.println(jsonModel.getObj());
		return jsonModel;
	}
	
	@RequestMapping(value="delCartDetail.action")
	public JsonModel delCartDetail(CartDetail cartDetail){
		JsonModel jsonModel = new JsonModel();
		cartBiz.deleteCartDetail(cartDetail);
		jsonModel.setCode(1);
		return jsonModel;
		
	}
	
	@RequestMapping(value="addCart.action")
	@ResponseBody
	public JsonModel addCart(GoodsDetail goodsDetail,HttpSession session,Users user){
		JsonModel jsonModel = new JsonModel();
		log.info("goodsDetail{}",goodsDetail);
		//Users user = (Users)session.getAttribute("user");
		if(user!=null ){
			if(goodsDetail.getGoodsdetail_price()==0) {
				goodsDetail = goodsDetailBiz.findGoodsDetailById(goodsDetail);
				goodsDetail.setGoods_count(1);
			} 
			cartBiz.addCartDetail(user, goodsDetail);
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping(value="updateCartDetailCount.action")
	@ResponseBody
	public JsonModel updateCartDetailCount(CartDetail cartDetail){
		JsonModel jsonModel = new JsonModel();
		log.info("cartDetail{}",cartDetail);
		if(cartBiz.updateCartDetailcount(cartDetail)) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		
		return jsonModel;
		
	}
}
