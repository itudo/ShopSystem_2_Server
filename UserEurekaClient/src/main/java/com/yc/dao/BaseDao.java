package com.yc.dao;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
	
	/**
	 * 增加对象
	 * @param t  ：要保存的数据对象
	 * @param clazz  对象的反射实例，用于确认mapper文件的位置
	 * @param sqlId   mapper 中的方法名
	 * @param list   要保存的对象列表
	 * @param parameterMap  要保存对象的参数
	 */
	public int save(T t, String sqlId);
	
	public int save(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
	
	public int save(Class<T> clazz,String sqlId,List<T> list);

	/**
	 * 更新对象
	 * @param t  带有参数的待更新对象
	 * @param clazz  对象的反射实例，用于确认mapper文件的位置
	 * @param sqlId  mapper 中的方法名
	 * @param list   要更新的对象列表
	 * @param parameterMap  要更新对象的参数
	 */
	public int update(T t, String sqlId);
	
	public int update(Class<T> clazz,String sqlId);
	
	// 根据条件更新
	public int update(Class<T> clazz, String sqlId, Map<String, Object> parameterMap);
	
	public int update(Class<T> clazz,String sqlId,List<T> list);
	
	/**
	 * 删除对象
	 * @param t  带有参数的待删除对象
	 * @param clazz  对象的反射实例，用于确认mapper文件的位置
	 * @param id   要删除对象的id
	 * @param ids   要删除对象的id列表 
	 * @param sqlId  mapper 中的方法名
	 * @param parameterMap  要删除对象的参数
	 */
	public int del(T t,String sqlId);
	
	public int del(Class<T> clazz, String id,String sqlId);
	
	public int del(Class<T> clazz, List<Integer> ids,String sqlId);
	
	// 根据条件删除
	public int del(Class<T> clazz,String sqlId,Map<String,Object> parameterMap);
	
	/**
	 * 查集合，没有条件属性
	 * @param t  带有参数的待查询对象
	 * @param clazz   对象的反射实例，用于确认mapper文件的位置
	 * @param sqlId  mapper中的方法名
	 * @return 集合
	 */
	public List<T> findAll(Class<T> clazz,String sqlId);
	
	public List<T> findAll(T t,String sqlId);
	
	//查集合，条件查询   parameterMap  要查询的条件
	public List<T> findAll(Class<T> clazz,String sqlId,Map<String,Object> parameterMap);
	
	/**
	 * 查对象
	 * @param t  带有参数的待查询对象
	 * @param clazz   对象的反射实例，用于确认mapper文件的位置
	 * @param sqlId  mapper中的方法名
	 * @return 对象
	 */
	public T findOne(Class<T> clazz,String sqlId);
	
	public T findOne(T t,String sqlId);
	
	// 根据条件查询
	public T findOne(Class<T> clazz,String sqlId,Map<String,Object> parameterMap);
	
	
	/**
	 * 数量查询
	 * @param t  带有参数的待查询对象
	 * @param clazz  用于确认mapper文件的位置
	 * @param sqlId  mapper中的方法名
	 * @return
	 */
	public int getCount(Class<T> clazz,String sqlId);
									
	public int getCount(T t ,String sqlId);
									
	// 根据条件聚合查询
	public int getCount(Class<T> clazz,Map<String,Object> map,String sqlId);
	
	/**
	 * 聚合查询
	 * @param t  带有参数的待查询对象
	 * @param clazz  用于确认mapper文件的位置
	 * @param sqlId  mapper中的方法名
	 * @return
	 */
	public double getFunc(Class<T> clazz,String sqlId);
	
	public double getFunc(T t,String sqlId);
	
	public double getFunc(Class<T> clazz,String sqlId,Map<String,Object> map);

	
}
