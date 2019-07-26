package com.yc.model;

import java.io.Serializable;
import java.util.List;

public class PageBean<T> implements Serializable {
	
	private Integer code;

	private int total; // �ܼ�¼��
	private int pages=1; // ��ǰ�ǵڼ�ҳ
	private int pagesize=5; // ÿҳ������
	private List<T> list; // �浱ǰҳ�����м�¼
	private int totalpages; // �ܹ��ж���ҳ

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	/**
	 * ��һҳ,�����ǰҳ���ǵ�һҳ��������һҳʱҳ����һ�������ǰҳ�Ѿ��ǵ�һҳ�򲻱�
	 * @return
	 */
	public int getPrePage(){
	  if( pages >1 ){
		  return pages -1 ;
	  }else{
		  return 1 ;
	  }
	 }
	/**
	 * ��һҳ���жϵ�ǰҳ�ǲ������һҳ����������һҳ���򲻱䣬�������һҳ�������һҳ=��ǰҳ��+1��
	 * @return
	 */
	public int getNextPage(){
		if(pages >= totalpages ){
			return totalpages<=0?1:totalpages ;
		}else{
			return pages + 1 ;
		}
	}
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalpages() {
		return totalpages<=0?1:totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	@Override
	public String toString() {
		return "PageBean [total=" + total + ", pages=" + pages + ", pagesize="
				+ pagesize + ", list=" + list + ", totalpages=" + totalpages
				+ "]";
	}

}
