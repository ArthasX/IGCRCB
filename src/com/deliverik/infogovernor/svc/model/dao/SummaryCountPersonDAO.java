/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 人员工作量统计DAo接口
 * </p>
 */
public interface SummaryCountPersonDAO extends BaseHibernateDAO{

	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond);
}
