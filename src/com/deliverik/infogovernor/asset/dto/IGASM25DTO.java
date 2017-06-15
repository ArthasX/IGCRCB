/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.infogovernor.asset.form.IGASM2502Form;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.IG344Info;

/**
 * 服务记录统计用DTO
 * 
 */
@SuppressWarnings("serial")
public class IGASM25DTO extends BaseDTO implements Serializable{

	/** 服务商名称 */
	protected String einame_like;
	
	/** 服务记录开始时间 */
	protected String beginTime_q;
	
	/** 服务记录结束时间 */
	protected String endTime_q;
	
	/** 服务记录信息检索条件 */
//	protected EntityItemVWSearchCond entityItemVWSearchCond;

	/** 服务记录检索结果 */
	protected List<IG343Info> entityItemRelationVWInfoList;
	
	/** 设备资产共计 */
	protected int sbSumCount;
	
	/** 应用资产共计 */
	protected int yySumCount;
	
	/** 培训记录共计 */
	protected int pxSumCount;
	
	/** 合计次数共计 */
	protected int hjSumCount;
	
	/** 服务记录明细查询form*/
	protected IGASM2502Form igasm2502Form;
	
	/** 服务记录明细检索结果 */
	protected List<IG344Info> entityItemRelationDetailVWInfo;
	
	/** 服务次数累计 */
	protected int fwcsSumCount;
	
	/** 服务平均分累计 */
	protected Double fwpjfSumStore;
	
//	/**
//	 * 获取entityItemVWSearchCond
//	 * @return fentityItemVWSearchCond entityItemVWSearchCond
//	 */
//	public EntityItemVWSearchCond getEntityItemVWSearchCond() {
//		return entityItemVWSearchCond;
//	}
//
//	/**
//	 * 设置entityItemVWSearchCond
//	 * @param entityItemVWSearchCond  entityItemVWSearchCond
//	 */
//	public void setEntityItemVWSearchCond(
//			EntityItemVWSearchCond entityItemVWSearchCond) {
//		this.entityItemVWSearchCond = entityItemVWSearchCond;
//	}

	/**
	 * 获取entityItemRelationVWInfoList
	 * @return fentityItemRelationVWInfoList entityItemRelationVWInfoList
	 */
	public List<IG343Info> getEntityItemRelationVWInfoList() {
		return entityItemRelationVWInfoList;
	}

	/**
	 * 设置entityItemRelationVWInfoList
	 * @param entityItemRelationVWInfoList  entityItemRelationVWInfoList
	 */
	public void setEntityItemRelationVWInfoList(
			List<IG343Info> entityItemRelationVWInfoList) {
		this.entityItemRelationVWInfoList = entityItemRelationVWInfoList;
	}

	/**
	 * 获取服务商名称
	 * @return einame_like
	 */
	public String getEiname_like() {
		return einame_like;
	}

	/**
	 * 设置服务商名称
	 * @param einame_like
	 */
	public void setEiname_like(String einame_like) {
		this.einame_like = einame_like;
	}

	/**
	 * 获取服务记录开始时间 
	 * @return beginTime_q
	 */
	public String getBeginTime_q() {
		return beginTime_q;
	}

	/**
	 * 设置beginTime_q
	 * @param beginTime_q  beginTime_q
	 */
	public void setBeginTime_q(String beginTime_q) {
		this.beginTime_q = beginTime_q;
	}

	/**
	 * 获取endTime_q
	 * @return fendTime_q endTime_q
	 */
	public String getEndTime_q() {
		return endTime_q;
	}

	/**
	 * 设置endTime_q
	 * @param endTime_q  endTime_q
	 */
	public void setEndTime_q(String endTime_q) {
		this.endTime_q = endTime_q;
	}

	/**
	 * 获取sbSumCount
	 * @return fsbSumCount sbSumCount
	 */
	public int getSbSumCount() {
		return sbSumCount;
	}

	/**
	 * 设置sbSumCount
	 * @param sbSumCount  sbSumCount
	 */
	public void setSbSumCount(int sbSumCount) {
		this.sbSumCount = sbSumCount;
	}

	/**
	 * 获取yySumCount
	 * @return fyySumCount yySumCount
	 */
	public int getYySumCount() {
		return yySumCount;
	}

	/**
	 * 设置yySumCount
	 * @param yySumCount  yySumCount
	 */
	public void setYySumCount(int yySumCount) {
		this.yySumCount = yySumCount;
	}

	/**
	 * 获取pxSumCount
	 * @return fpxSumCount pxSumCount
	 */
	public int getPxSumCount() {
		return pxSumCount;
	}

	/**
	 * 设置pxSumCount
	 * @param pxSumCount  pxSumCount
	 */
	public void setPxSumCount(int pxSumCount) {
		this.pxSumCount = pxSumCount;
	}

	/**
	 * 获取hjSumCount
	 * @return fhjSumCount hjSumCount
	 */
	public int getHjSumCount() {
		return hjSumCount;
	}

	/**
	 * 设置hjSumCount
	 * @param hjSumCount  hjSumCount
	 */
	public void setHjSumCount(int hjSumCount) {
		this.hjSumCount = hjSumCount;
	}
	
	/**
	 * 获取entityItemRelationDetailVWInfo
	 * @return fentityItemRelationDetailVWInfo entityItemRelationDetailVWInfo
	 */
	public List<IG344Info> getEntityItemRelationDetailVWInfo() {
		return entityItemRelationDetailVWInfo;
	}

	/**
	 * 设置entityItemRelationDetailVWInfo
	 * @param entityItemRelationDetailVWInfo  entityItemRelationDetailVWInfo
	 */
	public void setEntityItemRelationDetailVWInfo(
			List<IG344Info> entityItemRelationDetailVWInfo) {
		this.entityItemRelationDetailVWInfo = entityItemRelationDetailVWInfo;
	}

	/**
	 * 获取fwcsSumCount
	 * @return ffwcsSumCount fwcsSumCount
	 */
	public int getFwcsSumCount() {
		return fwcsSumCount;
	}

	/**
	 * 设置fwcsSumCount
	 * @param fwcsSumCount  fwcsSumCount
	 */
	public void setFwcsSumCount(int fwcsSumCount) {
		this.fwcsSumCount = fwcsSumCount;
	}

	/**
	 * 获取fwpjfSumStore
	 * @return ffwpjfSumStore fwpjfSumStore
	 */
	public Double getFwpjfSumStore() {
		return fwpjfSumStore;
	}

	/**
	 * 设置fwpjfSumStore
	 * @param fwpjfSumStore  fwpjfSumStore
	 */
	public void setFwpjfSumStore(Double fwpjfSumStore) {
		this.fwpjfSumStore = fwpjfSumStore;
	}

	/**
	 * 获取igasm2102Form
	 * @return figasm2102Form igasm2102Form
	 */
	public IGASM2502Form getIgasm2502Form() {
		return igasm2502Form;
	}

	/**
	 * 设置igasm2102Form
	 * @param igasm2102Form  igasm2102Form
	 */
	public void setIgasm2502Form(IGASM2502Form igasm2502Form) {
		this.igasm2502Form = igasm2502Form;
	}
	
}


