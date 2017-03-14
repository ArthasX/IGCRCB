/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sdl.model.ChangeKpi;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_变更KPI统计VO
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL06011VO extends BaseVO implements Serializable {
	
	/**变更KPI统计信息List*/
	protected List<ChangeKpi> changeKpiList;

	/**
	 * 构造函数
	 * @param ChangeKpiList List<ChangeKpi>
	 * 
	 */
	public IGSDL06011VO(List<ChangeKpi> changeKpiList) {
		this.changeKpiList = changeKpiList;
	}

	/**
	 * 获取变更KPI统计信息Lis
	 * @return 变更KPI统计信息Lis
	 */
	public List<ChangeKpi> getChangeKpiList() {
		return changeKpiList;
	}
	
}
