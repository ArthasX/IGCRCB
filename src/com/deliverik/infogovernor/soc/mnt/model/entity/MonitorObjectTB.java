/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.dbs.model.entity.Collect_Symmetrix_InfoTB;
import com.deliverik.infogovernor.soc.mnt.model.MonitorObjectInfo;

/**
  * ����: ��ض�����Ϣʵ��
  * ��������: ��ض�����Ϣʵ��
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="monitorObject", schema="cst")
public class MonitorObjectTB extends BaseEntity implements Serializable,
		Cloneable, MonitorObjectInfo {

	/** ����Id */
	@Id
	@TableGenerator(
		name="MONITOROBJECT_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITOROBJECT_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITOROBJECT_TABLE_GENERATOR")
	protected Integer moId;

	/** ��ض������� */
	protected String moName;
	
	/** ip��ַ */
	protected String ip;

	/** ����ʱ�� */
	protected String moCreateTime;

	/** ������Ͳ���� */
	protected String mtSyscoding;

	/** ״̬ */
	protected String deleteFlag;
	
	/**MonitorTypeTB ʵ��*/
	@OneToOne
	@JoinColumn(name="mtSyscoding", referencedColumnName="mtSyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected MonitorTypeTB monitorTypeTB;
	
	/**Collect_Symmetrix_InfoTB ʵ��*/
	@OneToOne
	@JoinColumn(name="moName", referencedColumnName="symm_id", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB;

	/**
	 * ����Idȡ��
	 *
	 * @return ����Id
	 */
	public Integer getMoId() {
		return moId;
	}

	/**
	 * ����Id�趨
	 *
	 * @param moId ����Id
	 */
	public void setMoId(Integer moId) {
		this.moId = moId;
	}

	/**
	 * ��ض�������ȡ��
	 *
	 * @return ��ض�������
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * ��ض��������趨
	 *
	 * @param moName ��ض�������
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getMoCreateTime() {
		return moCreateTime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param moCreateTime ����ʱ��
	 */
	public void setMoCreateTime(String moCreateTime) {
		this.moCreateTime = moCreateTime;
	}

	/**
	 * ������Ͳ����ȡ��
	 *
	 * @return ������Ͳ����
	 */
	public String getMtSyscoding() {
		return mtSyscoding;
	}

	/**
	 * ������Ͳ�����趨
	 *
	 * @param mtSyscoding ������Ͳ����
	 */
	public void setMtSyscoding(String mtSyscoding) {
		this.mtSyscoding = mtSyscoding;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * ״̬�趨
	 *
	 * @param deleteFlag ״̬
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return moId;
	}

	/**
	 * ip��ַ��ȡ
	 * @return
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip��ַ�趨
	 * @param ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * MonitorTypeTB ʵ���ȡ
	 * @return
	 */
	public MonitorTypeTB getMonitorTypeTB() {
		return monitorTypeTB;
	}

	/**
	 * MonitorTypeTB ʵ���趨
	 * @param monitorTypeTB
	 */
	public void setMonitorTypeTB(MonitorTypeTB monitorTypeTB) {
		this.monitorTypeTB = monitorTypeTB;
	}

	/**
	 * Collect_Symmetrix_InfoTB ʵ��ȡ��
	 * @return
	 */
	public Collect_Symmetrix_InfoTB getCollect_Symmetrix_InfoTB() {
		return collect_Symmetrix_InfoTB;
	}

	/**
	 * Collect_Symmetrix_InfoTB ʵ���趨
	 * @param collect_Symmetrix_InfoTB
	 */
	public void setCollect_Symmetrix_InfoTB(
			Collect_Symmetrix_InfoTB collect_Symmetrix_InfoTB) {
		this.collect_Symmetrix_InfoTB = collect_Symmetrix_InfoTB;
	}

}