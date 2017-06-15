/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC2301VWInfo;

/**	
 * ����: ���򿪷�ͳ�ƹ���α��ͼ
 * ������¼��yukexin    2014-8-12 10:57:13
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
@Entity
public class IGCRC2301VW implements Serializable,IGCRC2301VWInfo{

	/** ���� */
	@Id
	protected String userID;
	
	/** ��Ա���� */
	protected String userName;
	   
	/** �������� */
	protected Integer disposeNum;
	
	/** ���Ը��²��ش��� */
	protected int testUpdateRejectNum;
	
	/** ���Բ��ش��� */
	protected int testRejectNum;
	
	/** ȷ�ϲ��ش��� */
	protected int confirmRejectNum;

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
	 * ��������ȡ��
	 * @return disposeNum  ��������
	 */
	public Integer getDisposeNum() {
		if(disposeNum == null){
			this.disposeNum = 0;
		}
		return disposeNum;
	}

	/**
	 * ���������趨
	 * @param disposeNum  ��������
	 */
	public void setDisposeNum(Integer disposeNum) {
		this.disposeNum = disposeNum;
	}

	/**
	 * ���Ը��²��ش���ȡ��
	 * @return testUpdateRejectNum  ���Ը��²��ش���
	 */
	public int getTestUpdateRejectNum() {
		return testUpdateRejectNum;
	}

	/**
	 * ���Ը��²��ش����趨
	 * @param testUpdateRejectNum  ���Ը��²��ش���
	 */
	public void setTestUpdateRejectNum(int testUpdateRejectNum) {
		this.testUpdateRejectNum = testUpdateRejectNum;
	}

	/**
	 * ���Բ��ش���ȡ��
	 * @return testRejectNum  ���Բ��ش���
	 */
	public int getTestRejectNum() {
		return testRejectNum;
	}

	/**
	 * ���Բ��ش����趨
	 * @param testRejectNum  ���Բ��ش���
	 */
	public void setTestRejectNum(int testRejectNum) {
		this.testRejectNum = testRejectNum;
	}

	/**
	 * ȷ�ϲ��ش���ȡ��
	 * @return confirmRejectNum  ȷ�ϲ��ش���
	 */
	public int getConfirmRejectNum() {
		return confirmRejectNum;
	}

	/**
	 * ȷ�ϲ��ش����趨
	 * @param confirmRejectNum  ȷ�ϲ��ش���
	 */
	public void setConfirmRejectNum(int confirmRejectNum) {
		this.confirmRejectNum = confirmRejectNum;
	}


}
