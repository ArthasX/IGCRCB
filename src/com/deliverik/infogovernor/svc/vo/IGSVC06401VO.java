/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.vo;

import com.deliverik.framework.base.BaseVO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��vo
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC06401VO extends BaseVO{
	
	/** �¼�ͳ������ */
	private String incidentnum;
	
	/** ����ͳ������ */
	private String problemnum;
	
	/** ���ͳ������ */
	private String changenum;
	
	/** ��������ͳ������ */
	private String servicenum;
	
	/** ���񹤵�ͳ������ */
	private String sfnum;

	/**
	 * �¼�ͳ������ȡ��
	 * @return incidentnum �¼�ͳ������
	 */
	public String getIncidentnum() {
		return incidentnum;
	}
	
	/**
	 * �¼�ͳ�������趨
	 * @param incidentnum �¼�ͳ������
	 */
	public void setIncidentnum(String incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * ����ͳ������ȡ��
	 * @return problemnum ����ͳ������
	 */
	public String getProblemnum() {
		return problemnum;
	}

	/**
	 * ����ͳ�������趨
	 * @param problemnum ����ͳ������
	 */
	public void setProblemnum(String problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * ���ͳ������ȡ��
	 * @return changenum ���ͳ������
	 */
	public String getChangenum() {
		return changenum;
	}

	/**
	 * ���ͳ�������趨
	 * @param changenum ���ͳ������
	 */
	public void setChangenum(String changenum) {
		this.changenum = changenum;
	}

	/**
	 * ��������ͳ������ȡ��
	 * @return servicenum ��������ͳ������
	 */
	public String getServicenum() {
		return servicenum;
	}
	
	/**
	 * ��������ͳ�������趨
	 * @param servicenum ��������ͳ������
	 */
	public void setServicenum(String servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * ���񹤵�ͳ������ȡ��
	 * @return sfnum ���񹤵�ͳ������
	 */
	public String getSfnum() {
		return sfnum;
	}
	
	/**
	 * ���񹤵�ͳ�������趨
	 * @param sfnum ���񹤵�ͳ������
	 */
	public void setSfnum(String sfnum) {
		this.sfnum = sfnum;
	}
}
