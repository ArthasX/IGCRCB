/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.Map;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 资源申请统计VO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR14011VO extends BaseVO{

	/** 资源申请统计Map */
	protected Map<String, Integer[]> vmApplyStatisticsDataMap;

	/**
	 * 资源申请统计Map取得
	 * @return vmApplyStatisticsDataMap 资源申请统计Map
	 */
	public Map<String, Integer[]> getVmApplyStatisticsDataMap() {
		return vmApplyStatisticsDataMap;
	}

	/**
	 * 资源申请统计Map设定
	 * @param vmApplyStatisticsDataMap 资源申请统计Map
	 */
	public void setVmApplyStatisticsDataMap(
			Map<String, Integer[]> vmApplyStatisticsDataMap) {
		this.vmApplyStatisticsDataMap = vmApplyStatisticsDataMap;
	}
}
