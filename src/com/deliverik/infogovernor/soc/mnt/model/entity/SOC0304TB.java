/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.mnt.model.SOC0304Info;

/**
  * ����: �����������ʵ�� MONITORTASK
  * ��������: �����������ʵ�� MONITORTASK
  * ������¼: 2012/05/10
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0304")
public class SOC0304TB extends BaseEntity implements Serializable,
		Cloneable, SOC0304Info {

	/** ����ID */
	@Id
	@TableGenerator(
		name="MONITORTASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORTASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORTASK_TABLE_GENERATOR")
	protected Integer mtId;

	/** �洢���к� */
	protected String mtSsn;

	/** ������� */
	protected String mtCname;

	/** kpi */
	protected String mtKpi;

	/** �ɼ���� */
	protected Integer mtInterval;
	/**���������ַ���*/
	protected String mtObjNames;
	/** �ɼ����� */
	protected Integer mtNum;

	/** ��ʼʱ�� */
	protected String mtStartTime;

	/** ����ʱ�� */
	protected String mtStopTime;

	/** Ԥ�ƽ���ʱ�� */
	protected String mtPStopTime;

	/** ����״̬  0Ϊ���� 1Ϊ�ر�*/
	protected String mtStatus;

	/** ��¼ʱ�� */
	protected String mtRecordTime;

	/** ��¼�û�id */
	protected String mtUserId;

	/** �û�����ID */
	protected String mtOrgId;

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * ����ID�趨
	 *
	 * @param mtId ����ID
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * �洢���к�ȡ��
	 *
	 * @return �洢���к�
	 */
	public String getMtSsn() {
		return mtSsn;
	}

	/**
	 * �洢���к��趨
	 *
	 * @param mtSsn �洢���к�
	 */
	public void setMtSsn(String mtSsn) {
		this.mtSsn = mtSsn;
	}

	/**
	 * �������ȡ��
	 *
	 * @return �������
	 */
	public String getMtCname() {
		return mtCname;
	}

	/**
	 * ��������趨
	 *
	 * @param mtCname �������
	 */
	public void setMtCname(String mtCname) {
		this.mtCname = mtCname;
	}

	/**
	 * kpiȡ��
	 *
	 * @return kpi
	 */
	public String getMtKpi() {
		return mtKpi;
	}

	/**
	 * kpi�趨
	 *
	 * @param mtKpi kpi
	 */
	public void setMtKpi(String mtKpi) {
		this.mtKpi = mtKpi;
	}

	/**
	 * �ɼ����ȡ��
	 *
	 * @return �ɼ����
	 */
	public Integer getMtInterval() {
		return mtInterval;
	}

	/**
	 * �ɼ�����趨
	 *
	 * @param mtInterval �ɼ����
	 */
	public void setMtInterval(Integer mtInterval) {
		this.mtInterval = mtInterval;
	}

	/**
	 * �ɼ�����ȡ��
	 *
	 * @return �ɼ�����
	 */
	public Integer getMtNum() {
		return mtNum;
	}

	/**
	 * �ɼ������趨
	 *
	 * @param mtNum �ɼ�����
	 */
	public void setMtNum(Integer mtNum) {
		this.mtNum = mtNum;
	}

	/**
	 * ��ʼʱ��ȡ��
	 *
	 * @return ��ʼʱ��
	 */
	public String getMtStartTime() {
		return mtStartTime;
	}

	/**
	 * ��ʼʱ���趨
	 *
	 * @param mtStartTime ��ʼʱ��
	 */
	public void setMtStartTime(String mtStartTime) {
		this.mtStartTime = mtStartTime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMtStopTime() {
		return mtStopTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param mtStopTime ����ʱ��
	 */
	public void setMtStopTime(String mtStopTime) {
		this.mtStopTime = mtStopTime;
	}

	/**
	 * Ԥ�ƽ���ʱ��ȡ��
	 *
	 * @return Ԥ�ƽ���ʱ��
	 */
	public String getMtPStopTime() {
		return mtPStopTime;
	}

	/**
	 * Ԥ�ƽ���ʱ���趨
	 *
	 * @param mtPStopTime Ԥ�ƽ���ʱ��
	 */
	public void setMtPStopTime(String mtPStopTime) {
		this.mtPStopTime = mtPStopTime;
	}

	/**
	 * ����״̬ȡ��
	 *
	 * @return ����״̬
	 */
	public String getMtStatus() {
		return mtStatus;
	}

	/**
	 * ����״̬�趨
	 *
	 * @param mtStatus ����״̬
	 */
	public void setMtStatus(String mtStatus) {
		this.mtStatus = mtStatus;
	}

	/**
	 * ��¼ʱ��ȡ��
	 *
	 * @return ��¼ʱ��
	 */
	public String getMtRecordTime() {
		return mtRecordTime;
	}

	/**
	 * ��¼ʱ���趨
	 *
	 * @param mtRecordTime ��¼ʱ��
	 */
	public void setMtRecordTime(String mtRecordTime) {
		this.mtRecordTime = mtRecordTime;
	}

	/**
	 * ��¼�û�idȡ��
	 *
	 * @return ��¼�û�id
	 */
	public String getMtUserId() {
		return mtUserId;
	}

	/**
	 * ��¼�û�id�趨
	 *
	 * @param mtUserId ��¼�û�id
	 */
	public void setMtUserId(String mtUserId) {
		this.mtUserId = mtUserId;
	}

	/**
	 * �û�����IDȡ��
	 *
	 * @return �û�����ID
	 */
	public String getMtOrgId() {
		return mtOrgId;
	}

	/**
	 * �û�����ID�趨
	 *
	 * @param mtOrgId �û�����ID
	 */
	public void setMtOrgId(String mtOrgId) {
		this.mtOrgId = mtOrgId;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return mtId;
	}

	/**
	 * ���������ַ���ȡ��
	 *
	 * @return mtObjNames ���������ַ���
	 */
	public String getMtObjNames() {
		return mtObjNames;
	}

	/**
	 * ���������ַ����趨
	 *
	 * @param mtObjNames ���������ַ���
	 */
	public void setMtObjNames(String mtObjNames) {
		this.mtObjNames = mtObjNames;
	}

}