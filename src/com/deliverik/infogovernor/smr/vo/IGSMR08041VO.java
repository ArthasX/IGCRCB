/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;


/**
 * 概述:核心网络系统运行情况 查询VO
 * 功能描述：核心网络系统运行情况 查询VO
 * 创建记录： 
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR08041VO extends BaseVO{

	
	/**监控报表季报1中核心网络系统运行情况信息*/
	protected Map<String, List<String[]>> map_report;

	/**
	 * 监控报表季报1中核心网络系统运行情况信息取得
	 *
	 * @return map_report 监控报表季报1中核心网络系统运行情况信息
	 */
	public Map<String, List<String[]>> getMap_report() {
		return map_report;
	}

	/**
	 * 监控报表季报1中核心网络系统运行情况信息设定
	 *
	 * @param map_report 监控报表季报1中核心网络系统运行情况信息
	 */
	public void setMap_report(Map<String, List<String[]>> map_report) {
		this.map_report = map_report;
	}
	
	
}
