package com.preorder.service;

import java.util.List;

import com.preorder.beans.Orderdetails;

public interface OrderdetailsService {
	/**
	 * 
	* @Title: getOrderdetails 
	* @Description: 查询详情 
	* @param @param preorderID
	* @param @return    设定文件 
	* @return List<Orderdetails>    返回类型 
	* @throws
	 */
    public  List<Orderdetails>   getOrderdetails(Integer preorderID);
}
