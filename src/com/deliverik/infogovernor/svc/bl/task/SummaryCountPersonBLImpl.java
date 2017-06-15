/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;
import com.deliverik.infogovernor.svc.model.dao.SummaryCountPersonDAO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class SummaryCountPersonBLImpl extends BaseBLImpl implements SummaryCountPersonBL{

	/** 人员工作量统计DAO */
	protected SummaryCountPersonDAO summaryCountPersonDAO;


	
	/** 设置人员工作量统计DAO */
	public void setSummaryCountPersonDAO(SummaryCountPersonDAO summaryCountPersonDAO) {
		this.summaryCountPersonDAO = summaryCountPersonDAO;
	}



	/**
	 * 查询统计数据
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond){
		
		return summaryCountPersonDAO.searchSummary(cond);
	}



}
