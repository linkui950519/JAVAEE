package com.cuisine.handlers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine.beans.Cuisine;
import com.cuisine.service.CuisineService;
import com.utils.Page;

/**
 * 
* @ClassName: CuisineHandler 
* @Description: 菜系控制器
* @author 柴含冰
* @date 2017年12月24日 下午1:50:08 
*
 */
@Controller
@RequestMapping("/Cuisine")
public class CuisineHandler {
	@Autowired
	private CuisineService service;
	
	/**
	 * 
	 * <p>function 处理栏目管理请求</p> 
	 * @param model 将查询出的数据写入到model，即写入到Request域
	 * @return 返回的视图
	 */
	@RequestMapping("/CuisineManage.do")
	public String requestHandle(int pageno, Model model) {
		// 调用Service的业务方法完成以下两个查询：
		// 1. 查询所有一级栏目
		// 2. 查询当前页的信息
		List<Cuisine> Cuisine = service.getALLCuisine();
		model.addAttribute("Cuisine", Cuisine);
		/**
		 * 逻辑判断展示第几行到第几行
		 */
 		Page<Cuisine> page = service.findCuisinePage(pageno);
 		model.addAttribute("page", page);
		return "/detail/cuisineList.jsp";
	}
    @RequestMapping(value="/addCuisine.do", method=RequestMethod.POST)
  public String addCuisine(String name, Model model,HttpServletResponse response){
    	//调用service层进行逻辑判断
    	
    	Cuisine aCuisine = new Cuisine();
    	aCuisine.setCuisinename(name);
    	
    	List<Cuisine> cuisine = service.getCuisine(name);
    	if(cuisine.size()>0){
     		model.addAttribute("saveCuisinefalg", "添加失败！,请更换一个菜系名称。");
    	}else{
    	if(service.addCuisine(aCuisine)){
     		model.addAttribute("saveCuisinefalg", "添加成功");
    		 
    	}else{
     		model.addAttribute("saveCuisinefalg", "添加失败，请稍后重试！");
    		
    	}
    	}
    	return "/detail/saveCuisine.jsp"; 
    }
    @RequestMapping(value="/deleteCuisine.do", method=RequestMethod.GET)
    public String deleteCuisine(Integer id,Model model,HttpServletResponse response){
    	if(service.deleteCuisine(id)){
     		model.addAttribute("deleteCuisinefalg", "删除成功");
    	}else{
     		model.addAttribute("deleteCuisinefalg", "删除失败");
    	}
    	
    	//删除成功，返回查询页面
    	return "../Cuisine/CuisineManage.do?pageno=1";
    }
    
    @RequestMapping(value="/updateCuisine.do", method=RequestMethod.POST)
    public String updateCuisine(Integer id, String name,Model model,HttpServletResponse response){
    	if(service.updateCuisine(id ,name)){
     		model.addAttribute("updateCuisinefalg", "修改成功");
    	}else{
     		model.addAttribute("updateCuisinefalg", "修改失败");
    	}
    	return "/detail/updateCuisine.jsp";
    }
    
	@RequestMapping("/getONECuisine.do")
	public String getONECuisine(int id, Model model) {
 		 Cuisine  page = service.getONECuisine(id);
 		model.addAttribute("Cuisinename", page.getCuisinename());
 		model.addAttribute("updateid", page.getID());
		return "/detail/updateCuisine.jsp";
	}
	/**
	 * 
	* @Description:页面搜索功能使用
	* @author 柴含冰   
	* @date 2017年12月24日 下午6:56:16 
	* @version V1.0
	 */
	  @RequestMapping(value="/getCuisine.do", method=RequestMethod.POST)
	  public String getCuisine(String name,  Model model,HttpServletResponse response){
	    	//调用service层进行逻辑判断
 	 	  List<Cuisine> findCuisinePage = service.findCuisinePage(name );
		  if(findCuisinePage.size()>0){
			  model.addAttribute("cuisine", findCuisinePage);
			  return "/detail/cuisine.jsp";

		  }else{
				model.addAttribute("errorMSG", "未查询到匹配的数据，请核实！");
				  return "/detail/cuisineList.jsp";

		  }
	    }
}


































