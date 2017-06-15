/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.soc.cim.model.IG500VWInfo;
import com.deliverik.infogovernor.soc.cim.model.condition.IG500VWSearchCond;

/**
 * 
 * 资产相关流程dao接口
 * 
 */
public interface IG500VWDAO extends BaseHibernateDAO<IG500VWInfo> {
	/**
	 * 条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public List<IG500VWInfo> findByCond(final IG500VWSearchCond cond);
}
