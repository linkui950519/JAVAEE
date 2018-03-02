package com.preorder.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.INTERNAL;

import com.cuisine.beans.Cuisine;
import com.preorder.beans.Preorder;

public interface PreorderDao {
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
    public List<Preorder> getALLPreorder();
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Preorder  getONEPreorder(int id);
    
	/**
	 * 
	 * @param pageStartIndex 起始索引
	 * @param pageSize 页面大小
	 * @return 当前页所包含的所有栏目信息
	 */
	List<Preorder> selectCurrentPgaePreorder(Map<String, Object> map);
	List<Preorder> selectCurrentPgaePreorder1(@Param("name")String name);

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
   
    public Integer updatePreorder(Integer id );
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */ 
    public Integer deletePreorder(int id);
     /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */ 
    public Integer addPreorder(Preorder aPreorder);
}
