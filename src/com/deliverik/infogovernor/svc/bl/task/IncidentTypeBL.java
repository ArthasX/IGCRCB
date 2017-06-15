/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.bl.task;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;
import com.deliverik.infogovernor.svc.model.condition.IncidentTypeSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计BL接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IncidentTypeBL extends BaseBL{

	/**
	 * 统计数据检索
	 * @param cond 检索条件
	 * @return
	 */
	public IncidentTypeVWInfo searchIncidentTypeData(IncidentTypeSearchCond cond);
}
