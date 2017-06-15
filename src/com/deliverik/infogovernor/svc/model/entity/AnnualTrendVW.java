/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.svc.model.AnnualTrendVWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��ȹ�������ͳ��ʵ��
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@Entity
public class AnnualTrendVW implements AnnualTrendVWInfo{

	/** ���� */
	/** ���� */
	@Id
	protected String propentime;
	
	/** �¼�ͳ������ */
	protected Integer incidentnum;
	
	/** ����ͳ������ */
	protected Integer problemnum;
	
	/** ���ͳ������ */
	protected Integer changenum;
	
	/** ��������ͳ������ */
	protected Integer servicenum;
	
	/** ���񹤵�ͳ������ */
	protected Integer sfnum;
	
	/**
	 * �¼�ͳ������ȡ��
	 * @return incidentnum �¼�ͳ������
	 */
	public Integer getIncidentnum() {
		return incidentnum;
	}

	/**
	 * �¼�ͳ�������趨
	 * @param incidentnum �¼�ͳ������
	 */
	public void setIncidentnum(Integer incidentnum) {
		this.incidentnum = incidentnum;
	}

	/**
	 * ����ͳ������ȡ��
	 * @return problemnum ����ͳ������
	 */
	public Integer getProblemnum() {
		return problemnum;
	}

	/**
	 * ����ͳ�������趨
	 * @param problemnum ����ͳ������
	 */
	public void setProblemnum(Integer problemnum) {
		this.problemnum = problemnum;
	}

	/**
	 * ���ͳ������ȡ��
	 * @return changenum ���ͳ������
	 */
	public Integer getChangenum() {
		return changenum;
	}

	/**
	 * ���ͳ�������趨
	 * @param changenum ���ͳ������
	 */
	public void setChangenum(Integer changenum) {
		this.changenum = changenum;
	}

	/**
	 * ��������ͳ������ȡ��
	 * @return servicenum ��������ͳ������
	 */
	public Integer getServicenum() {
		return servicenum;
	}

	/**
	 * ��������ͳ�������趨
	 * @param servicenum ��������ͳ������
	 */
	public void setServicenum(Integer servicenum) {
		this.servicenum = servicenum;
	}

	/**
	 * ���񹤵�ͳ������ȡ��
	 * @return sfnum ���񹤵�ͳ������
	 */
	public Integer getSfnum() {
		return sfnum;
	}

	/**
	 * ���񹤵�ͳ�������趨
	 * @param sfnum ���񹤵�ͳ������
	 */
	public void setSfnum(Integer sfnum) {
		this.sfnum = sfnum;
	}

	/**
	 * ����ȡ��
	 * @return propentime ����
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * �����趨
	 * @param propentime ����
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}
	
}
