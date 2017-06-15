/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import com.csebank.lom.model.DealOrg;
import com.csebank.lom.model.EEOrg;
import com.csebank.lom.model.RecptionOrg;
import com.csebank.lom.util.LOMHelper;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 部门接待工作统计VO
 *
 */
public class IGLOM01081VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 部门接待工作统计检索结果
	 */
	protected List<RecptionOrg> recptionOrgVWList;
	/**
	 * 部门外出就餐工作统计检索结果
	 */
	protected List<DealOrg> dealOrgVWList;
	/**
	 * 食堂管理-食堂招待部门汇总查询结果
	 */
	protected List<EEOrg> eeOrgVWList;
	
	/** 费用总金额 */
	protected BigDecimal sumamount;
	
	/** 结束总数量 */
	protected Integer sumdisnum;
	
	/** 未结束总数量 */
	protected Integer sumennum;
	
	/** 接待总数量 */
	protected Integer sumrnum;


	/**
	 * 部门接待工作统计检索结果取得
	 * @return 部门接待工作统计检索结果
	 */
	public List<RecptionOrg> getRecptionOrgVWList() {
		return recptionOrgVWList;
	}

	/**
	 * 部门接待工作统计检索结果
	 * @param recptionList 部门接待工作统计检索结果
	 */
	public void setRecptionOrgVWList(List<RecptionOrg> recptionOrgVWList) {
		this.recptionOrgVWList = recptionOrgVWList;
		//合计
		RecptionOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbdisnum = 0;
		Integer dbennum = 0;
		Integer dbrnum = 0;
		
		Iterator<RecptionOrg> it = recptionOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbdisnum += ro.getDisnum();
				dbennum += ro.getEnnum();
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumdisnum = dbdisnum;
		sumennum = dbennum;
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
	 * 结束总数量取得
	 * @return 结束总数量
	 */
	public Integer getSumdisnum() {
		return sumdisnum;
	}

	/**
	 * 未结束总数量取得
	 * @return 未结束总数量
	 */
	public Integer getSumennum() {
		return sumennum;
	}

	/**
	 * 接待总数量取得
	 * @return 接待总数量
	 */
	public Integer getSumrnum() {
		return sumrnum;
	}

	public List<DealOrg> getDealOrgVWList() {
		return dealOrgVWList;
	}

	public void setDealOrgVWList(List<DealOrg> dealOrgVWList) {
		this.dealOrgVWList = dealOrgVWList;
		//合计
		DealOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbdisnum = 0;
		Integer dbennum = 0;
		Integer dbrnum = 0;
		
		Iterator<DealOrg> it = dealOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbdisnum += ro.getDisnum();
				dbennum += ro.getEnnum();
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumdisnum = dbdisnum;
		sumennum = dbennum;
		sumrnum = dbrnum;
	}


	public void setSumamount(BigDecimal sumamount) {
		this.sumamount = sumamount;
	}

	public void setSumdisnum(Integer sumdisnum) {
		this.sumdisnum = sumdisnum;
	}

	public void setSumennum(Integer sumennum) {
		this.sumennum = sumennum;
	}

	public void setSumrnum(Integer sumrnum) {
		this.sumrnum = sumrnum;
	}
	public List<EEOrg> getEeOrgVWList() {
		return eeOrgVWList;
	}

	public void setEeOrgVWList(List<EEOrg> eeOrgVWList) {
		this.eeOrgVWList = eeOrgVWList;
		//合计
		EEOrg ro = null;
		BigDecimal dbamount = new BigDecimal(0);
		Integer dbrnum = 0;
		
		Iterator<EEOrg> it = eeOrgVWList.iterator();
		while(it.hasNext()){
				ro = it.next();
				dbamount = LOMHelper.getAdd(dbamount, ro.getAmount());
				dbrnum += ro.getRnum();
		}	
		sumamount = dbamount;
		sumrnum = dbrnum;
	}

}
