/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;

/**
 * 机柜视图DAO接口
 * 
 * @author 
 */
public interface SOC0603DAO extends BaseHibernateDAO<SOC0603Info> {

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0603SearchCond cond);

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0603Info> findByCond(final SOC0603SearchCond cond, final int start, final int count);
	
	/**
	 * 条件检索处理：检索空调和UPS
	 * 
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<SOC0603Info> findBySOC0603Info(final SOC0603SearchCond cond);
}
