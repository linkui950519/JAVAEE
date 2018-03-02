package com.preorder.service;

import java.util.List;

import com.preorder.beans.Preorder;
import com.utils.Page;

public interface PreorderService {
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
    * @Description: 查询制定页数的数据
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:54:27 
    * @version V1.0
     */
    public	Page<Preorder> findPreorderPage(int pageno);
 //   public	List<Preorder> findPreorderPage(String name );

    
	/**
	 * 
	* @Description: 查询一个
	* @author 柴含冰   
	* @date 2017年12月24日 下午1:47:12 
	* @version V1.0
	 */
    public  Preorder  getONEPreorder(int id);
     
    /**
     * 
    * @Description: 修改
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:31 
    * @version V1.0
     */
   
    public boolean updatePreorder( Integer id );
    /**
     * 
    * @Description: 删除 
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:43 
    * @version V1.0
     */
    public boolean deletePreorder(int id);
    /**
     * 
    * @Description: 增加
    * @author 柴含冰   
    * @date 2017年12月24日 下午1:47:53 
    * @version V1.0
     */
    public boolean addPreorder(Preorder aPreorder);

	
}
