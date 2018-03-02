package com.utils;

import java.util.List;

 
/**
 * 
* @ClassName: Page 
* @Description: 分页 
* @author 柴含冰
* @date 2017年12月24日 下午1:37:14 
* 
* @param <T>
 */
public class Page<T> {
	/**
	 * 当前页码（给定）
	 */
	private int pageno;
	/**
	 * 当前页起始索引（计算）
	 */
	private int pageStartIndex;
	/**
	 * 页面大小（给定）
	 */
	private int pageSize;
	/**
	 * 总记录数（查询）
	 */
	private long totalRows;
	/**
	 * 总页数，即最大页码（计算）
	 */
	private long totalPages;
	/**
	 * 当前页包含的具体数据（查询）
	 */
	private List<T> datas;

	public Page() {
		pageno = 1;
		pageSize = Constants.PAGE_SIZE;
	}

	/**
	 * 
	 * @param pageno
	 *            页码
	 * @param pageSize
	 *            页面大小
	 */
	public Page(int pageno, int pageSize) {
		if (pageno < 0) {
			pageno = 1;
		}
		if (pageSize < 0) {
			pageSize = Constants.PAGE_SIZE;
		}
		this.pageno = pageno;
		this.pageSize = pageSize;
	}

	public int getPageno() {
		return pageno;
	}

	public void setPageno(int pageno) {
		this.pageno = pageno;
	}

	public int getPageStartIndex() {
		return (pageno - 1) * pageSize;
	}

	public void setPageStartIndex(int pageStartIndex) {
		this.pageStartIndex = pageStartIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(long totalRows) {
		this.totalRows = totalRows;
	}

	public long getTotalPages() {
		totalPages = totalRows / pageSize;
		if(totalRows % pageSize != 0) {
			totalPages++;
		}
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Page [pageno=" + pageno + ", pageStartIndex=" + pageStartIndex + ", pageSize=" + pageSize
				+ ", totalRows=" + totalRows + ", totalPages=" + totalPages + ", datas=" + datas + "]";
	}

}
