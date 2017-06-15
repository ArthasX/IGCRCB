/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.framework.workflow.prr.model.condition.IG160SearchCond;

/**
 * <p>概述:流程相关人员汇总统计查询DAO接口</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>创建记录：</p>
 */

public interface IG160DAO extends BaseHibernateDAO<IG160Info> {

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG160Info> findByCond(final IG160SearchCond cond, final int start, final int count);

}
