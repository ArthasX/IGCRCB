/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prj.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.prj.model.Pbsummary;
import com.deliverik.infogovernor.prj.model.condition.PbsummaryVWSearchCond;


/**
 * <p>概述:预算及工程分类信息视图DAO接口</p>
 * <p>功能描述：1.条件检索处理</p>
 * <p>创建记录：</p>
 */

public interface PbsummaryVWDAO extends BaseHibernateDAO<Pbsummary>{
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Pbsummary> findByCond(final PbsummaryVWSearchCond cond, final int start, final int count);
}
