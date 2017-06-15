/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG933Info;
import com.deliverik.framework.workflow.prr.model.condition.IG692SearchCond;

/**
 * <p>
 *  概述:服务工单统计DAO接口
 * </p>
 * <p>
 *  创建记录: 杨亮 2010/10/28 服务工单统计DAO接口
 * </p>
 */
public interface IG692DAO extends BaseHibernateDAO<IG933Info> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<List<String>> findByCond(
			final IG692SearchCond cond, final int start,final int count);
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<List<String>> findByCond2(
			final IG692SearchCond cond, final int start,final int count);

}
