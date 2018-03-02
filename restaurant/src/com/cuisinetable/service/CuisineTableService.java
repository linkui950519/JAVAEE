package com.cuisinetable.service;

import java.util.List;

import com.cuisine.beans.Cuisine;
import com.cuisinetable.beans.CuisineTable;
import com.utils.Page;

public interface CuisineTableService {
	/**
	 * 
	* @Description: 查询所有
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public List<CuisineTable> getALLCuisineTable();
   
    /**
     * 
    * @Description: 查询制定页数的数据
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:54:27 
    * @version V1.0
     */
    public	Page<CuisineTable> findCuisinePage(int pageno);
    public	List<CuisineTable> findCuisinePage(String name );

    
	/**
	 * 
	* @Description: 查询一个
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  CuisineTable  getONECuisineTable(int id);
    
    
    /**
     * 
    * @Description: 页面根据菜系搜索
    * @author 柴含冰   
    * @date 2017年12月24日 下午6:58:06 
    * @version V1.0
     */
    public  List<CuisineTable>   getCuisineTable(String name);
    /**
     * 
    * @Description: 修改
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:31 
    * @version V1.0
     */
   
    public boolean updateCuisineTable(Integer id  );
    public boolean updateCuisineTable1(Integer id  );

    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */
    public boolean deleteCuisineTable(int id);
    /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */
    public boolean addCuisineTable(CuisineTable aCuisineTable);

	
}
