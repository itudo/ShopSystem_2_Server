package com.yc.model;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class PageBean<T> implements Serializable {

	private Integer code;

	private int total; // �ܼ�¼��
	private int pages = 1; // ��ǰ�ǵڼ�ҳ
	private int pagesize = 5; // ÿҳ������
	private List<T> rows; // �浱ǰҳ�����м�¼
	private int totalpages; // �ܹ��ж���ҳ
	private List<T> list;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * ��һҳ,�����ǰҳ���ǵ�һҳ��������һҳʱҳ����һ�������ǰҳ�Ѿ��ǵ�һҳ�򲻱�
	 * 
	 * @return
	 */
	public int getPrePage() {
		if (pages > 1) {
			return pages - 1;
		} else {
			return 1;
		}
	}

	/**
	 * ��һҳ���жϵ�ǰҳ�ǲ������һҳ����������һҳ���򲻱䣬�������һҳ�������һҳ=��ǰҳ��+1��
	 * 
	 * @return
	 */
	public int getNextPage() {
		if (pages >= totalpages) {
			return totalpages <= 0 ? 1 : totalpages;
		} else {
			return pages + 1;
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

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	public int getTotalpages() {
		return totalpages <= 0 ? 1 : totalpages;
	}

	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "PageBean [code=" + code + ", total=" + total + ", pages="
				+ pages + ", pagesize=" + pagesize + ", rows=" + rows
				+ ", totalpages=" + totalpages + ", list=" + list + "]";
	}

}
