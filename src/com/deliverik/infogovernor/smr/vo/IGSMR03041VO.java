/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.entity.AnnualReportVW;

/**
 * 概述:首页更多
 * 功能描述：首页更多
 * 创建人：赵梓廷
 * 创建记录： 2013-08-14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR03041VO extends BaseVO {

	/** 首页点击更多查询结果*/
	protected Map<String,List<AnnualReportVW>> map_more;

	public Map<String, List<AnnualReportVW>> getMap_more() {
		return map_more;
	}

	public void setMap_more(Map<String, List<AnnualReportVW>> map_more) {
		this.map_more = map_more;
	}
	
	
}
