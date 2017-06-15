/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;


/**
 * 概述:监控报表详细页 查询VO
 * 功能描述：监控报表详细页 查询VO
 * 创建人：李季
 * 创建记录： 
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR08031VO extends BaseVO{

	
	/**监控报表详细页信息*/
	protected Map<String,List<ReportDetailVWInfo>> detailMap;
	
	/**返回标识*/
	protected String flag;
	
	
	
	
	/**
	 * 监控报表详细页信息 取得
	 * @return 监控报表详细页信息
	 */
	public Map<String, List<ReportDetailVWInfo>> getDetailMap() {
		return detailMap;
	}

	/**
	 * 监控报表详细页信息设定
	 * @param detailMap 监控报表详细页信息
	 */
	public void setDetailMap(Map<String, List<ReportDetailVWInfo>> detailMap) {
		this.detailMap = detailMap;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
}
