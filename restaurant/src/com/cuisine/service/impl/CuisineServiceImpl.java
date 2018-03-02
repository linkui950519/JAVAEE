package com.cuisine.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine.beans.Cuisine;
import com.cuisine.dao.CuisineDao;
import com.cuisine.service.CuisineService;
import com.utils.Constants;
import com.utils.Page;
import com.utils.PubFun;

@Service
public class CuisineServiceImpl implements CuisineService {
	@Autowired
	private CuisineDao dao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Cuisine> getALLCuisine() {
		// 查询service不做逻辑判断直接返回
		return dao.getALLCuisine();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Page<Cuisine> findCuisinePage(int pageno) {
		// TODO Auto-generated method stub
		Page<Cuisine> page = new Page<>(pageno, Constants.PAGE_SIZE);
		// 查询出总记录数
		Integer totalRows = dao.selectAllRows();
		page.setTotalRows(totalRows);
		int pageStartIndex = page.getPageStartIndex();
		int pageSize = page.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("pageStartIndex", pageStartIndex);
		map.put("pageSize", pageSize);

		List<Cuisine> datas = dao.selectCurrentPgaeCuisine(map);
		page.setDatas(datas);
		return page;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Cuisine> getCuisine(String name) {
		List<Cuisine> cuisine = dao.getCuisine(name);
		return cuisine;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Cuisine getONECuisine(int id) {
		Cuisine oneCuisine = dao.getONECuisine(id);
		return oneCuisine;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean updateCuisine(Integer id, String name) {
		Cuisine aCuisine = new Cuisine();
		aCuisine.setID(id);
		aCuisine.setCuisinename(name);
		if (dao.updateCuisine(aCuisine) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deleteCuisine(int id) {
		Integer deleteCuisine = dao.deleteCuisine(id);
		if (deleteCuisine > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// @Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public boolean addCuisine(Cuisine aCuisine) {
		// 获取当前最大ID；

		// 给Cuisine赋值
		aCuisine.setID(dao.getMaxID() + 1);
		aCuisine.setFlag(0);
		aCuisine.setMakedate(PubFun.getDate());
		aCuisine.setMaketime(PubFun.getTime());
		aCuisine.setModifydate(PubFun.getDate());
		aCuisine.setModifytime(PubFun.getTime());
 		Integer addCuisine = dao.addCuisine(aCuisine);
		if (addCuisine > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Cuisine> findCuisinePage(String name) {
		System.out.println("2222222");
		List<Cuisine> datas = dao.getCuisine(name);
		System.out.println("3333333");
		return datas;
	}
}
