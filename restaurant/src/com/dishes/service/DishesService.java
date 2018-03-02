package com.dishes.service;

import java.util.List;
import java.util.Map;

import com.dishes.beans.Dishes;
import com.utils.Page;
 
public interface DishesService {
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public List<Dishes> getALLDishes();
   
    /**
     * 
    * @Description: 查询制定页数的数据
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:54:27 
    * @version V1.0
     */
    public	Page<Dishes> findDishesPage(int pageno);
    public	List<Dishes> findDishesPage(String name );

    
	/**
	 * 
	* @Description: 查询一个
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Dishes  getONEDishes(int id);
    
    
    /**
     * 
    * @Description: 页面根据菜系搜索
    * @author 柴含冰   
    * @date 2017年12月24日 下午6:58:06 
    * @version V1.0
     */
    public  List<Dishes>   getDishes(String name);
    /**
     * 
    * @Description: 修改
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:31 
    * @version V1.0
     */
   
    public boolean updateDishes(Dishes aDishes );
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */
    public boolean deleteDishes(int id);
    /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */
    public boolean addDishes(Dishes aDishes);

    
    /**
     * 
    * @Description: 增加查询
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */
	public List<Map<Integer, String>> getCuisine();



	


}
