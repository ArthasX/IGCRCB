package com.deliverik.infogovernor.ram.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
 * 风险评估评分历史查询ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGRAM03011VO extends BaseVO implements Serializable{

	/**部门评估报表*/
	protected List<String> orgReport;

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
}


