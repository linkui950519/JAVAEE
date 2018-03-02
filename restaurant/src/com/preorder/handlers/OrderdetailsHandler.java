package com.preorder.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.preorder.beans.Orderdetails;
import com.preorder.service.OrderdetailsService;

/**
 * 
* @ClassName: OrderdetailsHandler 
* @Description:订单详情控制器
* @author 柴含冰
* @date 2017年12月24日 下午1:50:08 
*
 */
@Controller
@RequestMapping("/Orderdetails")
public class OrderdetailsHandler {
	@Autowired
	private OrderdetailsService service;
	
	/**
	 * 
	 * <p>function 处理栏目管理请求</p> 
	 * @param model 将查询出的数据写入到model，即写入到Request域
	 * @return 返回的视图
	 */
	@RequestMapping("/OrderdetailsManage.do")
	public String requestHandle(Integer ipreorderID, Model model) {
		//调用service层进行逻辑判断
	 	  List<Orderdetails> findOrderdetails = service.getOrderdetails(ipreorderID);
		  if(findOrderdetails.size()>0){
			  model.addAttribute("Orderdetails", findOrderdetails);
			  return "/detail/orderDetail.jsp";

		  }else{
				model.addAttribute("errorMSG", "未查询到匹配的数据，请核实！");
				return "/detail/orderList.jsp";
		  }
	}
}


































