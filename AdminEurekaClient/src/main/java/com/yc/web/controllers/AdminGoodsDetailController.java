package com.yc.web.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JMenu;

import lombok.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.sun.mail.handlers.image_gif;
import com.yc.bean.Attribute;
import com.yc.bean.Attrvalue;
import com.yc.bean.Contact;
import com.yc.bean.Goods;
import com.yc.bean.GoodsDetail;
import com.yc.bean.Image;
import com.yc.bean.ThirdType;
import com.yc.biz.AttributeBiz;
import com.yc.biz.ContactBiz;
import com.yc.biz.GoodsBiz;
import com.yc.biz.GoodsDetailBiz;
import com.yc.biz.ImageBiz;
import com.yc.biz.ThirdTypeBiz;
import com.yc.fileupload.UploadFile;
import com.yc.model.JsonModel;
import com.yc.model.PageBean;
import com.yc.model.PageBeanUtils;
import com.yc.model.ParameterVO;

@Controller
public class AdminGoodsDetailController {

	@Autowired
	private GoodsDetailBiz goodsDetailBiz;
	@Autowired
	private GoodsBiz goodsBiz;
	@Autowired
	private ThirdTypeBiz tirdTypeBiz;
	@Autowired
	private AttributeBiz attributeBiz;
	@Autowired
	private ContactBiz contactBiz;

	@Autowired
	private Attribute attribute;
	@Autowired
	private GoodsDetail goodsDetail;
	@Autowired
	private Contact contact;
	@Autowired
	private JsonModel jsonmodel;

	@Resource(name = "uploadFileService")
	private UploadFile uf;
	@Autowired
	private Image image;

	@Autowired
	private ImageBiz imageBiz;

	/**
	 * 通过商品id查找商品详情
	 * 
	 * @Description
	 */
	@RequestMapping("/admin/getGoodsDetailByGoodsId.action")
	@ResponseBody
	public PageBean<GoodsDetail> getGoodsDetailByGoodsId(Integer page,
			Integer rows, String sort, String order, Integer goods_id,
			HttpSession session) {
		List<GoodsDetail> list = goodsDetailBiz
				.findGoodsDetailByGoodsId(goods_id);
		PageBean<GoodsDetail> pageBean = PageBeanUtils.setPageBean(page, rows,
				sort, order, list);
		// 回传二级列表id
		// int secondtype_id = getSecondtypeID(goods_id, session);
		pageBean.setCode(1);
		return pageBean;
	}

	/**
	 * 得到二级列表id
	 * 
	 * @Description
	 */
	private int getSecondtypeID(Integer goods_id, HttpSession session) {
		Goods goods = goodsBiz.getGoodsById(goods_id);
		ThirdType thirdType = tirdTypeBiz.findThirdTypeById(goods
				.getThirdType().getThirdtype_id());
		List<Attribute> attributesList = attributeBiz
				.getAttributeBySecondType(thirdType.getSecondType()
						.getSecondtype_id());
		session.setAttribute("attributesList", attributesList);
		return thirdType.getSecondType().getSecondtype_id();
	}

	@RequestMapping("/admin/addGoodsDtail.action")
	@ResponseBody
	public JsonModel<GoodsDetail> addGoodsDetail(Integer goods_id,
			String[] attribute_value, Integer goods_count,
			@RequestParam("image_name") MultipartFile files,
			String goodsdetail_price, HttpServletRequest request) {

		// 5.将文件存到goodsdetail对象中 存入数据库
		goodsDetail.setGoods_count(goods_count);
		goodsDetail.setGoodsdetail_price(Double.parseDouble(goodsdetail_price));
		Goods goods = new Goods();
		goods.setGoods_id(goods_id);
		// 将goodsid存入goodsdetail
		goodsDetail.setGoods(goods);
		int result = goodsDetailBiz.addGoodsDetail(goodsDetail);

		contact.setGoodsdetail(goodsDetail);
		if (result > 0) {
			// 1.保存文件
			// 2.先将文件名循环取出 3.存入指定路径下 4.指定保存到数据的数据为goodsImage/xxx.png
			// 6.当goodsdetail存入数据库后 取到goodsdetail id 存入Image对象 并存入数据库
			addImage(files, request, goodsDetail.getGoodsdetail_id());
			// 7.循环存入的属性值 取出 存到商品属性关系表中
			for (Object attrvalue : attribute_value) {
				attribute
						.setAttribute_id(Integer.parseInt(attrvalue.toString()));
				contact.setAttribute(attribute);
				contactBiz.addContact(contact);
			}
			jsonmodel.setCode(1);
		}

		return jsonmodel;
	}

