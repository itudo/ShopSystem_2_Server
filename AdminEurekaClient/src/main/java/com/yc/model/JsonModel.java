package com.yc.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class JsonModel<T> implements Serializable {

	private static final long serialVersionUID = -7445862318270892686L;
	private Integer code;
	private Object obj;
	private String errmsg;
	
	private List<T> rows;
	

	public JsonModel() {
		super();
	}

	public JsonModel(Integer code, Object obj, String errmsg) {
		super();
		this.code = code;
		this.obj = obj;
		this.errmsg = errmsg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "JsonModel [rows=" + rows + "]";
	}

	

}
