/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.framework.workflow.prd.model.condition.IG731SearchCond;

/**
 * 
 * 流程资产关系DAO接口
 *
 */
public interface IG731DAO extends BaseHibernateDAO<IG731Info> {
	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG731Info> findAll();

	/**
	 * 主键检索处理
	 * @param psdid 主键
	 * @return 检索结果
	 */
	public IG731Info findByPK(Serializable psidid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG731SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG731Info> findByCond(final IG731SearchCond cond, final int start, final int count);
	
	
	/**
	 * 通过场景prid查询相关的业务系统资产
	 * @param prid
	 * @return 检索结果列表
	 */
	public List<IG731Info> searchIG731InfoBySePrid(final Integer prid,final String flowType);
	
	/**
	 * 根据流程prid查询场景的eiid
	 * @param prid 流程id
	 * @param flowType 流程类型
	 * @return
	 */
	public List<IG731Info> searchSenceBySePrid(final Integer prid,final String flowType);
}
