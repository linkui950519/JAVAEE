package com.cuisine.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cuisine.beans.Cuisine;

public interface CuisineDao {
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
    public List<Cuisine> getALLCuisine();
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Cuisine  getONECuisine(int id);
    
	/**
	 * 
	 * @param pageStartIndex 起始索引
	 * @param pageSize 页面大小
	 * @return 当前页所包含的所有栏目信息
	 */
	List<Cuisine> selectCurrentPgaeCuisine(Map<String, Object> map);
	List<Cuisine> selectCurrentPgaeCuisine1(@Param("name")String name);

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
   
    public Integer updateCuisine( Cuisine aCuisine);
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */ 
    public Integer deleteCuisine(int id);
     /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */ 
    public Integer addCuisine(Cuisine aCuisine);
     /**
      * 
     * @Description: 页面搜索功能
     * @author 柴含冰   
     * @date 2017年12月24日 下午6:59:14 
     * @version V1.0
      */
    public  List<Cuisine> getCuisine(String cuisinename) ;
	
}
