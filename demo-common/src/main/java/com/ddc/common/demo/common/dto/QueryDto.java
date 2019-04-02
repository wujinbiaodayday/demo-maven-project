package com.ddc.common.demo.common.dto;

import java.io.Serializable;

/**
 * Created by LongBing on 2018/3/7.
 */
public class QueryDto implements Serializable {
	private static final long serialVersionUID = 4620489922855131986L;

	/**分页当前页数**/
	private Integer page;
	/**分页每页记录数**/
	private Integer rows;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}
}
