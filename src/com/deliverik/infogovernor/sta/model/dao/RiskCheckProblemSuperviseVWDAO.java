/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sta.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCond;

/**
  * 概述: 问题整改监督DAO接口
  * 功能描述: 问题整改监督DAO接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface RiskCheckProblemSuperviseVWDAO extends BaseHibernateDAO<RiskCheckProblemSuperviseVWInfo> {

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findAll();

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public RiskCheckProblemSuperviseVWInfo findByPK(Serializable pk);

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final RiskCheckProblemSuperviseVWSearchCond cond);

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findByCond(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,
			final int count);
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public List<RiskCheckProblemSuperviseVWInfo> findRiskCheckProblemSupervise(
			final RiskCheckProblemSuperviseVWSearchCond cond, final int start,final int count);
	
	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	public int findRiskCheckProblemSuperviseSearchCount(
			final RiskCheckProblemSuperviseVWSearchCond cond);

}