package com.preorder.beans;

import java.util.Date;

/**
 * 
* @ClassName: Preorder 
* @Description: 预订单实体类 
* @author 柴含冰 
* @date 2017年12月26日 下午1:26:51 
*
 */
public class Preorder {
	private Integer ID;
	private String tablename;
	private String ordername;
	private String mobile;
	private String ordertime;
	private String countprice;
	private Integer flag;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	
	/**
	 * 
	* @Title: get and set
	* @Description:请勿修改
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	 
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getCountprice() {
		return countprice;
	}
	public void setCountprice(String countprice) {
		this.countprice = countprice;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public Date getMakedate() {
		return makedate;
	}
	public void setMakedate(Date makedate) {
		this.makedate = makedate;
	}
	public String getMaketime() {
		return maketime;
	}
	public void setMaketime(String maketime) {
		this.maketime = maketime;
	}
	public Date getModifydate() {
		return modifydate;
	}
	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}
	public String getModifytime() {
		return modifytime;
	}
	public void setModifytime(String modifytime) {
		this.modifytime = modifytime;
	}
	
}
