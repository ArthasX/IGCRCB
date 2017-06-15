package com.csebank.lom.model.dao;


/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */


import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.condition.DealVWSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * 
 * 外出就餐管理DAO接口
 *
 */
public interface DealVWDAO extends BaseHibernateDAO<DealVWInfo> {


	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<DealVWInfo> findByCond(final DealVWSearchCond cond, final int start, final int count);
	

}
