/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.ReportFileDefinition;
import com.deliverik.infogovernor.sym.model.condition.ReportFileDefinitionSearchCond;

/**
 * 报表定义DAO接口
 */
public interface ReportFileDefinitionDAO extends BaseHibernateDAO<ReportFileDefinition> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ReportFileDefinition> findAll();

	/**
	 * 主键检索处理
	 * @param rdid 主键
	 * @return 检索结果
	 */
	public ReportFileDefinition findByPK(Serializable rdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ReportFileDefinitionSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileDefinition> findByCond(final ReportFileDefinitionSearchCond cond, final int start, final int count);
}
