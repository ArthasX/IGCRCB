/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.SOC0502Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0502SearchCond;

/**
  * 概述: StorageEventVWDAO接口
  * 功能描述: StorageEventVWDAO接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0502DAO extends BaseHibernateDAO<SOC0502Info> {
	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SOC0502SearchCond cond);
	
	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<SOC0502Info> findByCond(final SOC0502SearchCond cond, final int start, final int count);
	
	
	public void deleteByRids(Integer[] rids);
	
}