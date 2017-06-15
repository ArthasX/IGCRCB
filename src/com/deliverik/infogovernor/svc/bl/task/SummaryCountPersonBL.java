/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG160Info;
import com.deliverik.infogovernor.svc.model.condition.SummaryCountPersonSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 */
public interface SummaryCountPersonBL extends BaseBL{

	/**
	 * 查询统计数据
	 * @param cond 检索条件
	 * @return
	 */
	public List<IG160Info> searchSummary(SummaryCountPersonSearchCond cond);
}
