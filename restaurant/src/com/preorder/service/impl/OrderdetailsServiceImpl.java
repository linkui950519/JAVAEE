package com.preorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.preorder.beans.Orderdetails;
import com.preorder.dao.OrderdetailsDao;
import com.preorder.service.OrderdetailsService;
/**
 * 
* @ClassName: OrderdetailsServiceImpl 
* @Description: 订单详情查询 
* @author 柴含冰 
* @date 2017年12月26日 下午3:33:47 
*
 */
@Service
public class OrderdetailsServiceImpl implements OrderdetailsService {
	@Autowired
	private OrderdetailsDao dao;
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Orderdetails> getOrderdetails(Integer preorderID) {
		return dao.getOrderdetails(preorderID);
	} 
	
}
