package com.yc.web.controllers;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yc.remotehystrix.MyRemote;
import com.yc.bean.Address;
import com.yc.bean.Users;
import com.yc.biz.AddressBiz;
import com.yc.biz.CartBiz;
import com.yc.biz.UsersBiz;
import com.yc.fileupload.UploadFile;
//import com.yc.mobile.IndustrySMS;
import com.yc.model.JsonModel;

@RestController
//@CrossOrigin
//@Scope(value="prototype")
public class UsersController {
	@Resource(name="usersBizImpl")
	private UsersBiz usersBiz;
	
	@Resource(name="addressBizImpl")
	private AddressBiz addressBiz;
	
	@Resource(name="cartBizImpl")
	private CartBiz cartBiz;
	
	@Resource(name="uploadFileService")
	private UploadFile uf;

	@Autowired
    MyRemote myRemote;   //由spring来生成实现类...

	@RequestMapping("checkCode.action")
	public JsonModel checkCode(@RequestParam(name = "code")String code,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		String rand = (String) session.getAttribute("rand");
		if(rand.trim().equals(code.trim())) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("checkName.action")
	public JsonModel checkName(Users user) {
		JsonModel jsonModel = new JsonModel();
		if(usersBiz.namevaliate(user)) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("checkTel.action")
	public JsonModel checkTel(Users user) {
		JsonModel jsonModel = new JsonModel();
		System.out.println(user);
		if(usersBiz.telvaliate(user)) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("sendTelCode.action")
	public JsonModel sendTel(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		int code = (int)((Math.random()*9+1)*100000);
		//IndustrySMS.execute2(user.getUser_tel(),code);
		session.setAttribute("telCode", code);
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@RequestMapping("check_tel_code.action")
	public JsonModel checkTelCcode(@RequestParam(name = "code")int code,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		int code1 = (int) session.getAttribute("telCode");
		if(code1==code) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("userValiate.action")
	public JsonModel userValiate(Users user) {
		JsonModel jsonModel = new JsonModel();
		if(usersBiz.telvaliate(user)) {
			jsonModel.setCode(1);
		} else if(usersBiz.emailvaliate(user)) {
			jsonModel.setCode(2);
		}
		return jsonModel;
	}

	@RequestMapping("userReg.action")
	public JsonModel userReg(Users user) {
		JsonModel jsonModel = new JsonModel();
		user.setUser_id((int)((Math.random()*9+1)*1000));
		if(usersBiz.register(user)==0) {
			jsonModel.setCode(0);
		} else {
			System.out.println(user);
			cartBiz.addCart(user);
			jsonModel.setCode(1);
		}
		return jsonModel;
	}
	
	@RequestMapping("login.action")
	public JsonModel login(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users user1 = usersBiz.nameLogin(user);
		Users user2 = usersBiz.telLogin(user);
		System.out.println(user2);
		if(usersBiz.telvaliate(user)||usersBiz.emailvaliate(user)) {
			jsonModel.setCode(0);
		} else if (user1!=null ) {
			jsonModel.setCode(1);
			jsonModel.setObj(user1);
			usersBiz.updateLoginDate(user1);
			session.setAttribute("user", user1);
		} else if(user2!=null ) {
			jsonModel.setCode(1);
			usersBiz.updateLoginDate(user2);
			jsonModel.setObj(user2);
			session.setAttribute("user", user2);
		}  else {
			jsonModel.setCode(2);
		}
		return jsonModel;
	}
	
	@RequestMapping("loginUser.action")
	public JsonModel loginUser(HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users user1 = (Users) session.getAttribute("user");
		if(user1!=null) {
			jsonModel.setCode(1);
			jsonModel.setObj(user1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("logout.action")
	public JsonModel logout(HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		session.removeAttribute("user");
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@RequestMapping("check.action")
	public JsonModel check(Users user) {
		JsonModel jsonModel = new JsonModel();
		boolean a = usersBiz.uservaliate(user);
		if(a) {
			jsonModel.setCode(1);
			jsonModel.setObj(user);
		}  else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("forget1.action")
	public JsonModel forget1(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		Users u = usersBiz.getUsersByName(user);
		if(u!=null) {
			jsonModel.setCode(1);
			jsonModel.setObj(u);
			//session.setAttribute("forgetUser", u);
		}  else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping(value = "sendEmail.action")
	@ResponseBody
	public JsonModel sendEmial(@RequestParam(name = "email")String email,@RequestParam(name = "code")String code,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		session.setAttribute("emailCode", code);
		boolean a = myRemote.sendEmail(Integer.parseInt(code),email);
		System.out.println("================="+a);
		if(a){
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("check_email_code.action")
	public JsonModel checkEemailCcode(@RequestParam(name = "code")int code,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		int code1 = (int) session.getAttribute("emailCode");
		if(code1==code) {
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("updatepwd.action")
	public JsonModel updatepwd(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		//Users u = (Users) session.getAttribute("forgetUser");
		//user.setUser_id(u.getUser_id());
		boolean a = usersBiz.updatepwd(user);
		if(a) {
			jsonModel.setCode(1);
			session.setAttribute("user", user);
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("updateUser.action")
	public JsonModel updateUser(Users user,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		//Users u = (Users) session.getAttribute("user");
		//user.setUser_id(u.getUser_id());
		boolean a = usersBiz.update(user);
		if(a) {
			jsonModel.setCode(1);
			//session.setAttribute("user", usersBiz.getUsersById(u.getUser_id()));
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("getSecurity.action")
	public JsonModel getSecurity(HttpSession session) {
		Users user = (Users) session.getAttribute("user");
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		jsonModel.setObj(user);
		return jsonModel;
	}
	
	@RequestMapping("changePwd.action")
	public JsonModel changePwd(HttpSession session,@RequestParam(name = "regpwd")String regpwd,@RequestParam(name = "newpwd")String newpwd) {
		JsonModel jsonModel = new JsonModel();
		Users user = (Users) session.getAttribute("user");
		if(user.getUser_pwd().equals(regpwd)) {
			jsonModel.setCode(1);
			user.setUser_pwd(regpwd);
			usersBiz.updatepwd(user);
			session.removeAttribute("user");
		} else {
			jsonModel.setCode(0);
		}
		return jsonModel;
	}
	
	@RequestMapping("getAddress.action")
	public JsonModel getAdress(HttpSession session,Users user) {
		//Users user = (Users) session.getAttribute("user");
		List<Address> list = addressBiz.getAddressById(user);
		JsonModel jsonModel = new JsonModel();
		jsonModel.setCode(1);
		jsonModel.setObj(list);
		return jsonModel;
	}
	
	@RequestMapping("addAddress.action")
	public JsonModel addAddress(Address address,HttpSession session,Users user) {
		JsonModel jsonModel = new JsonModel();
		address.setUser(user);
		addressBiz.InsertAddr(address);
		addressBiz.setDefault(address);
		jsonModel.setCode(1);
		return jsonModel;
	}

	@RequestMapping("updateAddress.action")
	public JsonModel updateAddress(Address address,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		addressBiz.updateAddr(address);
		jsonModel.setCode(1);
		return jsonModel;
	}

	@RequestMapping("delAddress.action")
	public JsonModel delAddress(Address address,HttpSession session) {
		JsonModel jsonModel = new JsonModel();
		addressBiz.delSingleAddress(address.getAddress_id());
		jsonModel.setCode(1);
		return jsonModel;
	}
	
	@RequestMapping("setDefaultAddress.action")
	public JsonModel setDefaultAddress(Address address) {
		JsonModel jsonModel = new JsonModel();
		addressBiz.setDefault(address);
		jsonModel.setCode(1);
		return jsonModel;
	}

	@RequestMapping("getDefaultAddress.action")
	public JsonModel getDefaultAddress(Address address) {
		JsonModel jsonModel = new JsonModel();
		Address address1 = addressBiz.getAddressByStatus(address);
		if(address1!=null) {
			jsonModel.setObj(address1);
			jsonModel.setCode(1);
		} else {
			jsonModel.setCode(0);
		}

		return jsonModel;
	}
	
	@RequestMapping(value="uploadHead.action")
    public  JsonModel uploadHead(Users user,HttpSession session,@RequestParam("file") MultipartFile file, HttpServletRequest request) {
    	JsonModel jsonModel = new JsonModel();
        String contentType = file.getContentType();
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String filePath = request.getSession().getServletContext().getRealPath("imgHead/");
        try {
            
            //Users user = (Users) session.getAttribute("user");
            user.setUser_head(fileName);
            usersBiz.updateHead(user);
            session.setAttribute("user", user);
            uf.uploadFile(file.getBytes(), filePath, fileName);
            jsonModel.setCode(1);
        } catch (Exception e) {
           jsonModel.setCode(0);
        }
        return jsonModel;
    }
    
}
