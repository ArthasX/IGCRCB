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

/**	
 * ����: ���ռ�⹤����Ϣ��������֣�
 * ������¼��yukexin    2014-12-15 ����10:31:19	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGVEN02021VO extends BaseVO implements Serializable{
	
	/**Ƶ�������ڼ���*/
	protected List<IGRIS02022VO> weekList;
	
	/**Ƶ������������*/
	protected List<IGRIS02022VO> monthList;

	/** ���ռ�鸽�� */
	protected List<Attachment> attachmentDataList;
	
	/** ������  */	
	protected CheckStrategyInfo checkStrategyInfo;
	
	/** �ʲ�id����*/
	protected List<Integer> eiidList;
	
	/** �ʲ��汾����*/
	protected List<Integer> eiVersionList;
	
	/** ������*/
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
	 * attachmentDataListȡ��
	 *
	 * @return attachmentDataList attachmentDataList
	 */
	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

	/**
	 * attachmentDataList�趨
	 *
	 * @param attachmentDataList attachmentDataList
	 */
	public void setAttachmentDataList(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}

	/**
	 * ������ȡ��
	 * @return checkStrategyInfo  ������
	 */
	public CheckStrategyInfo getCheckStrategyInfo() {
		return checkStrategyInfo;
	}

	/**
	 * �������趨
	 * @param checkStrategyInfo  ������
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


