package com.preorder.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.preorder.beans.Preorder;
import com.preorder.dao.PreorderDao;
import com.preorder.service.PreorderService;
import com.utils.Constants;
import com.utils.Page;
import com.utils.PubFun;

@Service
public class PreorderServiceImpl implements PreorderService {
	@Autowired
	private PreorderDao dao;

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public List<Preorder> getALLPreorder() {
		// 查询service不做逻辑判断直接返回
		return dao.getALLPreorder();
	}

	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Page<Preorder> findPreorderPage(int pageno) {
		// TODO Auto-generated method stub
		Page<Preorder> page = new Page<>(pageno, Constants.PAGE_SIZE);
		// 查询出总记录数
		Integer totalRows = dao.selectAllRows();
		page.setTotalRows(totalRows);
		int pageStartIndex = page.getPageStartIndex();
		int pageSize = page.getPageSize();
		Map<String, Object> map = new HashMap<>();
		map.put("pageStartIndex", pageStartIndex);
		map.put("pageSize", pageSize);

		List<Preorder> datas = dao.selectCurrentPgaePreorder(map);
		page.setDatas(datas);
		return page;
	}
	@Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public Preorder getONEPreorder(int id) {
		Preorder onePreorder = dao.getONEPreorder(id);
		return onePreorder;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean updatePreorder(Integer id ) {
		 
	//	aPreorder.setPreordername(name);
		if (dao.updatePreorder(id) > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public boolean deletePreorder(int id) {
		Integer deletePreorder = dao.deletePreorder(id);
		if (deletePreorder > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	// @Transactional(readOnly = true, rollbackFor = Exception.class)
	@Override
	public boolean addPreorder(Preorder aPreorder) {
		// 获取当前最大ID；

		// 给Preorder赋值
		aPreorder.setID(dao.getMaxID() + 1);
		aPreorder.setFlag(0);
		aPreorder.setMakedate(PubFun.getDate());
		aPreorder.setMaketime(PubFun.getTime());
		aPreorder.setModifydate(PubFun.getDate());
		aPreorder.setModifytime(PubFun.getTime());
 		Integer addPreorder = dao.addPreorder(aPreorder);
		if (addPreorder > 0) {
			return true;
		} else {
			return false;
		}
	}
 
 
}
