/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.SOC0136Info;
import com.deliverik.framework.soc.asset.SOC0138Info;
import com.deliverik.framework.soc.asset.model.SOC0126Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0126SearchCond;

/**
 * 概述: 资产域明细表业务逻辑接口
 * 功能描述: 资产域明细表业务逻辑接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface SOC0126BL extends BaseBL {
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(SOC0126SearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<SOC0126Info> searchEiDomainDetailVW(
			SOC0126SearchCond cond);

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
			int count);
	
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
			int count);
	
	/**
	 * 根据影响CI查询条数
	 * @param eiDomainDetailVWSearchCond
	 * @return
	 */
	public int getSearchCountCI(
			SOC0126SearchCond eiDomainDetailVWSearchCond,Integer eiid);

	/**
	 * 根据影响CI查询
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCI(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			int fromCount, int pageDispCount,Integer eiid);

	/**
	 * 根据硬盘检索主机条数
	 * @param eiDomainDetailVWSearchCond
	 * @param eiid
	 * @return
	 */
	public int getSearchCountCIByDisk(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			Integer eiid);

	/**
	 * 根据硬盘检索主机信息
	 * @param eiDomainDetailVWSearchCond
	 * @param fromCount
	 * @param pageDispCount
	 * @param eiid
	 * @return
	 */
	public List<SOC0136Info> searchEiDomainDetailVWCIByDisk(
			SOC0126SearchCond eiDomainDetailVWSearchCond,
			int fromCount, int pageDispCount, Integer eiid);

}
