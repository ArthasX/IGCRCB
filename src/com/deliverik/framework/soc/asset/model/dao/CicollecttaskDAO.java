/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.dao;

import java.math.BigInteger;
import java.util.List;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;
import com.deliverik.framework.soc.asset.model.condition.CicollecttaskSearchCond;

/**
  * 概述: cicollecttaskDAO接口
  * 功能描述: cicollecttaskDAO接口
  * 创建记录: 2013/07/05
  * 修改记录: 
  */
public interface CicollecttaskDAO extends BaseHibernateDAO<CicollecttaskInfo> {


	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<CicollecttaskInfo> findByCond(
			final CicollecttaskSearchCond cond, final int start,
			final int count);

	
	public Integer getSearchCount(CicollecttaskSearchCond cond);
	
	public List<Integer> getTypeIdByName(final List<String> names);
	
	public List<Integer> getResourceIdByType(final List<Integer> typeids);
	
	public List<String> getPlateformNameList()throws Exception;

}