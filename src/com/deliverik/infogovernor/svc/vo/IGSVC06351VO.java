/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.vo;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.svc.model.IncidentTypeVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 故障类型统计vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06351VO extends BaseVO{
	
	/** 故障类型统计信息 */
	private IncidentTypeVWInfo incidentType;

	/**
	 * 故障类型统计信息取得
	 * @return incidentType 故障类型统计信息
	 */
	public IncidentTypeVWInfo getIncidentType() {
		return incidentType;
	}

	/**
	 * 故障类型统计信息设定
	 * @param incidentType 故障类型统计信息
	 */
	public void setIncidentType(IncidentTypeVWInfo incidentType) {
		this.incidentType = incidentType;
	}
}
