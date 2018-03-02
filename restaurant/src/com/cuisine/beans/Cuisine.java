package com.cuisine.beans;

import java.util.Date;

/**
 * 
* @ClassName: Cuisine 
* @Description: 菜系实体类
* @author 柴含冰
* @date 2017年12月24日 下午1:39:30 
*
 */
public class Cuisine {

	
	private Integer ID;
	private String cuisinename;
	private Integer flag;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	
	
	
	
	/**
	 * 
	* @Description: get and set 请勿修改与删除
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:41:06 
	* @version V1.0
	 */
	public Integer getID() {
		return ID;
	}
	public void setID(Integer iD) {
		ID = iD;
	}
	public String getCuisinename() {
		return cuisinename;
	}
	public void setCuisinename(String cuisinename) {
		this.cuisinename = cuisinename;
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
