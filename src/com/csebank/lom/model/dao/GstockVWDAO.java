/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.util.List;

import com.csebank.lom.model.GstockVWInfo;
import com.csebank.lom.model.condition.GstockVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 库存预警信息视图DAO接口
 *
 */
public interface GstockVWDAO extends BaseHibernateDAO<GstockVWInfo> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<GstockVWInfo> findByCond(final GstockVWSearchCond cond, final int start, final int count);
	
}
