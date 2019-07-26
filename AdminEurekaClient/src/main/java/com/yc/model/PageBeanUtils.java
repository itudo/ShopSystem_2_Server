package com.yc.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageBeanUtils {
	
	/**
	 * 将从数据库中查到的数据进行分页处理
	 * @param page 当前页
	 * @param rows 总条数
	 * @param sort 排序
	 * @param order  排序方式
	 * @param list  传入的对象列表
	 * @return
	 */
	public static PageBean   setPageBean(Integer page,Integer rows ,String sort ,String order,List list){
		PageBean   pageBean =  new PageBean ();
		pageBean.setRows(list);
		pageBean.setTotal(list.size());
		pageBean.setPages(page);
		pageBean.setPagesize(rows);
		return pageBean;
	}
	
	/**
	 * 将从后台页面得到的分页数据存到Map 然后返回
	 * @param page
	 * @param rows
	 * @param sort
	 * @param order
	 * @return
	 */
	public  static  Map<String, Object> setMap(Integer page,Integer rows ,String sort ,String order){
		Map<String, Object> map = new HashMap<String, Object>();
		int start = (page - 1) * rows;
		map.put("pages", page);
		map.put("start", start);
		map.put("pageSize", rows);
		map.put("orderby", sort);
		map.put("orderway", order);
		return map;
	}

}
