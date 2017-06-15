/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:科技运行统计分析DAO接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ScienceOperationReportDAO extends BaseHibernateDAO<Object>{

	/**
	 * 按照表单值查询各个值所占的数量
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(final ScienceOperationReportSearchCond cond);
}
