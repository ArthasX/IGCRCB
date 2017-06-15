/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.smr.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * 概述:填报考核按人员
 * 功能描述：填报考核按人员
 * 创建人：赵梓廷
 * 创建记录： 2013-09-04
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0802ExcelDTO extends ExcelDTO {

	/**按人员考核查询结果*/
	protected Map<String,List<IGSMR08001VO>> map;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO usersum;
	
	/** 考核开始日期 */
	protected String assessstartdate;
	
	/** 考核结束日期 */
	protected String assessoverdate;
	
	public Map<String, List<IGSMR08001VO>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<IGSMR08001VO>> map) {
		this.map = map;
	}


	public IGSMR08001VO getUsersum() {
		return usersum;
	}

	public void setUsersum(IGSMR08001VO usersum) {
		this.usersum = usersum;
	}

	public String getAssessstartdate() {
		return assessstartdate;
	}

	public void setAssessstartdate(String assessstartdate) {
		this.assessstartdate = assessstartdate;
	}

	public String getAssessoverdate() {
		return assessoverdate;
	}

	public void setAssessoverdate(String assessoverdate) {
		this.assessoverdate = assessoverdate;
	}
	
	
}
