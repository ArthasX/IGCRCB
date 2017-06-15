/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.sym.model.ReportFileVersion;
import com.deliverik.infogovernor.sym.model.condition.ReportFileVersionSearchCond;

/**
 * 报表版本DAO接口
 */
public interface ReportFileVersionDAO extends BaseHibernateDAO<ReportFileVersion> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<ReportFileVersion> findAll();

	/**
	 * 主键检索处理
	 * @param rdid 主键
	 * @return 检索结果
	 */
	public ReportFileVersion findByPK(Serializable rdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final ReportFileVersionSearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ReportFileVersion> findByCond(final ReportFileVersionSearchCond cond, final int start, final int count);
}
