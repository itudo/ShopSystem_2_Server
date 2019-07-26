package com.yc.biz;
 
import java.util.List;
import java.util.Map;

import com.yc.bean.Users;
import com.yc.model.PageBean;

public interface UsersBiz {
	 /**
	  * 注册用户
	  * @param user
	  * @return
	  */
	public int register(Users user);
	
	/**
	 * 用户名是否存在
	 * @param user
	 * @return
	 */
	public boolean namevaliate(Users user);
	
	/**
	 * 手机号是否存在
	 * @param user
	 * @return
	 */
	public boolean telvaliate(Users user);
	
	/**
	 * 邮箱是否存在
	 * @param user
	 * @return
	 */
	public boolean emailvaliate(Users user);
	
	/**
	 * 根据id查用户
	 * @param id
	 * @return
	 */
	public Users getUsersById(Integer id);
	
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	public Users nameLogin(Users user);
	public Users telLogin(Users user);
	public Users emailLogin(Users user);
    /**
     * 更新
     * @param user
     * @return
     */
	public boolean update(Users user); 
	/**
	 * 查所有的用户
	 * @return
	 */
	public PageBean selectAllUser(Map<String,Object> map);
}
