package com.deliverik.infogovernor.ven.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.vo.IGRIS02022VO;
import com.deliverik.infogovernor.ven.form.IGVEN0102Form;

/**
 * 风险检查信息检索结果ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGVEN01021VO extends BaseVO implements Serializable{
	/**频率周星期集合*/
	protected List<IGVEN01022VO> weekList;
	
	/**频率月天数集合*/
	protected List<IGVEN01022VO> monthList;

	/** 风险检查附件 */
	protected List<Attachment> attachmentDataList;
	
	/** 检查策略  */	
	protected CheckStrategyInfo checkStrategyInfo;
	
	/** 资产id集合*/
	protected List<Integer> eiidList;
	
	/** 资产版本集合*/
	protected List<Integer> eiVersionList;
	
	/** 检查项集合*/
	protected List<RiskCheck> riskCheckList;
	
	protected Map<String, List<RiskCheck>> riskCheckmap;
	
	protected Map<Integer,String> mapType;
	
	protected IGVEN0102Form igVEN0102Form;

	
	/**
	 * @return the weekList
	 */
	public List<IGVEN01022VO> getWeekList() {
		return weekList;
	}

	/**
	 * @param weekList the weekList to set
	 */
	public void setWeekList(List<IGVEN01022VO> weekList) {
		this.weekList = weekList;
	}

	/**
	 * @return the monthList
	 */
	public List<IGVEN01022VO> getMonthList() {
		return monthList;
	}

	/**
	 * @param monthList the monthList to set
	 */
	public void setMonthList(List<IGVEN01022VO> monthList) {
		this.monthList = monthList;
	}

	/**
	 * @return the riskCheckmap
	 */
	public Map<String, List<RiskCheck>> getRiskCheckmap() {
		return riskCheckmap;
	}

	/**
	 * @param riskCheckmap the riskCheckmap to set
	 */
	public void setRiskCheckmap(Map<String, List<RiskCheck>> riskCheckmap) {
		this.riskCheckmap = riskCheckmap;
	}

	/**
	 * @return the mapType
	 */
	public Map<Integer, String> getMapType() {
		return mapType;
	}

	/**
	 * @param mapType the mapType to set
	 */
	public void setMapType(Map<Integer, String> mapType) {
		this.mapType = mapType;
	}

	/**
	 * attachmentDataList取得
	 *
	 * @return attachmentDataList attachmentDataList
	 */
	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

	/**
	 * attachmentDataList设定
	 *
	 * @param attachmentDataList attachmentDataList
	 */
	public void setAttachmentDataList(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}

	/**
	 * 检查策略取得
	 * @return checkStrategyInfo  检查策略
	 */
	public CheckStrategyInfo getCheckStrategyInfo() {
		return checkStrategyInfo;
	}

	/**
	 * 检查策略设定
	 * @param checkStrategyInfo  检查策略
	 */
	public void setCheckStrategyInfo(CheckStrategyInfo checkStrategyInfo) {
		this.checkStrategyInfo = checkStrategyInfo;
	}

	/**
	 * @return the eiidList
	 */
	public List<Integer> getEiidList() {
		return eiidList;
	}

	/**
	 * @param eiidList the eiidList to set
	 */
	public void setEiidList(List<Integer> eiidList) {
		this.eiidList = eiidList;
	}

	/**
	 * @return the eiVersionList
	 */
	public List<Integer> getEiVersionList() {
		return eiVersionList;
	}

	/**
	 * @param eiVersionList the eiVersionList to set
	 */
	public void setEiVersionList(List<Integer> eiVersionList) {
		this.eiVersionList = eiVersionList;
	}

	/**
	 * @return the riskCheckList
	 */
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}

	/**
	 * @param riskCheckList the riskCheckList to set
	 */
	public void setRiskCheckList(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}

	public IGVEN0102Form getIgVEN0102Form() {
		return igVEN0102Form;
	}

	public void setIgVEN0102Form(IGVEN0102Form igVEN0102Form) {
		this.igVEN0102Form = igVEN0102Form;
	}
}


