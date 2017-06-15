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
public class IGRAM03DTO extends BaseDTO implements Serializable{
	/**������������*/
	protected List<String> orgReport;
	
	/**����������ѯ��ʼʱ��*/
	protected String propentime_from;
	
	/**����������ѯ����ʱ��*/
	protected String propentime_to;

	/**
	 * orgReportȡ��
	 */
	public List<String> getOrgReport() {
		return orgReport;
	}

	/**
	 * orgReport�趨
	 */
	public void setOrgReport(List<String> orgReport) {
		this.orgReport = orgReport;
	}

	/**
	 * propentime_fromȡ��
	 */
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * propentime_from�趨
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * propentime_toȡ��
	 */
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * propentime_to�趨
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}
	
}


