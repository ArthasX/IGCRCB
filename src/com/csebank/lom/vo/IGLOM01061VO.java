/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.csebank.lom.model.DealVWInfo;
import com.csebank.lom.model.RecptionVWInfo;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 接待工作管理VO
 *
 */
public class IGLOM01061VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 接待工作管理检索结果
	 */
	protected List<RecptionVWInfo> recptionVWList;
	/**
	 * 外出就餐工作管理检索结果
	 */
	protected List<DealVWInfo> dealVWList;
	
	/** 费用总金额 */
	protected BigDecimal sumamount;
	
	/** 接待总数量 */
	protected Integer sumrnum;

	/**
	 * 接待工作管理检索结果取得
	 * @return 接待工作管理检索结果
	 */
	public List<RecptionVWInfo> getRecptionVWList() {
		return recptionVWList;
	}

	/**
	 * 接待工作管理检索结果
	 * @param recptionList 接待工作管理检索结果
	 */
	public void setRecptionVWList(List<RecptionVWInfo> recptionVWList) {
		this.recptionVWList = recptionVWList;
		//合计
		RecptionVWInfo ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<RecptionVWInfo> it = recptionVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

	/**
	 * 费用总金额取得
	 * @return 费用总金额
	 */
	public BigDecimal getSumamount() {
		return sumamount;
	}

	/**
	 * 接待总数量取得
	 * @return 接待总数量
	 */
	public Integer getSumrnum() {
		return sumrnum;
	}

	public List<DealVWInfo> getDealVWList() {
		return dealVWList;
	}

	public void setDealVWList(List<DealVWInfo> dealVWList) {
		this.dealVWList = dealVWList;
		//合计
		DealVWInfo ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<DealVWInfo> it = dealVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

}
