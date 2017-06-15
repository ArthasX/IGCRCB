/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dbm.model.condition.ScienceOperationReportSearchCond;
import com.deliverik.infogovernor.dbm.model.dao.ScienceOperationReportDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 科技运行统计分析BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class ScienceOperationReportBLImpl extends BaseBLImpl implements
		ScienceOperationReportBL {

	/** 科技运行统计分析DAO */
	protected ScienceOperationReportDAO scienceOperationReportDAO;

	/**
	 * 科技运行统计分析DAO设定
	 * @param scienceOperationReportDAO 科技运行统计分析DAO
	 */
	public void setScienceOperationReportDAO(
			ScienceOperationReportDAO scienceOperationReportDAO) {
		this.scienceOperationReportDAO = scienceOperationReportDAO;
	}
	
	/**
	 * 按照表单值查询各个值所占的数量
	 * @param cond
	 * @return
	 */
	public List<Object[]> getWorkOrderAction(ScienceOperationReportSearchCond cond){
		return scienceOperationReportDAO.getWorkOrderAction(cond);
	}
}
