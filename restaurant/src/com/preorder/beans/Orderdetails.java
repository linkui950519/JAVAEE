package com.preorder.beans;

import java.util.Date;

/**
 * 
* @ClassName: Orderdetails 
* @Description: 订单详情表
* @author 柴含冰 
* @date 2017年12月26日 下午1:35:20 
*
 */
public class Orderdetails {
	private Integer ID;
	private Integer preorderID;
	private String dishesname;

	private String price;
	private Integer dcount;
	private Integer flag;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	/**
	 * 
	* @Title: get and set 
	* @Description: 请勿修改 
	* @param @return    设定文件 
	* @return Integer    返回类型 
	* @throws
	 */
	public String getDishesname() {
		return dishesname;
	}
	public void setDishesname(String dishesname) {
		this.dishesname = dishesname;
	}
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public Integer getPreorderID() {
		return preorderID;
	}
	public void setPreorderID(Integer preorderID) {
		this.preorderID = preorderID;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getDcount() {
		return dcount;
	}
	public void setDcount(Integer dcount) {
		this.dcount = dcount;
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
