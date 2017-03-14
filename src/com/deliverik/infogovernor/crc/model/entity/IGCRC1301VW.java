/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.crc.model.IGCRC1301VWInfo;

/**
 * ����: �ĵ���ѯ��ͼʵ��
 * ��������: �ĵ���ѯʵ��
 * ������¼: 2014/07/15
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
@Entity
public class IGCRC1301VW implements Serializable,
Cloneable, IGCRC1301VWInfo {
	
	@Id
	/** ���� */
	protected String eiid;
	
	/** �ĵ���� */
	protected String eiNumber;
	
	/** �ĵ����� */
	protected String eiName;
	
	/** �ĵ����� */
	protected String eiType;
	
	/** �ĵ����� */
	protected String eiSort;
	
	/** �ĵ��ܼ� */
	protected String eiDense;
	
	/** ���� */
	protected String department;
	
	/** ������ */
	protected String managermentPerson;
	
	/** ���� */
	protected String content;
	
	/** �洢��ʽ */
	protected String storageWay;
	
	/** ���λ�� */
	protected String storageLocation;
	
	/** ������ */
	protected String userName;
	
	/** ʱ��� */
	//protected String fingerPrint;
	
	/** eid */
	protected String eid;
	
	/** eLabel */
	protected String eLabel;
	
	/** eName */
	protected String eName;
	
	/** eiLabel */
	protected String eiLabel;
	
	/** eCategory */
	protected String eCategory;
	
	/** �汾�� */
	protected String eiVersion;

	/** �Ƿ������ */
	protected String isDownload;
	
	/**
	 * ������ȡ��
	 * @return userName ������
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * �������趨
	 * @param userName ������
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * �洢��ʽȡ��
	 * @return storageWay �洢��ʽ
	 */
	public String getStorageWay() {
		return storageWay;
	}

	/**
	 * �洢��ʽ�趨
	 * @param storageWay �洢��ʽ
	 */
	public void setStorageWay(String storageWay) {
		this.storageWay = storageWay;
	}

	/**
	 * ���λ��ȡ��
	 * @return storageLocation ���λ��
	 */
	public String getStorageLocation() {
		return storageLocation;
	}

	/**
	 * ���λ���趨
	 * @param storageLocation ���λ��
	 */
	public void setStorageLocation(String storageLocation) {
		this.storageLocation = storageLocation;
	}
	
	/**
	 * �ĵ����ȡ��
	 * @return eiNumber �ĵ����
	 */
	public String getEiNumber() {
		return eiNumber;
	}

	/**
	 * �ĵ�����趨
	 * @param eiNumber �ĵ����
	 */
	public void setEiNumber(String eiNumber) {
		this.eiNumber = eiNumber;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiName �ĵ�����
	 */
	public String getEiName() {
		return eiName;
	}

	/**
	 * �ĵ������趨
	 * @param eiName �ĵ�����
	 */
	public void setEiName(String eiName) {
		this.eiName = eiName;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiType �ĵ�����
	 */
	public String getEiType() {
		return eiType;
	}

	/**
	 * �ĵ������趨
	 * @param eiType �ĵ�����
	 */
	public void setEiType(String eiType) {
		this.eiType = eiType;
	}

	/**
	 * �ĵ�����ȡ��
	 * @return eiSort �ĵ�����
	 */
	public String getEiSort() {
		return eiSort;
	}

	/**
	 * �ĵ������趨
	 * @param eiSort �ĵ�����
	 */
	public void setEiSort(String eiSort) {
		this.eiSort = eiSort;
	}

	/**
	 * �ĵ��ܼ�ȡ��
	 * @return eiDense �ĵ��ܼ�
	 */
	public String getEiDense() {
		return eiDense;
	}

	/**
	 * �ĵ��ܼ��趨
	 * @param eiDense �ĵ��ܼ�
	 */
	public void setEiDense(String eiDense) {
		this.eiDense = eiDense;
	}

	/**
	 * ����ȡ��
	 * @return department ����
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * �����趨
	 * @param department ����
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * ������ȡ��
	 * @return managermentPerson ������
	 */
	public String getManagermentPerson() {
		return managermentPerson;
	}

	/**
	 * �������趨
	 * @param managermentPerson ������
	 */
	public void setManagermentPerson(String managermentPerson) {
		this.managermentPerson = managermentPerson;
	}

	/**
	 * ����ȡ��
	 * @return content ����
	 */
	public String getContent() {
		return content;
	}

	/**
	 * �����趨
	 * @param content ����
	 */
	public void setContent(String content) {
		this.content = content;
	}

	
	public String getFingerPrint() {
		return null;
	}

	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid() {
		return eiid;
	}

	/**
	 * eiid�趨
	 * @param eiid eiid
	 */
	public void setEiid(String eiid) {
		this.eiid = eiid;
	}

	/**
	 * eidȡ��
	 * @return eid eid
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * eid�趨
	 * @param eid eid
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * eLabelȡ��
	 * @return eLabel eLabel
	 */
	public String geteLabel() {
		return eLabel;
	}

	/**
	 * eLabel�趨
	 * @param eLabel eLabel
	 */
	public void seteLabel(String eLabel) {
		this.eLabel = eLabel;
	}

	/**
	 * eiLabelȡ��
	 * @return eiLabel eiLabel
	 */
	public String getEiLabel() {
		return eiLabel;
	}

	/**
	 * eiLabel�趨
	 * @param eiLabel eiLabel
	 */
	public void setEiLabel(String eiLabel) {
		this.eiLabel = eiLabel;
	}

	/**
	 * eCategoryȡ��
	 * @return eCategory eCategory
	 */
	public String geteCategory() {
		return eCategory;
	}

	/**
	 * eCategory�趨
	 * @param eCategory eCategory
	 */
	public void seteCategory(String eCategory) {
		this.eCategory = eCategory;
	}

	/**
	 * �汾��ȡ��
	 * @return eiVersion �汾��
	 */
	public String getEiVersion() {
		return eiVersion;
	}

	/**
	 * �汾���趨
	 * @param eiVersion �汾��
	 */
	public void setEiVersion(String eiVersion) {
		this.eiVersion = eiVersion;
	}

	/**
	 * eNameȡ��
	 * @return eName eName
	 */
	public String geteName() {
		return eName;
	}

	/**
	 * eName�趨
	 * @param eName eName
	 */
	public void seteName(String eName) {
		this.eName = eName;
	}

	/**
	 * �Ƿ������ȡ��
	 * @return isDownload �Ƿ������
	 */
	public String getIsDownload() {
		return isDownload;
	}

	/**
	 * �Ƿ�������趨
	 * @param isDownload �Ƿ������
	 */
	public void setIsDownload(String isDownload) {
		this.isDownload = isDownload;
	}
}
