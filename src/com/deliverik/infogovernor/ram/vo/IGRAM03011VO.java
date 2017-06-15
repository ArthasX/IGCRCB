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
public class IGRAM03011VO extends BaseVO implements Serializable{

	/**������������*/
	protected List<String> orgReport;

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
}


