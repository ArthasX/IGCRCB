/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG567Info;
import com.deliverik.framework.workflow.prd.model.condition.IG433SearchCond;

/**
 * 概述:流程参与流程评审视图DAO接口
 * 功能描述：
 *           
 * 创建记录：宋海洋    2010/11/26
 */
public interface IG567DAO extends
		BaseHibernateDAO<IG567Info> {

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG567Info> findByCond(final IG433SearchCond cond,final int start, final int count);

}
