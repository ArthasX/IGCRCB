/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.PersonLoanDetail;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 人员借款明细统计VO
 *
 */
public class IGLOM03111VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/** 人员借款明细统计查询结果列表 */
	protected List<PersonLoanDetail> personLoanDetailList;

	/**
	 * 人员借款明细统计查询结果列表取得
	 * @return 人员借款明细统计查询结果列表
	 */
	public List<PersonLoanDetail> getPersonLoanDetailList() {
		return personLoanDetailList;
	}

	/**
	 * 人员借款明细统计查询结果列表设定
	 * @param personLoanDetailList 人员借款明细统计查询结果列表
	 */
	public void setPersonLoanDetailList(
			List<PersonLoanDetail> personLoanDetailList) {
		this.personLoanDetailList = personLoanDetailList;
	}

}
