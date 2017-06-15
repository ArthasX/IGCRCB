/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.AdvanceSummary;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待工作管理VO
 *
 */
public class IGLOM0309VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 预支月度统计检索结果
	 */
	protected List<AdvanceSummary> summaryList;

	/**
	 * 预支月度统计检索结果取得
	 * @return 预支月度统计检索结果
	 */
	public List<AdvanceSummary> getSummaryList() {
		return summaryList;
	}

	/**
	 * 预支月度统计检索结果
	 * @param recptionList 预支月度统计检索结果
	 */
	public void setSummaryList(List<AdvanceSummary> summaryList) {
		this.summaryList = summaryList;
	}

}
