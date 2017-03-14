/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG100Info;
import com.deliverik.framework.workflow.prd.model.IG881Info;
import com.deliverik.framework.workflow.prd.model.condition.IG100SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG881SearchCond;

/**
 * 
 * 流程参与者变量权限DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG881DAO extends BaseHibernateDAO<IG881Info>{
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG881Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG881Info findByPK(Serializable pipdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG881SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG881Info> findByCond(final IG881SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理
	 * 
	 * @param cond检索条件
	 * @return 检索结果列表
	 */
	public List<IG100Info> findByCond(final IG100SearchCond cond);
	
	/**
	 * PIPDID主键值取得
	 * 
	 * @param 流程状态参与者定义ID
	 * @return PIPDID主键值
	 */
	public String getPipdidSequenceNextValue(String ppdid);
	
}
