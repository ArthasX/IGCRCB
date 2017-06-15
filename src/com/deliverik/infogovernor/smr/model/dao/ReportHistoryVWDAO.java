/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.smr.model.ReportHistoryVWInfo;
import com.deliverik.infogovernor.smr.model.condition.ReportHistoryVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表历史填报记录视图DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportHistoryVWDAO extends BaseHibernateDAO<ReportHistoryVWInfo>{

	/**
	 * 条件检索
	 * @param cond 检索条件
	 * @return 检索结果
	 */
	public List<ReportHistoryVWInfo> findByCond(final ReportHistoryVWSearchCond cond);
}
