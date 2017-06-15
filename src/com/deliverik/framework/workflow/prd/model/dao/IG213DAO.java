/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG213Info;
import com.deliverik.framework.workflow.prd.model.condition.IG213SearchCond;

/**
 * 
 * 流程角色类型定义DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG213DAO extends BaseHibernateDAO<IG213Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG213Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG213Info findByPK(Serializable prtdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG213SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG213Info> findByCond(final IG213SearchCond cond, final int start, final int count);
	
	/**
	 * PRTDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PRTDID主键值
	 */
	public String getPrtdidSequenceNextValue(String pdid);
	
}
