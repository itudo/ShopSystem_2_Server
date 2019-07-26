package com.yc.biz;
 
import com.yc.bean.Users;

public interface UsersBiz {
	 /**
	  * 注册用户
	  * @param user
	  * @return
	  */
	public int register(Users user);
	
	/**
	 * 用户是否存在
	 * @param user
	 * @return
	 */
	public boolean uservaliate(Users user);
	
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
	 * 根据name查用户
	 * @param id
	 * @return
	 */
	public Users getUsersByName(Users user);
	
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
	
	public boolean updatepwd(Users user); 
	
	public boolean updateHead(Users user); 
	
	public boolean updateLoginDate(Users user); 
}
