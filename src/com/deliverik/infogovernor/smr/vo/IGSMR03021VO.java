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
 * 概述:填报查看
 * 功能描述：填报查看
 * 创建人：赵梓廷
 * 创建记录： 2013-07-29
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR03021VO extends BaseVO {

	/** 填报查看查询结果*/
	protected Map<String,List<AnnualReportVW>> map_see;
	
	/**
	 * 填报查看查询结果取得
	 * 
	 * @return 填报查看查询结果
	 */

	public Map<String, List<AnnualReportVW>> getMap_see() {
		return map_see;
	}

	/**
	 * 填报查看查询结果设定
	 * 
	 * @param list_rri 填报查看查询结果
	 */
	public void setMap_see(Map<String, List<AnnualReportVW>> map_see) {
		this.map_see = map_see;
	}
}
