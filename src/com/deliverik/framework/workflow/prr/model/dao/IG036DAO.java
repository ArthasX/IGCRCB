/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG036Info;
import com.deliverik.framework.workflow.prr.model.condition.IG036SearchCond;

/**
 * <p>概述:日志信息DAO接口</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>创建记录：</p>
 */
public interface IG036DAO extends BaseHibernateDAO<IG036Info> {

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG036Info> findAll();

	/**
	 * 功能：主键检索处理
	 * @param rlid 主键
	 * @return 检索结果
	 */
	public IG036Info findByPK(Serializable rlid);

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG036Info> findByCond(final IG036SearchCond cond, final int start, final int count);

}
