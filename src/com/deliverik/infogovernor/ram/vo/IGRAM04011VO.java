package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
 * ��������������ʷ��ѯ�֣�
 *
 */
@SuppressWarnings("serial")
public class IGRAM04011VO extends BaseVO implements Serializable{

	/**�����������*/
	protected List<String> yearReport;

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


