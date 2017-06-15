/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;

/**
 * �������Ϣ��������֣�
 * 
 * @author liupeng@deliverik.com
 *
 */
@SuppressWarnings("serial")
public class IGRIS01121VO extends BaseVO implements Serializable{
	
	/** �����������Ϣ��������� */
	protected List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList;
	
	/** �������󼶴� */
	protected Integer radMaxLevel;
	
	/** ������list */
	protected List<Integer> radMaxLevelList;
	
	/**
	 * �����������Ϣ���������ȡ��
	 * 
	 * @return �����������Ϣ���������
	 */
	public List<RiskAuditDefResultVWInfo> getRiskAuditDefResultVWInfoList() {
		return riskAuditDefResultVWInfoList;
	}

	/**
	 * �����������Ϣ����������趨
	 *
	 * @param riskAuditDefResultVWInfoList �����������Ϣ���������
	 */
	public void setRiskAuditDefResultVWInfoList(
			List<RiskAuditDefResultVWInfo> riskAuditDefResultVWInfoList) {
		this.riskAuditDefResultVWInfoList = riskAuditDefResultVWInfoList;
	}

	/**
	 * �������󼶴�ȡ��
	 * 
	 * @return �������󼶴�
	 */
	public Integer getRadMaxLevel() {
		return radMaxLevel;
	}
	
	/**
	 * �������󼶴��趨
	 *
	 * @param radMaxLevel �������󼶴�
	 */
	public void setRadMaxLevel(Integer radMaxLevel) {
		this.radMaxLevel = radMaxLevel;
	}
	
	/**
	 * ������listȡ��
	 * 
	 * @return ������list
	 */
	public List<Integer> getRadMaxLevelList() {
		return radMaxLevelList;
	}

	/**
	 * ������list�趨
	 *
	 * @param List<Integer> ������list
	 */
	public void setRadMaxLevelList(List<Integer> radMaxLevelList) {
		this.radMaxLevelList = radMaxLevelList;
	}

}


