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
 * ��������DTO
 * 
 */
@SuppressWarnings("serial")
public class IGRAM04DTO extends BaseDTO implements Serializable{

	/**�������������*/
	protected String currentyear;
	/**�����������*/
	protected List<String> yearReport;
	/**
	 * currentyearȡ��
	 */
	public String getCurrentyear() {
		return currentyear;
	}
	/**
	 * currentyear�趨
	 */
	public void setCurrentyear(String currentyear) {
		this.currentyear = currentyear;
	}
	/**
	 * yearReportȡ��
	 */
	public List<String> getYearReport() {
		return yearReport;
	}
	/**
	 * yearReport�趨
	 */
	public void setYearReport(List<String> yearReport) {
		this.yearReport = yearReport;
	}

	
}


