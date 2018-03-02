package com.preorder.handlers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.preorder.beans.Preorder;
import com.preorder.service.PreorderService;
import com.utils.Page;

/**
 * 
* @ClassName: PreorderHandler 
* @Description: 菜系控制器
* @author 柴含冰
* @date 2017年12月24日 下午1:50:08 
*
 */
@Controller
@RequestMapping("/Preorder")
public class PreorderHandler {
	@Autowired
	private PreorderService service;
	
	/**
	 * 
	 * <p>function 处理栏目管理请求</p> 
	 * @param model 将查询出的数据写入到model，即写入到Request域
	 * @return 返回的视图
	 */
	@RequestMapping("/PreorderManage.do")
	public String requestHandle(int pageno, Model model) {
		// 调用Service的业务方法完成以下两个查询：
		// 1. 查询所有一级栏目
		// 2. 查询当前页的信息
		List<Preorder> Preorder = service.getALLPreorder();
		model.addAttribute("Preorder", Preorder);
		/**
		 * 逻辑判断展示第几行到第几行
		 */
 		Page<Preorder> page = service.findPreorderPage(pageno);
 		model.addAttribute("page", page);
		return "/detail/orderList.jsp";
	}
  /*  @RequestMapping(value="/addPreorder.do", method=RequestMethod.POST)
  public String addPreorder(String name, Model model,HttpServletResponse response){
    	//调用service层进行逻辑判断
    	
    	Preorder aPreorder = new Preorder();
    	aPreorder.setPreordername(name);
    	
    	List<Preorder> Preorder = service.getPreorder(name);
    	if(Preorder.size()>0){
     		model.addAttribute("savePreorderfalg", "添加失败！,请更换一个菜系名称。");
    	}else{
    	if(service.addPreorder(aPreorder)){
     		model.addAttribute("savePreorderfalg", "添加成功");
    		 
    	}else{
     		model.addAttribute("savePreorderfalg", "添加失败，请稍后重试！");
    		
    	}
    	}
    	return "/detail/savePreorder.jsp"; 
    }*/
    @RequestMapping(value="/deletePreorder.do", method=RequestMethod.GET)
    public String deletePreorder(Integer id,Model model,HttpServletResponse response){
    	if(service.deletePreorder(id)){
     		model.addAttribute("deletePreorderfalg", "删除成功");
    	}else{
     		model.addAttribute("deletePreorderfalg", "删除失败");
    	}
    	
    	//删除成功，返回查询页面
    	return "../Preorder/PreorderManage.do?pageno=1";
    }
    
    @RequestMapping(value="/updatePreorder.do", method=RequestMethod.GET)
    public String updatePreorder(Integer id ,Model model,HttpServletResponse response){
    	if(service.updatePreorder(id )){
     		model.addAttribute("updatePreorderfalg", "结账成功");
    	}else{
     		model.addAttribute("updatePreorderfalg", "结账失败");
    	}
    	return "../Preorder/PreorderManage.do?pageno=1";
    }
    
/*	@RequestMapping("/getONEPreorder.do")
	public String getONEPreorder(int id, Model model) {
 		 Preorder  page = service.getONEPreorder(id);
 		model.addAttribute("Preordername", page.getPreordername());
 		model.addAttribute("updateid", page.getID());
		return "/detail/updatePreorder.jsp";
	}*/
	 
}


































