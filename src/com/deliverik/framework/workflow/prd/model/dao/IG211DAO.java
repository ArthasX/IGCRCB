/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG211Info;
import com.deliverik.framework.workflow.prd.model.condition.IG211SearchCond;

/**
 * 
 * 流程状态变量前处理DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG211DAO extends BaseHibernateDAO<IG211Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG211Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG211Info findByPK(Serializable psidid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG211SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG211Info> findByCond(final IG211SearchCond cond, final int start, final int count);
	
	/**
	 * PSIDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PSIDID主键值
	 */
	public String getPsididSequenceNextValue(String psdid);
	
}
