/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prd.model.IG286Info;
import com.deliverik.framework.workflow.prd.model.condition.IG286SearchCond;

/**
 * <p>概述:流程级联表单处理DAO接口</p>
 * <p>功能描述：1.条件检索处理</p>
 *        
 * <p>创建记录：</p>
 */
public interface IG286DAO extends BaseHibernateDAO<IG286Info> {
	
	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG286Info> findByCond(final IG286SearchCond cond, final int start, final int count);
	
	/**
	 * PLID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PLID主键值
	 */
	public String getPlidSequenceNextValue(String pdid);
}
