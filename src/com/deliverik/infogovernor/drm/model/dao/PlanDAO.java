/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.condition.PlanSearchCond;

/**
  * 概述: cicollecttaskDAO接口
  * 功能描述: cicollecttaskDAO接口
  * 创建记录: 2013/07/05
  * 修改记录: 
  */
public interface PlanDAO extends BaseHibernateDAO<PlanInfo> {


	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<PlanInfo> findByCond(PlanSearchCond cond, int start, int count);

	
	public Integer getSearchCount(PlanSearchCond cond);
	
	
	

}