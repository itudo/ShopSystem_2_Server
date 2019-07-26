package com.yc.dao;

public interface RedisDao {
	
	
	
	//list的增
	public int lpush(String keyName,Object obj);
	//list的查
	public int lrange(String keyName,int start,int end);
}
