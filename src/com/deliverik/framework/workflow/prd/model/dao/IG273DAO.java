/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG273Info;
import com.deliverik.framework.workflow.prd.model.condition.IG273SearchCond;

/**
 * 
 * 流程状态跃迁规则DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG273DAO extends BaseHibernateDAO<IG273Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG273Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG273Info findByPK(Serializable ptdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG273SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG273Info> findByCond(final IG273SearchCond cond, final int start, final int count);
	
	/**
	 * PTDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PTDID主键值
	 */
	public String getPtdidSequenceNextValue(String psdid);
	
}
