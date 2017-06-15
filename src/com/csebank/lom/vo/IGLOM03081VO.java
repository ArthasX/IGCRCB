/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.PersonLoanSummary;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 预支人员统计VO
 *
 */
public class IGLOM03081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** 预支人员统计查询结果列表 */
	protected List<PersonLoanSummary> personLoanSummaryList;

	/**
	 * 预支人员统计查询结果列表取得
	 * @return 预支人员统计查询结果列表
	 */
	public List<PersonLoanSummary> getPersonLoanSummaryList() {
		return personLoanSummaryList;
	}

	/**
	 * 预支人员统计查询结果列表设定
	 * @param personLoanSummaryList 预支人员统计查询结果列表
	 */
	public void setPersonLoanSummaryList(
			List<PersonLoanSummary> personLoanSummaryList) {
		this.personLoanSummaryList = personLoanSummaryList;
	}

}
