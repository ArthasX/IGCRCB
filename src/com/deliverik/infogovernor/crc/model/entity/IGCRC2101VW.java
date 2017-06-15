/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;

/**
 * ����: ��Ա����ͳ�ƹ���α��ͼ ������¼��yukexin 2014-8-7 10:21:47 �޸ļ�¼��null
 */
@SuppressWarnings("serial")
@Entity
public class IGCRC2101VW implements Serializable, IGCRC2101VWInfo {

	/** ���� */
	@Id
	protected String userID;

	/** ��Ա���� */
	protected String userName;

	/** �¼����� */
	protected Integer incidentNum;

	/** ������� */
	protected Integer problemNum;

	/** ������� */
	protected Integer changeNum;

	/** ����������� */
	protected Integer serviceNum;

	/** ����������� */
	protected Integer developNum;

	public IGCRC2101VW(String userID, String userName, Integer incidentNum,
			Integer problemNum, Integer changeNum, Integer serviceNum,
			Integer developNum) {
		super();
		this.userID = userID;
		this.userName = userName;
		this.incidentNum = incidentNum;
		this.problemNum = problemNum;
		this.changeNum = changeNum;
		this.serviceNum = serviceNum;
		this.developNum = developNum;
	}

	public IGCRC2101VW() {
		super();
	}

	public String getFingerPrint() {
		return null;
	}


	/**
	 * ����ȡ��
	 * @return userID  ����
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * �����趨
	 * @param userID  ����
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * ��Ա����ȡ��
	 * @return userName  ��Ա����
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * ��Ա�����趨
	 * @param userName  ��Ա����
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �¼�����ȡ��
	 * @return incidentNum  �¼�����
	 */
	public Integer getIncidentNum() {
		return incidentNum;
	}

	/**
	 * �¼������趨
	 * @param incidentNum  �¼�����
	 */
	public void setIncidentNum(Integer incidentNum) {
		this.incidentNum = incidentNum;
	}

	/**
	 * �������ȡ��
	 * @return problemNum  �������
	 */
	public Integer getProblemNum() {
		return problemNum;
	}

	/**
	 * ��������趨
	 * @param problemNum  �������
	 */
	public void setProblemNum(Integer problemNum) {
		this.problemNum = problemNum;
	}

	/**
	 * �������ȡ��
	 * @return changeNum  �������
	 */
	public Integer getChangeNum() {
		return changeNum;
	}

	/**
	 * ��������趨
	 * @param changeNum  �������
	 */
	public void setChangeNum(Integer changeNum) {
		this.changeNum = changeNum;
	}

	/**
	 * �����������ȡ��
	 * @return serviceNum  �����������
	 */
	public Integer getServiceNum() {
		return serviceNum;
	}

	/**
	 * ������������趨
	 * @param serviceNum  �����������
	 */
	public void setServiceNum(Integer serviceNum) {
		this.serviceNum = serviceNum;
	}

	/**
	 * �����������ȡ��
	 * @return developNum  �����������
	 */
	public Integer getDevelopNum() {
		return developNum;
	}

	/**
	 * ������������趨
	 * @param developNum  �����������
	 */
	public void setDevelopNum(Integer developNum) {
		this.developNum = developNum;
	}


}
