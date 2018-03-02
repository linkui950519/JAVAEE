package com.cuisinetable.handlers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cuisine.beans.Cuisine;
import com.cuisinetable.beans.CuisineTable;
import com.cuisinetable.service.CuisineTableService;
import com.utils.Page;

/**
 * 
* @ClassName: CuisineHandler 
* @Description: 菜桌控制器
* @author 柴含冰
* @date 2017年12月25日 下午1:50:08 
*
 */
@Controller
@RequestMapping("/CuisineTable")
public class CuisineTableHandler {
	@Autowired
	private CuisineTableService service;
	
	/**
	 * 
	 * <p>function 处理栏目管理请求</p> 
	 * @param model 将查询出的数据写入到model，即写入到Request域
	 * @return 返回的视图
	 */
	@RequestMapping("/CuisineTableManage.do")
	public String requestHandle(int pageno, Model model) {
		// 调用Service的业务方法完成以下两个查询：
		// 1. 查询所有一级栏目
		// 2. 查询当前页的信息
		List<CuisineTable> CuisineTable = service.getALLCuisineTable();
		model.addAttribute("CuisineTable", CuisineTable);
		/**
		 * 逻辑判断展示第几行到第几行
		 */
 		Page<CuisineTable> page = service.findCuisinePage(pageno);
 		model.addAttribute("page", page);
		return "/detail/boardList.jsp";
	}
    @RequestMapping(value="/addCuisineTable.do", method=RequestMethod.POST)
  public String addCuisineTable(String name, Model model,HttpServletResponse response){
    	//调用service层进行逻辑判断
    	
    	CuisineTable aCuisineTable = new CuisineTable();
    	aCuisineTable.setCuisinetablename(name);
    	
    	List<CuisineTable> cuisineTable = service.getCuisineTable(name);
    	if(cuisineTable.size()>0){
     		model.addAttribute("saveCuisineTablefalg", "添加失败！,请更换一个餐桌名称。");
    	}else{
    	if(service.addCuisineTable(aCuisineTable)){
     		model.addAttribute("saveCuisineTablefalg", "添加成功");
    		 
    	}else{
     		model.addAttribute("saveCuisineTablefalg", "添加失败，请稍后重试！");
    		
    	}
    	}
    	return "/detail/saveBoard.jsp"; 
    }
    @RequestMapping(value="/deleteCuisineTable.do", method=RequestMethod.GET)
    public String deleteCuisine(Integer id,Model model,HttpServletResponse response){
    	if(service.deleteCuisineTable(id)){
     		//model.addAttribute("errorMSG", "删除成功");
    	}else{
     		model.addAttribute("errorMSG", "删除失败");
    	}
    	
    	//删除成功，返回查询页面
    	return "../CuisineTable/CuisineTableManage.do?pageno=1";
    }
    
    @RequestMapping(value="/updateCuisineTable1.do", method=RequestMethod.GET)
    public String updateCuisineTable1(Integer id,Model model,HttpServletResponse response){
    	if(service.updateCuisineTable(id)){
     		//model.addAttribute("updateCuisineTablefalg", "退桌成功");
    	}else{
     		model.addAttribute("updateCuisineTablefalg", "退桌失败");
    	}
    	return "../CuisineTable/CuisineTableManage.do?pageno=1";
    }
    @RequestMapping(value="/updateCuisineTable2.do", method=RequestMethod.GET)
    public String updateCuisineTable2(Integer id,Model model,HttpServletResponse response){
    	if(service.updateCuisineTable1(id)){
     		//model.addAttribute("updateCuisineTablefalg", "退桌成功");
    	}else{
     		model.addAttribute("updateCuisineTablefalg", "预定失败");
    	}
    	return "../CuisineTable/CuisineTableManage.do?pageno=1";
    }
	@RequestMapping("/getONECuisineTable.do")
	public String getONECuisine(int id, Model model) {
 		 CuisineTable  page = service.getONECuisineTable(id);
 		model.addAttribute("Cuisinename", page.getCuisinetablename());
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
	  @RequestMapping(value="/getCuisineTable.do", method=RequestMethod.POST)
	  public String getCuisine(String name,  Model model,HttpServletResponse response){
	    	//调用service层进行逻辑判断
 	 	  List<CuisineTable> findCuisinePage = service.findCuisinePage(name );
		  if(findCuisinePage.size()>0){
			  model.addAttribute("cuisine", findCuisinePage);
			  return "/detail/board.jsp";

		  }else{
				model.addAttribute("errorMSG", "未查询到匹配的数据，请核实！");
				  return "/detail/boardList.jsp";

		  }
	    }
}


































