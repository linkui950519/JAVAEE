package com.cuisinetable.beans;

import java.util.Date;
/**
 * 
* @ClassName: CuisineTable 
* @Description: 餐桌实体类
* @author 柴含冰 
* @date 2017年12月25日 下午12:58:18 
*
 */
public class CuisineTable {

	private Integer ID;
	private String cuisinetablename;
	private String scheduledflag;
	private String scheduledtime;
	private Integer flag;
	private Date makedate;
	private String maketime;
	private Date modifydate;
	private String modifytime;
	
	
 
	public String getScheduledflag() {
		return scheduledflag;
	}
	public void setScheduledflag(String scheduledflag) {
		this.scheduledflag = scheduledflag;
	}
	/**
	* @Description: 请勿修改与删除 
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
	public String getCuisinetablename() {
		return cuisinetablename;
	}
	public void setCuisinetablename(String cuisinetablename) {
		this.cuisinetablename = cuisinetablename;
	}
	public String getScheduledtime() {
		return scheduledtime;
	}
	public void setScheduledtime(String scheduledtime) {
		this.scheduledtime = scheduledtime;
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
