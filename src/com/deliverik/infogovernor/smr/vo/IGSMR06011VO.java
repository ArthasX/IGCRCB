/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.RegulatoryReportInstanceInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;

/**
 * 概述:填报、审批查询结果 
 * 功能描述：填报、审批查询结果 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-08
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR06011VO extends BaseVO {

	/** 年报查询结果*/
	protected Map<String,List<AnnualReportVW>> map_arq;
	
	/** 年报一级审批查询结果*/
	protected Map<String,List<AnnualReportVW>> map_first;
	
	/** 年报二级审批查询结果*/
	protected List<RegulatoryReportInstanceInfo> second_list;
	
	/**
	 * 年报查询结果取得
	 * 
	 * @return 年报查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_arq() {
		return map_arq;
	}

	
	/**
	 * 年报查询结果设定
	 * 
	 * @param arqMap 年报查询结果
	 */
	public void setMap_arq(Map<String, List<AnnualReportVW>> map_arq) {
		this.map_arq = map_arq;
	}	

	
	/**
	 * 年报一级审批查询结果取得
	 * 
	 * @return 年报一级审批查询结果
	 */
	public Map<String, List<AnnualReportVW>> getMap_first() {
		return map_first;
	}

	/**
	 * 年报一级审批查询结果设定
	 * 
	 * @param first_list 年报一级审批查询结果
	 */
	public void setMap_first(Map<String, List<AnnualReportVW>> map_first) {
		this.map_first = map_first;
	}
	
	
	/**
	 * 年报二级审批查询结果取得
	 * 
	 * @return 年报二级审批查询结果
	 */
	public List<RegulatoryReportInstanceInfo> getSecond_list() {
		return second_list;
	}
	
	/**
	 * 年报二级审批查询结果设定
	 * 
	 * @param second_list 年报二级审批查询结果
	 */
	public void setSecond_list(List<RegulatoryReportInstanceInfo> second_list) {
		this.second_list = second_list;
	}
}
