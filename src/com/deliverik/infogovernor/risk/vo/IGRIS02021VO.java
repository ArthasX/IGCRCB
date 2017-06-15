package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.form.IGRIS0202Form;
import com.deliverik.infogovernor.risk.model.CheckStrategyInfo;
import com.deliverik.infogovernor.risk.model.RiskCheck;

/**
 * 风险检查信息检索结果ＶＯ
 *
 */
@SuppressWarnings("serial")
public class IGRIS02021VO extends BaseVO implements Serializable{
	
	/**频率周星期集合*/
	protected List<IGRIS02022VO> weekList;
	
	/**频率月天数集合*/
	protected List<IGRIS02022VO> monthList;

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
	
	protected IGRIS0202Form igRIS0202Form;
	
	public List<IGRIS02022VO> getWeekList() {
		return weekList;
	}

	public void setWeekList(List<IGRIS02022VO> weekList) {
		this.weekList = weekList;
	}
	
	public List<IGRIS02022VO> getMonthList() {
		return monthList;
	}

	public void setMonthList(List<IGRIS02022VO> monthList) {
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

	/**
	 * @return the igRIS0202Form
	 */
	public IGRIS0202Form getIgRIS0202Form() {
		return igRIS0202Form;
	}

	/**
	 * @param igRIS0202Form the igRIS0202Form to set
	 */
	public void setIgRIS0202Form(IGRIS0202Form igRIS0202Form) {
		this.igRIS0202Form = igRIS0202Form;
	}

	
	
}


