/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentAveSolveTimeSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 事件平均解决时间统计BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentAveSolveTimeVWBL extends BaseBL{

	/**
	 * 统计数据查询
	 * @param cond
	 * @return
	 */
	public List<IncidentAveSolveTimeVWInfo> searchSolveTimeData(IncidentAveSolveTimeSearchCond cond);
}
