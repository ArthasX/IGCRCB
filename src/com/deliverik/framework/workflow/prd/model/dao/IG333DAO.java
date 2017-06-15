/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;

/**
 * 
 * 流程状态定义DAO接口
 * @author maozhipeng@deliverik.com
 *
 */
public interface IG333DAO extends BaseHibernateDAO<IG333Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG333Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG333Info findByPK(Serializable psdid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG333SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG333Info> findByCond(final IG333SearchCond cond, final int start, final int count);
	
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPsdidSequenceNextValue(String pdid);
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 *
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	public List<IG333Info> searchAdjustStatus(final String psdid);
	
	/**
	 * 根据分派状态和分派按钮查询被分派节点集合
	 */
	public List<IG333Info> findByAssign(final IG333SearchCond cond);
	
}
