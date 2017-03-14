/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;
import com.deliverik.infogovernor.svc.model.condition.AnnualTrendVWSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计BL接口
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
public interface AnnualTrendVWBL extends BaseBL{

	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public List<AnnualTrendVWInfo> searchIncidentTypeData(AnnualTrendVWSearchCond cond);
}