	@RequestMapping("/admin/delGoodsDetailInfo.action")
	@ResponseBody
	public JsonModel<GoodsDetail> delGoodsDetailInfo(Integer goodsdetail_id) {
		int result = goodsDetailBiz.delGoodsDetail(goodsdetail_id);
		if (result > 0) {
			jsonmodel.setCode(1);

		}
		return jsonmodel;
	}

	@RequestMapping("/admin/updateGoodsDetail.action")
	@ResponseBody
	public JsonModel<GoodsDetail> updateGoodsDetail(String[] attribute_value,
			String contact_id, String goodsdetail_price, Integer goods_count,
			Integer updategoodsdetail_id, HttpServletRequest request,
			@RequestParam("image_name") MultipartFile files) {
		// 更新商品详情
		// 1，从前台页面得到相应数据 2.存入goodsDetail对象中，3.更新

		goodsDetail.setGoodsdetail_id(updategoodsdetail_id);
		goodsDetail.setGoods_count(goods_count);
		goodsDetail.setGoodsdetail_price(Double.parseDouble(goodsdetail_price));

		int result = goodsDetailBiz.updateGoodsDetail(goodsDetail);

		// 更新商品详情-属性关系表
		// 1.得到属性的关系id
		// contact.setContact_id(contact_id);
		// 2.存入goodsdetail_id
		contact.setGoodsdetail(goodsDetail);
		// 得到该详情对应的每一个关系id
		String[] contactString = contact_id.split(",");
		// 更新图片表
		boolean r = imageBiz.findImageByGoodsdetailId(updategoodsdetail_id);
		if (!r) {
			addImage(files, request, updategoodsdetail_id);
		} else {
			updateImage(files, request, updategoodsdetail_id);
		}

		boolean flag = false;
		if (result > 0) {

			boolean isContactExist = contactBiz
					.findContactByGoodsDetailId(updategoodsdetail_id);
			if (isContactExist) {
				for (int i = 0; i < attribute_value.length; i++) {
					// 3.存入attribute_id 和contact_id
					// 通过contact_id和goodsdetail_id来唯一确认确认的是哪一个条目
					attribute.setAttribute_id(Integer
							.parseInt(attribute_value[i].toString()));
					contact.setContact_id(Integer.parseInt(contactString[i]
							.toString()));
					contact.setAttribute(attribute);
					int d = contactBiz.updateContactByGoodsDetailId(contact);
					if (d > 0) {
						flag = true;
					}
				}
			} else {
				for (int i = 0; i < attribute_value.length; i++) {
					attribute.setAttribute_id(Integer
							.parseInt(attribute_value[i].toString()));
					contact.setAttribute(attribute);
					int d = contactBiz.addContact(contact);
					if (d > 0) {
						flag = true;
					}
				}
			}
		}
		if (flag) {
			jsonmodel.setCode(1);
		} else {
			jsonmodel.setCode(0);
		}
		return jsonmodel;
	}

	/**
	 * 更新图片
	 * 
	 * @Description
	 */
	private void updateImage(MultipartFile files, HttpServletRequest request,
			Integer updategoodsdetail_id) {
		String fileName = files.getOriginalFilename();
		String filePath = request.getSession().getServletContext()
				.getRealPath("imgGoods/");
		// 存入参数
		if (fileName != null && !fileName.equals("")) {
			image.setImage_path(fileName);
		}
		goodsDetail.setGoodsdetail_id(updategoodsdetail_id);
		try {
			// 上传
			uf.uploadFile(files.getBytes(), filePath, fileName);
			image.setGoodsDetail(goodsDetail);
			imageBiz.updateImage(image);
		} catch (Exception e) {
		}
	}

	/**
	 * 添加图片
	 * 
	 * @Description
	 */
	private void addImage(MultipartFile files, HttpServletRequest request,
			Integer updategoodsdetail_id) {

		String fileName = files.getOriginalFilename();
		String filePath = request.getSession().getServletContext()
				.getRealPath("imgGoods/");
		// 存入参数
		if (fileName != null && !fileName.equals("")) {
			image.setImage_path(fileName);
		}
		goodsDetail.setGoodsdetail_id(updategoodsdetail_id);
		try {
			// 上传
			uf.uploadFile(files.getBytes(), filePath, fileName);
			image.setGoodsDetail(goodsDetail);
			imageBiz.addImage(image);
		} catch (Exception e) {
		}
	}

}
