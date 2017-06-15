/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.DealAmount;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionAmount;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待工作管理VO
 *
 */
public class IGLOM01031VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待工作管理检索结果
	 */
	protected List<Recption> recptionList;
	protected List<Deal> dealList;

	/**
	 * 接待工作管理检索结果(费用)
	 */
	protected List<RecptionAmount> recptionAmountList;
	protected List<DealAmount> dealAmountList;

	/**
	 * 接待工作管理检索结果取得
	 * @return 接待工作管理检索结果
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * 接待工作管理检索结果
	 * @param recptionList 接待工作管理检索结果
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}
	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

	public List<Deal> getDealList() {
		return dealList;
	}


	/**
	 * 接待工作管理检索结果取得
	 * @return 接待工作管理检索结果
	 */
	public List<RecptionAmount> getRecptionAmountList() {
		return recptionAmountList;
	}

	/**
	 * 接待工作管理检索结果
	 * @param recptionList 接待工作管理检索结果
	 */
	public void setRecptionAmountList(List<RecptionAmount> recptionAmountList) {
		this.recptionAmountList = recptionAmountList;
	}

	public List<DealAmount> getDealAmountList() {
		return dealAmountList;
	}

	public void setDealAmountList(List<DealAmount> dealAmountList) {
		this.dealAmountList = dealAmountList;
	}

}
