package com.dishes.beans;

import java.util.Date;

/**
 * 
* @ClassName: Dishes 
* @Description: 菜品实体类
* @author 柴含冰 
* @date 2017年12月25日 上午9:56:22 
*
 */
public class Dishes {

	private Integer ID;
	private String dishesname;
	private String theircuisine;
	private String price;
	private String vipprice;
	private Integer flag;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	
	/**
	 * 
	* @Title: get and set 
	* @Description: 请勿修改与删除，可新增 
	* @throws
	 */
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getDishesname() {
		return dishesname;
	}
	public void setDishesname(String dishesname) {
		this.dishesname = dishesname;
	}
	public String getTheircuisine() {
		return theircuisine;
	}
	public void setTheircuisine(String theircuisine) {
		this.theircuisine = theircuisine;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getVipprice() {
		return vipprice;
	}
	public void setVipprice(String vipprice) {
		this.vipprice = vipprice;
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
