/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;
import com.deliverik.framework.soc.asset.model.dao.CicollecttaskDAO;

/**
  * 概述: cicollecttask业务逻辑实现
  * 功能描述: cicollecttask业务逻辑实现
  * 创建记录: 2013/07/05 王省
  * 修改记录: 
  */
public class CicollecttaskBLImpl extends BaseBLImpl implements
		CicollecttaskBL {

	/** cicollecttaskDAO接口 */
	protected CicollecttaskDAO cicollecttaskDAO;
	
	/**
	 * cicollecttaskDAO接口设定
	 *
	 * @param cicollecttaskDAO cicollecttaskDAO接口
	 */
	public void setCicollecttaskDAO(CicollecttaskDAO cicollecttaskDAO) {
		this.cicollecttaskDAO = cicollecttaskDAO;
	}



	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(CicollecttaskSearchCond cond) {
		return cicollecttaskDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond) {
		return cicollecttaskDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CicollecttaskInfo> searchCicollecttask(
			CicollecttaskSearchCond cond, int start,
			int count) {
		return cicollecttaskDAO.findByCond(cond, start, count);
	}



	
	public List<CicollecttaskInfo> findAllByCollectType(String collectType)
			throws Exception {

		return null;
	}
	
	public List<Integer> findResourceidByType(int type) throws Exception {
		return new ArrayList<Integer>();
	}
	
	public List<Integer> getTypeIdByName(final List<String> names){
		return cicollecttaskDAO.getTypeIdByName(names);
	}
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids){
		return cicollecttaskDAO.getResourceIdByType(typeids);
	}

	public List<String> getHQPlateformNameList() throws Exception {
		return cicollecttaskDAO.getPlateformNameList();
	}

}