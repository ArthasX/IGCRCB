/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;

/**
  * ����: ������Ŀʵ��
  * ��������: ������Ŀʵ��
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="Internalauditprj")
public class InternalauditprjTB extends BaseEntity implements Serializable,
		Cloneable, InternalauditprjInfo {

	/** �������������� */
	@Id
	@TableGenerator(
		name="INTERNALAUDITPRJ_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="INTERNALAUDITPRJ_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INTERNALAUDITPRJ_TABLE_GENERATOR")
	protected Integer iapId;

	/** ������ */
	protected String iapYear;

	/** �����Ŀ���� */
	protected String iapName;

	/** �����Ŀ״̬ */
	protected String iapStatus;

	/** ��ƶ��� */
	protected String iapObject;

	/** ��Ʒ�ʽ */
	protected String iapWay;

	/** �����Ա */
	protected String iapUserName;

	/** ��ƿ�ʼ���� */
	protected String iapOpenTime;

	/** ��ƽ������� */
	protected String iapCloseTime;

	/** ���Ŀ�� */
	protected String iapObjective;

	/** ��Ʒ�Χ */
	protected String iapScope;

	/** ������� */
	protected String iapBasis;

	/** ������ݼ�Ҫ�� */
	protected String iapDesc;

	/** ��������Ա */
	protected String iapCooperator;

	/** ��ƽ��� */
	protected String iapSuggestion;

	/** �����Ŀ������ID */
	protected String iapCreateUserId;

	/** �����Ŀ����ʱ�� */
	protected String iapCreateTime;

	/** �����Ŀȷ����ID */
	protected String iapConfirmUserId;

	/** �����Ŀȷ��ʱ�� */
	protected String iapConfirmTime;

	/** ��Ƹ���Key */
	protected String iapAttKey;

	/** ������� */
	protected String iapType;
	
	/** ��Ƽ����Դ */
	protected String iapSource;
	
	
	/**
	 * ��������������ȡ��
	 *
	 * @return ��������������
	 */
	public Integer getIapId() {
		return iapId;
	}

	/**
	 * ���������������趨
	 *
	 * @param iapId ��������������
	 */
	public void setIapId(Integer iapId) {
		this.iapId = iapId;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getIapYear() {
		return iapYear;
	}

	/**
	 * �������趨
	 *
	 * @param iapYear ������
	 */
	public void setIapYear(String iapYear) {
		this.iapYear = iapYear;
	}

	/**
	 * �����Ŀ����ȡ��
	 *
	 * @return �����Ŀ����
	 */
	public String getIapName() {
		return iapName;
	}

	/**
	 * �����Ŀ�����趨
	 *
	 * @param iapName �����Ŀ����
	 */
	public void setIapName(String iapName) {
		this.iapName = iapName;
	}

	/**
	 * �����Ŀ״̬ȡ��
	 *
	 * @return �����Ŀ״̬
	 */
	public String getIapStatus() {
		return iapStatus;
	}

	/**
	 * �����Ŀ״̬�趨
	 *
	 * @param iapStatus �����Ŀ״̬
	 */
	public void setIapStatus(String iapStatus) {
		this.iapStatus = iapStatus;
	}

	/**
	 * ��ƶ���ȡ��
	 *
	 * @return ��ƶ���
	 */
	public String getIapObject() {
		return iapObject;
	}

	/**
	 * ��ƶ����趨
	 *
	 * @param iapObject ��ƶ���
	 */
	public void setIapObject(String iapObject) {
		this.iapObject = iapObject;
	}

	/**
	 * ��Ʒ�ʽȡ��
	 *
	 * @return ��Ʒ�ʽ
	 */
	public String getIapWay() {
		return iapWay;
	}

	/**
	 * ��Ʒ�ʽ�趨
	 *
	 * @param iapWay ��Ʒ�ʽ
	 */
	public void setIapWay(String iapWay) {
		this.iapWay = iapWay;
	}

	/**
	 * �����Աȡ��
	 *
	 * @return �����Ա
	 */
	public String getIapUserName() {
		return iapUserName;
	}

	/**
	 * �����Ա�趨
	 *
	 * @param iapUserName �����Ա
	 */
	public void setIapUserName(String iapUserName) {
		this.iapUserName = iapUserName;
	}

	/**
	 * ��ƿ�ʼ����ȡ��
	 *
	 * @return ��ƿ�ʼ����
	 */
	public String getIapOpenTime() {
		return iapOpenTime;
	}

	/**
	 * ��ƿ�ʼ�����趨
	 *
	 * @param iapOpenTime ��ƿ�ʼ����
	 */
	public void setIapOpenTime(String iapOpenTime) {
		this.iapOpenTime = iapOpenTime;
	}

	/**
	 * ��ƽ�������ȡ��
	 *
	 * @return ��ƽ�������
	 */
	public String getIapCloseTime() {
		return iapCloseTime;
	}

	/**
	 * ��ƽ��������趨
	 *
	 * @param iapCloseTime ��ƽ�������
	 */
	public void setIapCloseTime(String iapCloseTime) {
		this.iapCloseTime = iapCloseTime;
	}

	/**
	 * ���Ŀ��ȡ��
	 *
	 * @return ���Ŀ��
	 */
	public String getIapObjective() {
		return iapObjective;
	}

	/**
	 * ���Ŀ���趨
	 *
	 * @param iapObjective ���Ŀ��
	 */
	public void setIapObjective(String iapObjective) {
		this.iapObjective = iapObjective;
	}

	/**
	 * ��Ʒ�Χȡ��
	 *
	 * @return ��Ʒ�Χ
	 */
	public String getIapScope() {
		return iapScope;
	}

	/**
	 * ��Ʒ�Χ�趨
	 *
	 * @param iapScope ��Ʒ�Χ
	 */
	public void setIapScope(String iapScope) {
		this.iapScope = iapScope;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getIapBasis () {
		return iapBasis ;
	}

	/**
	 * ��������趨
	 *
	 * @param iapBasis  �������
	 */
	public void setIapBasis (String iapBasis ) {
		this.iapBasis  = iapBasis ;
	}

	/**
	 * ������ݼ�Ҫ��ȡ��
	 *
	 * @return ������ݼ�Ҫ��
	 */
	public String getIapDesc() {
		return iapDesc;
	}

	/**
	 * ������ݼ�Ҫ���趨
	 *
	 * @param iapDesc ������ݼ�Ҫ��
	 */
	public void setIapDesc(String iapDesc) {
		this.iapDesc = iapDesc;
	}

	/**
	 * ��������Աȡ��
	 *
	 * @return ��������Ա
	 */
	public String getIapCooperator() {
		return iapCooperator;
	}

	/**
	 * ��������Ա�趨
	 *
	 * @param iapCooperator ��������Ա
	 */
	public void setIapCooperator(String iapCooperator) {
		this.iapCooperator = iapCooperator;
	}

	/**
	 * ��ƽ���ȡ��
	 *
	 * @return ��ƽ���
	 */
	public String getIapSuggestion() {
		return iapSuggestion;
	}

	/**
	 * ��ƽ����趨
	 *
	 * @param iapSuggestion ��ƽ���
	 */
	public void setIapSuggestion(String iapSuggestion) {
		this.iapSuggestion = iapSuggestion;
	}

	/**
	 * �����Ŀ������IDȡ��
	 *
	 * @return �����Ŀ������ID
	 */
	public String getIapCreateUserId() {
		return iapCreateUserId;
	}

	/**
	 * �����Ŀ������ID�趨
	 *
	 * @param iapCreateUserId �����Ŀ������ID
	 */
	public void setIapCreateUserId(String iapCreateUserId) {
		this.iapCreateUserId = iapCreateUserId;
	}

	/**
	 * �����Ŀ����ʱ��ȡ��
	 *
	 * @return �����Ŀ����ʱ��
	 */
	public String getIapCreateTime() {
		return iapCreateTime;
	}

	/**
	 * �����Ŀ����ʱ���趨
	 *
	 * @param iapCreateTime �����Ŀ����ʱ��
	 */
	public void setIapCreateTime(String iapCreateTime) {
		this.iapCreateTime = iapCreateTime;
	}

	/**
	 * �����Ŀȷ����IDȡ��
	 *
	 * @return �����Ŀȷ����ID
	 */
	public String getIapConfirmUserId() {
		return iapConfirmUserId;
	}

	/**
	 * �����Ŀȷ����ID�趨
	 *
	 * @param iapConfirmUserId �����Ŀȷ����ID
	 */
	public void setIapConfirmUserId(String iapConfirmUserId) {
		this.iapConfirmUserId = iapConfirmUserId;
	}

	/**
	 * �����Ŀȷ��ʱ��ȡ��
	 *
	 * @return �����Ŀȷ��ʱ��
	 */
	public String getIapConfirmTime() {
		return iapConfirmTime;
	}

	/**
	 * �����Ŀȷ��ʱ���趨
	 *
	 * @param iapConfirmTime �����Ŀȷ��ʱ��
	 */
	public void setIapConfirmTime(String iapConfirmTime) {
		this.iapConfirmTime = iapConfirmTime;
	}

	/**
	 * ��Ƹ���Keyȡ��
	 *
	 * @return ��Ƹ���Key
	 */
	public String getIapAttKey() {
		return iapAttKey;
	}

	/**
	 * ��Ƹ���Key�趨
	 *
	 * @param iapAttKey ��Ƹ���Key
	 */
	public void setIapAttKey(String iapAttKey) {
		this.iapAttKey = iapAttKey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return iapId;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getIapType() {
		return iapType;
	}

	/**
	 * ��������趨
	 *
	 * @param iapType �������
	 */
	public void setIapType(String iapType) {
		this.iapType = iapType;
	}

	/**
	 * ��Ƽ����Դȡ��
	 *
	 * @return ��Ƽ����Դ
	 */
	public String getIapSource() {
		return iapSource;
	}

	/**
	 * ��Ƽ����Դ�趨
	 *
	 * @param iapSource ��Ƽ����Դ
	 */
	public void setIapSource(String iapSource) {
		this.iapSource = iapSource;
	}

}