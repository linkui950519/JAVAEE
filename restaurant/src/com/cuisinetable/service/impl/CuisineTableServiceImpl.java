package com.cuisinetable.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cuisine.beans.Cuisine;
import com.cuisinetable.beans.CuisineTable;
import com.cuisinetable.dao.CuisineTableDao;
import com.cuisinetable.service.CuisineTableService;
import com.utils.Constants;
import com.utils.Page;
import com.utils.PubFun;

@Service
public class CuisineTableServiceImpl implements CuisineTableService {
	@Autowired
	private CuisineTableDao dao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<CuisineTable> getALLCuisineTable() {
		// 查询service不做逻辑判断直接返回
		return dao.getALLCuisineTable();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Page<CuisineTable> findCuisinePage(int pageno) {
		// TODO Auto-generated method stub
		Page<CuisineTable> page = new Page<>(pageno, Constants.PAGE_SIZE);
		// 查询出总记录数
		Integer totalRows = dao.selectAllRows();
		page.setTotalRows(totalRows);
		int pageStartIndex = page.getPageStartIndex();
		int pageSize = page.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("pageStartIndex", pageStartIndex);
		map.put("pageSize", pageSize);
		List<CuisineTable> datas = dao.selectCurrentPgaeCuisineTable(map);
		page.setDatas(datas);
		return page;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<CuisineTable> getCuisineTable(String name) {
		List<CuisineTable> cuisineTable = dao.getCuisineTable(name);
		return cuisineTable;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public CuisineTable getONECuisineTable(int id) {
		CuisineTable oneCuisineTable = dao.getONECuisineTable(id);
		return oneCuisineTable;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean updateCuisineTable(Integer id) {
		 
		 Integer updateCuisineTable = dao.updateCuisineTable(id);
		if (updateCuisineTable > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean updateCuisineTable1(Integer id) {
		 
		 Integer updateCuisineTable = dao.updateCuisineTable1(id);
		if (updateCuisineTable > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deleteCuisineTable(int id) {
		Integer deleteCuisineTable = dao.deleteCuisineTable(id);
		if (deleteCuisineTable > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// @Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public boolean addCuisineTable(CuisineTable aCuisine) {
		// 获取当前最大ID；

		// 给Cuisine赋值
		aCuisine.setID(dao.getMaxID() + 1);
		aCuisine.setFlag(0);
		aCuisine.setMakedate(PubFun.getDate());
		aCuisine.setMaketime(PubFun.getTime());
		aCuisine.setModifydate(PubFun.getDate());
		aCuisine.setModifytime(PubFun.getTime());
 		Integer addCuisine = dao.addCuisineTable(aCuisine);
		if (addCuisine > 0) {
			return true;
		} else {
			return false;
		}
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<CuisineTable> findCuisinePage(String name) {
		System.out.println("2222222");
		List<CuisineTable> datas = dao.getCuisineTable(name);
		System.out.println("3333333");
		return datas;
	}
}
