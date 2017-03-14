/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;

/**
 * 
 * 概述: 风险指标查询导出专用DTO
 * 功能描述: 风险指标查询导出专用DTO
 * 创建人：hujuwen
 * 创建记录: 2014/07/26
 * 修改记录:
 */
public class IGASM3101ExcelDTO extends ExcelDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6729726206045327987L;

	/**风险指标查询集合*/
	public List<RiskIndexSearchVWInfo> processList;
	
	/**风险指标查询集合 获得
	 * @return list
	 */
	public List<RiskIndexSearchVWInfo> getProcessList() {
		return processList;
	}
	
	/**风险指标查询集合 设定*/
	public void setProcessList(List<RiskIndexSearchVWInfo> processList) {
		this.processList = processList;
	}
	
}
