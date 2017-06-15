/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.vo;

import javax.persistence.Id;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;

/**	
 * ����: ��Ա����ͳ��ҳ����ʾVO 
 * ������¼��yukexin 2014-8-8 16:33:31
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2102VO extends BaseVO{

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
	
	/** �ϼƸ��� */
	protected Integer total;


	public IGCRC2102VO() {
		super();
	}

	public IGCRC2102VO(IGCRC2101VWInfo vwInfo, Integer total) {
		super();
		this.userID = vwInfo.getUserID();
		this.userName = vwInfo.getUserName();
		this.incidentNum = vwInfo.getIncidentNum();
		this.problemNum = vwInfo.getProblemNum();
		this.changeNum = vwInfo.getChangeNum();
		this.serviceNum = vwInfo.getServiceNum();
		this.developNum = vwInfo.getDevelopNum();
		this.total = total;
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

	/**
	 * �ϼƸ���ȡ��
	 * @return total  �ϼƸ���
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * �ϼƸ����趨
	 * @param total  �ϼƸ���
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}



}
