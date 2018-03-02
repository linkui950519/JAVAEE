package com.dishes.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine.dao.CuisineDao;
import com.dishes.beans.Dishes;
import com.dishes.dao.DishesDao;
import com.dishes.service.DishesService;
import com.utils.Constants;
import com.utils.Page;
import com.utils.PubFun;
@Service
public class DishesServiceImpl implements DishesService{

	@Autowired
	private DishesDao dao;
	 

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Dishes> getALLDishes() {
		// 查询service不做逻辑判断直接返回
		return dao.getALLDishes();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Page<Dishes> findDishesPage(int pageno) {
		// TODO Auto-generated method stub
		Page<Dishes> page = new Page<>(pageno, Constants.PAGE_SIZE);
		// 查询出总记录数
		Integer totalRows = dao.selectAllRows();
		page.setTotalRows(totalRows);
		int pageStartIndex = page.getPageStartIndex();
		int pageSize = page.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("pageStartIndex", pageStartIndex);
		map.put("pageSize", pageSize);

		List<Dishes> datas = dao.selectCurrentPgaeDishes(map);
		page.setDatas(datas);
		return page;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Dishes> getDishes (String name) {
		List<Dishes> cuisine = dao.getDishes(name);
		return cuisine;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Dishes getONEDishes(int id) {
		Dishes oneDishes = dao.getONEDishes(id);
		return oneDishes;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean updateDishes(Dishes aDishes) {
		aDishes.setModifydate(PubFun.getDate());
		aDishes.setModifytime(PubFun.getTime());
		if (dao.updateDishes(aDishes) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deleteDishes(int id) {
		Integer deleteDishes = dao.deleteDishes(id);
		if (deleteDishes > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// @Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public boolean addDishes(Dishes aDishes) {
		// 获取当前最大ID；

		// 给aDishes赋值
		aDishes.setID(dao.getMaxID() + 1);
		aDishes.setFlag(0);
		aDishes.setMakedate(PubFun.getDate());
		aDishes.setMaketime(PubFun.getTime());
		aDishes.setModifydate(PubFun.getDate());
		aDishes.setModifytime(PubFun.getTime());
 		Integer addDishes = dao.addDishes(aDishes);
		if (addDishes > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Dishes> findDishesPage(String name) {
		System.out.println("2222222");
		List<Dishes> datas = dao.getDishes(name);
		System.out.println("3333333");
		return datas;
	}
	
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Map<Integer, String>> getCuisine() {
	  List<Map<Integer, String>> cuisine = dao.getCuisine();
		return cuisine;
	}

}
