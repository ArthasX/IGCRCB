/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.vir.model.VIM03CountByUserVWInfo;
import com.deliverik.infogovernor.soc.vir.model.condition.VIM03CountByUserVWSearchCond;
/**
 * 虚拟化统计分析
 *
 */
public interface VIM03CountByUserVWDAO extends BaseHibernateDAO<VIM03CountByUserVWInfo> {

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<VIM03CountByUserVWInfo> findByCond(final VIM03CountByUserVWSearchCond cond, final int start, final int count);
}
