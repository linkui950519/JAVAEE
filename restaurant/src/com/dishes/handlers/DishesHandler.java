package com.dishes.handlers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dishes.beans.Dishes;
import com.dishes.service.DishesService;
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
@RequestMapping("/Dishes")
public class DishesHandler {
	@Autowired
	private DishesService service;
	
	/**
	 * 
	 * <p>function 处理栏目管理请求</p> 
	 * @param model 将查询出的数据写入到model，即写入到Request域
	 * @return 返回的视图
	 */
	@RequestMapping("/DishesManage.do")
	public String requestHandle(int pageno, Model model) {
		// 调用Service的业务方法完成以下两个查询：
		// 1. 查询所有一级栏目
		// 2. 查询当前页的信息
		List<Dishes> Dishes = service.getALLDishes();
		model.addAttribute("Dishes", Dishes);
		/**
		 * 逻辑判断展示第几行到第几行
		 */
 		Page<Dishes> page = service.findDishesPage(pageno);
 		model.addAttribute("page", page);
		return "/detail/foodList.jsp";
	}
    @RequestMapping(value="/addDishes.do", method=RequestMethod.POST)
  public String addDishes(String theircuisine,String dishesname,String price,String vipprice, Model model,HttpServletResponse response){
    	//调用service层进行逻辑判断
    	
    	Dishes aDishes = new Dishes();
    	aDishes.setDishesname(dishesname);
    	aDishes.setTheircuisine(theircuisine);
    	aDishes.setPrice(price);
    	aDishes.setVipprice(vipprice);
    	List<Dishes> Dishes = service.getDishes(dishesname);
    	if(Dishes.size()>0){
     		model.addAttribute("saveDishesfalg", "添加失败！,请更换一个菜品名称。");
    	}else{
    	if(service.addDishes(aDishes)){
     		model.addAttribute("saveDishesfalg", "添加成功");
    		 
    	}else{
     		model.addAttribute("saveDishesfalg", "添加失败，请稍后重试！");
    		
    	}
    	}
    	return "/detail/saveFood.jsp"; 
    }
    @RequestMapping(value="/deleteDishes.do", method=RequestMethod.GET)
    public String deleteDishes(Integer id,Model model,HttpServletResponse response){
    	if(service.deleteDishes(id)){
     		model.addAttribute("deleteDishesfalg", "删除成功");
    	}else{
     		model.addAttribute("deleteDishesfalg", "删除失败");
    	}
    	
    	//删除成功，返回查询页面
    	return "../Dishes/DishesManage.do?pageno=1";
    }
    
    @RequestMapping(value="/updateDishes.do", method=RequestMethod.POST)
    public String updateDishes(Integer id, String theircuisine,String dishesname,String price,String vipprice, Model model,HttpServletResponse response){
    	Dishes aDishes = new Dishes();
    	aDishes.setID(id);
    	aDishes.setDishesname(dishesname);
    	aDishes.setTheircuisine(theircuisine);
    	aDishes.setPrice(price);
    	aDishes.setVipprice(vipprice);
    	if(service.updateDishes(aDishes)){
     		model.addAttribute("updateDishesfalg", "修改成功");
    	}else{
     		model.addAttribute("updateDishesfalg", "修改失败");
    	}
    	return "/detail/updateFood.jsp";
    }
    
	@RequestMapping("/getONEDishes.do")
	public String getONEDishes(int id, Model model) {
		Dishes  page = service.getONEDishes(id);
 		model.addAttribute("Dishesename", page.getDishesname());
 		model.addAttribute("Theircuisine", page.getTheircuisine());
 		model.addAttribute("Price", page.getPrice());
 		model.addAttribute("Vipprice", page.getVipprice());
 		model.addAttribute("updateid", page.getID());
		return "/detail/updateFood.jsp";
	}
	/**
	 * 
	* @Description:页面搜索功能使用
	* @author 柴含冰   
	* @date 2017年12月24日 下午6:56:16 
	* @version V1.0
	 */
	  @RequestMapping(value="/getDishes.do", method=RequestMethod.POST)
	  public String getDishes(String name,  Model model,HttpServletResponse response){
	    	//调用service层进行逻辑判断
 	 	  List<Dishes> findDishesPage = service.findDishesPage(name );
		  if(findDishesPage.size()>0){
			  model.addAttribute("Dishes", findDishesPage);
			  return "/detail/food.jsp";

		  }else{
				model.addAttribute("errorMSG", "未查询到匹配的数据，请核实！");
				  return "/detail/foodList.jsp";

		  }
	    }
	  /**
		 * 
		* @Description:页面添加
		* @author 柴含冰   
		* @date 2017年12月24日 下午6:56:16 
		* @version V1.0
		 */
	  @RequestMapping(value="/getCuisine.do")
	  public String getCuisine(Model model){
		//调用service层进行逻辑判断
 	 	  List<Map<Integer , String>> getCuisine = service.getCuisine();
 	 		model.addAttribute("Cuisine", getCuisine);
		  return "/detail/saveFood.jsp";    
	  }
	  
}


































