/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.xls.smr.dto;

import java.util.List;

import com.deliverik.framework.base.ExcelDTO;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * 概述:填报考核导出 
 * 功能描述：填报考核导出
 * 创建人：赵梓廷
 * 创建记录： 2013-09-03
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0801ExcelDTO extends ExcelDTO {

	
	
	/**按机构考核查询结果*/
	protected List<IGSMR08001VO> list;
	
	/**按机构考核查询结果合计*/
	protected IGSMR08001VO orgsum;
		
	
	/** 考核开始日期 */
	protected String assessstartdate;
	
	/** 考核结束日期 */
	protected String assessoverdate;

	
	public List<IGSMR08001VO> getList() {
		return list;
	}

	public void setList(List<IGSMR08001VO> list) {
		this.list = list;
	}

	public IGSMR08001VO getOrgsum() {
		return orgsum;
	}

	public void setOrgsum(IGSMR08001VO orgsum) {
		this.orgsum = orgsum;
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
