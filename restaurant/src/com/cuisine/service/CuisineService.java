package com.cuisine.service;

import java.util.List;

import com.cuisine.beans.Cuisine;
import com.utils.Page;

public interface CuisineService {
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public List<Cuisine> getALLCuisine();
   
    /**
     * 
    * @Description: 查询制定页数的数据
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:54:27 
    * @version V1.0
     */
    public	Page<Cuisine> findCuisinePage(int pageno);
    public	List<Cuisine> findCuisinePage(String name );

    
	/**
	 * 
	* @Description: 查询一个
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Cuisine  getONECuisine(int id);
    
    
    /**
     * 
    * @Description: 页面根据菜系搜索
    * @author 柴含冰   
    * @date 2017年12月24日 下午6:58:06 
    * @version V1.0
     */
    public  List<Cuisine>   getCuisine(String name);
    /**
     * 
    * @Description: 修改
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:31 
    * @version V1.0
     */
   
    public boolean updateCuisine( Integer id ,String name );
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */
    public boolean deleteCuisine(int id);
    /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */
    public boolean addCuisine(Cuisine aCuisine);

	
}
