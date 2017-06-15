/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.com.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.com.model.ProcessInHandVWInfo;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCond;
import com.deliverik.infogovernor.com.model.condition.ProcessInHandVWInfoSearchCondImpl;

/**
 * 
 * 预支人员统计DAO
 * 
 */
public interface ProcessInHandSingleVWDAO extends BaseHibernateDAO<ProcessInHandVWInfo> {
	
	/**
	 * 我的工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInhand(
			final ProcessInHandVWInfoSearchCond cond,final int start, final int count, final boolean desc) ;
	
	/**
	 * 相关工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInhandGroup(
			final ProcessInHandVWInfoSearchCond cond,final int start,final int count, final boolean desc); 

	/**
	 * 中止工作检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<ProcessInHandVWInfo> searchProcessInhandDiscontinue(final ProcessInHandVWInfoSearchCondImpl cond,final boolean desc);
}
