package com.dishes.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.dishes.beans.Dishes;


public interface DishesDao {
	/**
	 * 
	 * @return 所有记录数
	 */
	Integer selectAllRows();
	
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public List<Dishes> getALLDishes() ;
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Dishes  getONEDishes(int id);
    
	/**
	 * 
	 * @param pageStartIndex 起始索引
	 * @param pageSize 页面大小
	 * @return 当前页所包含的所有栏目信息
	 */
	List<Dishes> selectCurrentPgaeDishes(Map<String, Object> map);
	List<Dishes> selectCurrentPgaeDishes1(@Param("name")String name);

	/**
	 * 
	 * @return 获取最大ID
	 */
	Integer getMaxID();
   /* *//**
     * 
    * @Description: 修改
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:31 
    * @version V1.0
     */ 
   
    public Integer updateDishes( Dishes aDishes);
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */ 
    public Integer deleteDishes(int id);
     /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */ 
    public Integer addDishes(Dishes aCuisine);
     /**
      * 
     * @Description: 页面搜索功能
     * @author 柴含冰   
     * @date 2017年12月24日 下午6:59:14 
     * @version V1.0
      */
    public  List<Dishes> getDishes(String cuisinename) ;

    /**
     * 
    * @Description: 页面搜索功能
    * @author 柴含冰   
    * @date 2017年12月24日 下午6:59:14 
    * @version V1.0
     */ 
    public  List<Map<Integer, String>> getCuisine() ;


	
}
