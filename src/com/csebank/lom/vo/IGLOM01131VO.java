/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Deal;
import com.csebank.lom.model.GuestRecption;
import com.csebank.lom.model.Recption;
import com.csebank.lom.model.RecptionCost;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 部门接待工作统计明细管理VO
 *
 */
public class IGLOM01131VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 部门接待工作管理检索结果
	 */
	protected List<Recption> recptionList;
	protected List<Deal> dealList;
	/**
	 * 部门接待工作和费用信息检索结果
	 */
	protected List<RecptionCost> recptionCostList;
	
	/** 接待客人和接待工作搜索结果集 */
	protected List<GuestRecption> guestRecptionList;
	
	/**
	 * 接待客人和接待工作搜索结果集取得
	 * @return 接待客人和接待工作搜索结果集
	 */
	public List<GuestRecption> getGuestRecptionList() {
		return guestRecptionList;
	}
	
	/**
	 * 接待客人和接待工作搜索结果集设定
	 * @param guestRecptionList 接待客人和接待工作搜索结果集
	 */
	public void setGuestRecptionList(List<GuestRecption> guestRecptionList) {
		this.guestRecptionList = guestRecptionList;
	}
	/**
	 * 部门接待工作和费用信息检索结果取得
	 * @return 部门接待工作和费用信息检索结果
	 */
	public List<RecptionCost> getRecptionCostList() {
		return recptionCostList;
	}
	
	/**
	 * 部门接待工作和费用信息检索结果设定
	 * @param recptionCostList 部门接待工作和费用信息检索结果
	 */
	public void setRecptionCostList(List<RecptionCost> recptionCostList) {
		this.recptionCostList = recptionCostList;
	}

	/**
	 * 部门接待工作管理检索结果取得
	 * @return 部门接待工作管理检索结果
	 */
	public List<Recption> getRecptionList() {
		return recptionList;
	}

	/**
	 * 部门接待工作管理检索结果
	 * @param recptionList 部门接待工作管理检索结果
	 */
	public void setRecptionList(List<Recption> recptionList) {
		this.recptionList = recptionList;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

}
