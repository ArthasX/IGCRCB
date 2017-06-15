/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.condition.HWorkVWSearchCond;
import com.deliverik.framework.workflow.prd.model.entity.HWorkVW;

/**
 * 模块：历史工作统计-
 * 说明：历史工作统计DAO接口
 * 作者：zhaoyunli
 */
public interface HWorkVWDAO extends BaseHibernateDAO<HWorkVW> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<HWorkVW> findByCond(final HWorkVWSearchCond cond);

}
