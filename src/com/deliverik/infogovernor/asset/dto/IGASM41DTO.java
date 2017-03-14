/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.asset.model.CheckVWInfo;
import com.deliverik.infogovernor.asset.model.RiskVWInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险检查统计业务用DTO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGASM41DTO extends BaseDTO implements Serializable{
	
	/** 风险检查统计信息检索结果 */
	protected Map<List<RiskVWInfo>,List<CheckVWInfo>> riskCheckMap;

	/**
	 * 风险检查统计信息检索结果取得
	 * @return riskCheckMap 风险检查统计信息检索结果
	 */
	public Map<List<RiskVWInfo>, List<CheckVWInfo>> getRiskCheckMap() {
		return riskCheckMap;
	}

	/**
	 * 风险检查统计信息检索结果设定
	 * @param riskCheckMap 风险检查统计信息检索结果
	 */
	public void setRiskCheckMap(
			Map<List<RiskVWInfo>, List<CheckVWInfo>> riskCheckMap) {
		this.riskCheckMap = riskCheckMap;
	}
}
