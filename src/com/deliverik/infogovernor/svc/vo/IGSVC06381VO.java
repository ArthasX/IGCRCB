/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.IncidentAveSolveTimeVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 时间平均解决时间统计VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06381VO extends BaseVO{

	/** 时间平均解决时间统计数据 */
	protected List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate;

	/**
	 * 时间平均解决时间统计数据取得
	 * @return incidentAveSolveTimeDate 时间平均解决时间统计数据
	 */
	public List<IncidentAveSolveTimeVWInfo> getIncidentAveSolveTimeDate() {
		return incidentAveSolveTimeDate;
	}

	/**
	 * 时间平均解决时间统计数据设定
	 * @param incidentAveSolveTimeDate 时间平均解决时间统计数据
	 */
	public void setIncidentAveSolveTimeDate(
			List<IncidentAveSolveTimeVWInfo> incidentAveSolveTimeDate) {
		this.incidentAveSolveTimeDate = incidentAveSolveTimeDate;
	}
}
