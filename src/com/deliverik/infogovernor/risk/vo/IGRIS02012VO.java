/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.risk.vo;

import java.io.Serializable;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.risk.model.CheckWorkResultInfo;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��鹤��ִ�в�ѯVO
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGRIS02012VO extends BaseVO implements Serializable{
	/** ���ռ������Ϣ������� */
	protected RiskCheckResult riskCheckResult;
	
	/** ����id  */	
	protected Integer attid;
	/** ������  */	
	protected String attname;
	
	/** �ƻ�����ʱ��*/
	protected String endDate;
	
	protected CheckWorkResultInfo checkWorkResultInfo;
	/**
	 * ���ռ������Ϣ�������ȡ��
	 * @return riskCheckResult ���ռ������Ϣ�������
	 */
	public RiskCheckResult getRiskCheckResult() {
		return riskCheckResult;
	}
	/**
	 * ���ռ������Ϣ��������趨
	 * @param riskCheckResult ���ռ������Ϣ�������
	 */
	public void setRiskCheckResult(RiskCheckResult riskCheckResult) {
		this.riskCheckResult = riskCheckResult;
	}
	
	/**
	 * @return the checkWorkResultInfo
	 */
	public CheckWorkResultInfo getCheckWorkResultInfo() {
		return checkWorkResultInfo;
	}
	/**
	 * @param checkWorkResultInfo the checkWorkResultInfo to set
	 */
	public void setCheckWorkResultInfo(CheckWorkResultInfo checkWorkResultInfo) {
		this.checkWorkResultInfo = checkWorkResultInfo;
	}
	/**
	 * �ƻ�����ʱ��ȡ��
	 * @return endDate �ƻ�����ʱ��
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * �ƻ�����ʱ���趨
	 * @param endDate �ƻ�����ʱ��
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	/**
	 * ����idȡ��
	 * @return attid  ����id
	 */
	public Integer getAttid() {
		return attid;
	}
	/**
	 * ����id�趨
	 * @param attid  ����id
	 */
	public void setAttid(Integer attid) {
		this.attid = attid;
	}
	/**
	 * ������ȡ��
	 * @return attname  ������
	 */
	public String getAttname() {
		return attname;
	}
	/**
	 * �������趨
	 * @param attname  ������
	 */
	public void setAttname(String attname) {
		this.attname = attname;
	}
}
