/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0126DAO;

/**
 * 概述: 资产域明细表业务逻辑实现
 * 功能描述: 资产域明细表业务逻辑实现
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public class SOC0126BLImpl extends BaseBLImpl implements
SOC0126BL {
	
	/** 资产域明细表DAO接口 */
	protected SOC0126DAO soc0126DAO;
	
	

	/**
	 * 资产域明细表DAO接口设定
	 *
	 * @param soc0126DAO 资产域明细表DAO接口
	 */
	public void setSoc0126DAO(SOC0126DAO soc0126DAO) {
		this.soc0126DAO = soc0126DAO;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0126SearchCond cond) {
		return soc0126DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0126Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond) {
		return soc0126DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0138Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond, int start,
			int count) {
		return soc0126DAO.findBySQL(cond, start, count);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @param start检索记录起始行号
	 * @param count检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0126Info> searchEiDomainDetailAllVW(
			SOC0126SearchCond cond, int start,
			int count) {
		return soc0126DAO.findAllBySQL(cond, start, count);
	}

	
	/**
	 * 根据影响CI查询条数
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			SOC0126SearchCond cond,Integer eiid) {
		return  soc0126DAO.getSearchCountCI(cond,eiid);
	}

	/**
	 * 根据影响CI查询
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCI(
			SOC0126SearchCond cond,
			int start, int count,Integer eiid) {
		return soc0126DAO.findBySQLCI(cond, start, count,eiid);
	}

	/**
	 * 根据硬盘检索主机条数
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(
			SOC0126SearchCond cond,
			Integer eiid) {
		return soc0126DAO.getSearchCountCIByDisk(cond,eiid);
	}

	/**
	 * 根据硬盘检索主机信息
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			SOC0126SearchCond cond,
			int start, int count, Integer eiid) {
		return soc0126DAO.searchEiDomainDetailVWCIByDisk(cond, start, count,eiid);
	}


}
