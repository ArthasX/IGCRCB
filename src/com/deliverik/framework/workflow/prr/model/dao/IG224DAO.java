/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG224Info;
import com.deliverik.framework.workflow.prr.model.condition.IG224SearchCond;

/**
 * 流程状态日志实体DAO接口
 * 
 */
public interface IG224DAO extends BaseHibernateDAO<IG224Info> {

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<IG224Info> findAll();

	/**
	 * 主键检索处理
	 * @param rslid 主键
	 * @return 检索结果
	 */
	public IG224Info findByPK(Serializable rslid);
	

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG224SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> findByCond(final IG224SearchCond cond, final int start, final int count);
	/**
	 * 条件检索处理 dashboard 数据初始化专用
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG224Info> findByCondOrderByRslopentime(final IG224SearchCond cond);
	
}
