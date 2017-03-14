package com.deliverik.infogovernor.ram.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;
import com.deliverik.infogovernor.ram.model.entity.AssessmentScoreVW;

/**
 * 风险评估DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM03DTO extends BaseDTO implements Serializable{
	/**部门评估报表*/
	protected List<String> orgReport;
	
	/**部门评估查询开始时间*/
	protected String propentime_from;
	
	/**部门评估查询结束时间*/
	protected String propentime_to;

	/**
	 * orgReport取得
	 */
	public List<String> getOrgReport() {
		return orgReport;
	}

	/**
	 * orgReport设定
	 */
	public void setOrgReport(List<String> orgReport) {
		this.orgReport = orgReport;
	}

	/**
	 * propentime_from取得
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * propentime_from设定
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * propentime_to取得
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * propentime_to设定
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
}


