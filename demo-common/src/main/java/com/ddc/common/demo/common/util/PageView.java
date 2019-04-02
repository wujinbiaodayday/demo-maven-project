package com.ddc.common.demo.common.util;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LongBing on 2018/3/7.
 */
public class PageView<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer curPage;// 当前页码
	private Integer pageSize;// 每页记录数
	private Integer pages;// 总页数
	private Long total;// 总记录数
	private List<T> resultList;//结果列表

	public PageView() {
	}

	public PageView(Integer curPage, Integer pageSize, Integer pages, Long total, List<T> resultList) {
		this.curPage = curPage;
		this.pageSize = pageSize;
		this.pages = pages;
		this.total = total;
		this.resultList = resultList;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getPages() {
		return pages;
	}

	public void setPages(Integer pages) {
		this.pages = pages;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getResultList() {
		return resultList;
	}

	public void setResultList(List<T> resultList) {
		this.resultList = resultList;
	}
}
