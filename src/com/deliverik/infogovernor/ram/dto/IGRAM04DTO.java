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
public class IGRAM04DTO extends BaseDTO implements Serializable{

	/**年度评估差条件*/
	protected String currentyear;
	/**年度评估报表*/
	protected List<String> yearReport;
	/**
	 * currentyear取得
	 */
	public String getCurrentyear() {
		return currentyear;
	}
	/**
	 * currentyear设定
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}
	/**
	 * yearReport取得
	 */
	public List<String> getYearReport() {
		return yearReport;
	}
	/**
	 * yearReport设定
	 */
	public void setYearReport(List<String> yearReport) {
		this.yearReport = yearReport;
	}

	
}


