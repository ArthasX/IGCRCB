/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.asset.EiDomainDetailCIInfo;
import com.deliverik.framework.asset.model.EiDomainDetailMaxVWInfo;
import com.deliverik.framework.asset.model.condition.EiDomainDetailMaxVWSearchCond;
import com.deliverik.framework.asset.model.dao.EiDomainDetailMaxVWDAO;
import com.deliverik.framework.base.BaseBLImpl;

/**
 * 概述: 资产域明细表业务逻辑实现
 * 功能描述: 资产域明细表业务逻辑实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class EiDomainDetailMaxVWBLImpl extends BaseBLImpl implements
EiDomainDetailMaxVWBL {
	
	/** 资产域明细表DAO接口 */
	protected EiDomainDetailMaxVWDAO eiDomainDetailMaxVWDAO;
	
	
	
	/**
	 * 资产域明细表DAO接口设定
	 * @param eiDomainDetailMaxVWDAO资产域明细表DAO接口
	 */
	public void seteiDomainDetailMaxVWDAO(EiDomainDetailMaxVWDAO eiDomainDetailMaxVWDAO) {
		this.eiDomainDetailMaxVWDAO = eiDomainDetailMaxVWDAO;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(EiDomainDetailMaxVWSearchCond cond) {
		return eiDomainDetailMaxVWDAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailMaxVWInfo> searchEiDomainDetailVW(
			EiDomainDetailMaxVWSearchCond cond) {
		return eiDomainDetailMaxVWDAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<EiDomainDetailMaxVWInfo> searchEiDomainDetailVW(
			EiDomainDetailMaxVWSearchCond cond, int start,
			int count) {
		return eiDomainDetailMaxVWDAO.findBySQL(cond, start, count);
	}

	/**
	 * 根据影响CI查询条数
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			EiDomainDetailMaxVWSearchCond cond) {
		return  eiDomainDetailMaxVWDAO.getSearchCountCI(cond);
	}

	/**
	 * 根据影响CI查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<EiDomainDetailCIInfo> searchEiDomainDetailVWCI(
			EiDomainDetailMaxVWSearchCond cond,
			int start, int count) {
		return eiDomainDetailMaxVWDAO.findBySQLCI(cond, start, count);
	}


}
