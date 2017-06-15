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
public class IGRAM04011VO extends BaseVO implements Serializable{

	/**年度评估报表*/
	protected List<String> yearReport;

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


