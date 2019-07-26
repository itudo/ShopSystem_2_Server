package com.yc.web.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yc.bean.Address;
import com.yc.bean.Goods;
import com.yc.bean.OrderDetail;
import com.yc.bean.Orders;
import com.yc.bean.Review;
import com.yc.bean.Users;
import com.yc.biz.OrderBiz;
import com.yc.biz.ReviewBiz;
import com.yc.biz.UsersBiz;
import com.yc.fileupload.UploadFile;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;

@Slf4j
@RestController
public class ReviewController {
	@Resource(name="orderBizImpl")
	private OrderBiz orderBiz;
	
	@Resource(name="reviewBizImpl")
	private ReviewBiz reviewBiz;
	
	@Resource(name="uploadFileService")
	private UploadFile uf;
	
	
	@RequestMapping("insertReview.action")
	public JsonModel addReview(Users user,HttpSession session,OrderDetail orderDetail,@RequestParam("file") MultipartFile file, @RequestParam(name = "level") String review_level,@RequestParam(name="context") String review_content,HttpServletRequest request) {
		JsonModel jsonModel  = new JsonModel();
		//Users user = (Users) session.getAttribute("user");
		Review review = new Review();
		String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        String filePath = request.getSession().getServletContext().getRealPath("imgReview/");
        try {
			review.setOrderDetail(orderDetail);
			review.setUsers(user);
			review.setReview_level(Float.parseFloat(review_level));
			review.setReview_content(review_content);
			review.setReview_image(fileName);
			log.info("review{}",review);
			reviewBiz.insertReview(review);
			
            uf.uploadFile(file.getBytes(), filePath, fileName);
            jsonModel.setCode(1);
        } catch (Exception e) {
        	e.printStackTrace();
		   jsonModel.setCode(0);
        }
		
		return jsonModel;
	}
	
	@RequestMapping("myRiview.action")
	public JsonModel MyRiview(HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users user = (Users) session.getAttribute("user");
		try {
			List<Review> list = reviewBiz.getMyReview(user);
			jsonModel.setCode(1);
			jsonModel.setObj(list);
			log.info("ReviewList{}",list);
		} catch (Exception e) {
			jsonModel.setCode(0);
			e.printStackTrace();
		}
		return jsonModel;
	}
	
	@RequestMapping("delReview.action")
	public JsonModel delReview(Review review) {
		JsonModel jsonModel = new JsonModel();
		reviewBiz.delReview(review);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@RequestMapping(value={"reviewList.action"})
	public JsonModel reviewList(@RequestParam(name="goods_id") int goods_id) {
		JsonModel jsonModel = new JsonModel();
		Goods goods = new Goods();
		goods.setGoods_id(goods_id);
		List<Review> reviewList = reviewBiz.getReviewByGoods(goods);
		jsonModel.setObj(reviewList);
		jsonModel.setCode(1);
		return jsonModel;
	}
}