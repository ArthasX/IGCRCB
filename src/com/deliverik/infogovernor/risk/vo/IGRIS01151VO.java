/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.risk.model.RiskCheck;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * �������������������֣�
 * 
 * @author maozhipeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01151VO extends BaseVO implements Serializable{
	
	/** ������������������ */
	protected List<RiskCheck> riskCheckList;
	
	/** ������������������� */
	protected List<RiskCheckResult> riskCheckResultList;
	
	/**���ռ����ϸ��Ϣ*/
	
	protected RiskCheck riskCheck;
	
	/** ���ռ����Ա��ʽ�Ľ�����Ϣ */
	protected String cronInfo;
	
	/** ���ռ����Ϣ�������� */
	protected List<Attachment> attachmentList;
	
	/**���ռ����*/
	protected Map<RiskCheckResult, List<Attachment>> attachmentMap;
	
	public IGRIS01151VO() {
		
	}
	/**
	 * ���캯��
	 * @param riskAuditResultList�����������Ϣ�������
	 */
	public IGRIS01151VO(List<RiskCheck> riskCheckList) {
		this.riskCheckList = riskCheckList;
	}
	
	public Map<RiskCheckResult, List<Attachment>> getAttachmentMap() {
		return attachmentMap;
	}
	public void setAttachmentMap(
			Map<RiskCheckResult, List<Attachment>> attachmentMap) {
		this.attachmentMap = attachmentMap;
	}
	public List<RiskCheckResult> getRiskCheckResultList() {
		return riskCheckResultList;
	}
	public void setRiskCheckResultList(List<RiskCheckResult> riskCheckResultList) {
		this.riskCheckResultList = riskCheckResultList;
	}
	public List<RiskCheck> getRiskCheckList() {
		return riskCheckList;
	}
	public RiskCheck getRiskCheck() {
		return riskCheck;
	}
	public void setRiskCheck(RiskCheck riskCheck) {
		this.riskCheck = riskCheck;
	}
	public String getCronInfo() {
		return cronInfo;
	}
	public void setCronInfo(String cronInfo) {
		this.cronInfo = cronInfo;
	}
	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

}


