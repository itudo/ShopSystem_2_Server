 package com.yc.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yc.bean.Users;
import com.yc.biz.UsersBiz;
import com.yc.dao.BaseDao;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)//默认事务，在类上配置的事务机制在每个方法上都起作用
@Service
public class UsersBizImpl implements UsersBiz {
	@Resource(name="baseDaoMybatisImpl")
	private BaseDao<Users> baseDao;
	@Override
	public int register(Users user) {
		return baseDao.save(user, "saveUser");
	}
	
	@Override
	public boolean uservaliate(Users user) {
		List<Users> list = baseDao.findAll(user, "isNameExists");
		if(list!=null && list.size()>0){
			return true;
		} 
		return false;
	}

	@Override
	public boolean namevaliate(Users user) {
		List<Users> list = baseDao.findAll(user, "isUserExists");
		System.out.println(list);
		if(list!=null && list.size()>0){
			return true;
		} 
		return false;
	}
	
	@Override
	public boolean telvaliate(Users user) {
		List<Users> list = baseDao.findAll(user, "isTelExists");
		System.out.println(list);
		if(list!=null && list.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean emailvaliate(Users user) {
		List<Users> list = baseDao.findAll(user, "isEmailExists");
		if(list!=null && list.size()>0){
			return true;
		}
		return false;
	}

	@Override
	public Users getUsersById(Integer id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("user_id", id);
		return  baseDao.findOne(Users.class, "getUsersById", map);
	}

	@Override
	public Users nameLogin(Users user) {
		Users u =  baseDao.findOne(user, "getUserByName");
		return u;
	}
	@Override
	public Users telLogin(Users user) {
		Users u =  baseDao.findOne(user, "getUserByTel");
		return u;
	}
	@Override
	public Users emailLogin(Users user) {
		Users u =  baseDao.findOne(user, "getUserByEmail");
		return u;
	}

	@Override
	public boolean update(Users user) {
		this.baseDao.update(user, "updateUser");
		return true;
	}

	@Override
	public Users getUsersByName(Users user) {
		Users u =  baseDao.findOne(user, "isUser");
		return u;
	}

	@Override
	public boolean updatepwd(Users user) {
		this.baseDao.update(user, "updatepwd");
		return true;
	}

	@Override
	public boolean updateHead(Users user) {
		this.baseDao.update(user, "updateHead");
		return false;
	}
	
	public boolean updateLoginDate(Users user){
		this.baseDao.update(user, "updateLoginDate");
		return false;
	}
}
