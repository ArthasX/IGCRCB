/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0152Info;

/**
  * ����: �ʲ���ϵ��ʵ��
  * ��������: �ʲ���ϵ��ʵ��
  * ������¼: ����ȫ 2013/05/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0152")
@IdClass(SOC0152PK.class)
public class SOC0152TB extends BaseEntity implements Serializable,
		Cloneable, SOC0152Info {

	/** ��ϵ�� */
	protected String rlnCode;

	/** ��ʼģ������ */
	protected String fromModelName;

	/** ��ʼģ��ID */
	@Id
	protected String fromModelEid;

	/** ��ģ������ */
	protected String toModelName;

	/** ��ģ��ID */
	@Id
	protected String toModelEid;

	/** ��ϵ���� */
	protected String rlnDesc;

	/** Ԥ���ֶ�1 */
	protected String rlnKey1;

	/** Ԥ���ֶ�2 */
	protected String rlnKey2;
	
	/**��ϵ���*/
	protected String rlnType;
	
	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="frommodeleid", referencedColumnName="eid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB from0117TB;
	
	/** �������������Ϣ */
	@ManyToOne
	@JoinColumn(name="tomodeleid", referencedColumnName="eid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected SOC0117TB to0117TB;
	

	public SOC0117TB getFrom0117TB() {
		return from0117TB;
	}

	public void setFrom0117TB(SOC0117TB from0117TB) {
		this.from0117TB = from0117TB;
	}

	public SOC0117TB getTo0117TB() {
		return to0117TB;
	}

	public void setTo0117TB(SOC0117TB to0117TB) {
		this.to0117TB = to0117TB;
	}

	/**
	 * ��ϵ��ȡ��
	 *
	 * @return ��ϵ��
	 */
	public String getRlnCode() {
		return rlnCode;
	}

	/**
	 * ��ϵ���趨
	 *
	 * @param rlnCode ��ϵ��
	 */
	public void setRlnCode(String rlnCode) {
		this.rlnCode = rlnCode;
	}

	/**
	 * ��ʼģ������ȡ��
	 *
	 * @return ��ʼģ������
	 */
	public String getFromModelName() {
		return fromModelName;
	}

	/**
	 * ��ʼģ�������趨
	 *
	 * @param fromModelName ��ʼģ������
	 */
	public void setFromModelName(String fromModelName) {
		this.fromModelName = fromModelName;
	}

	/**
	 * ��ʼģ��IDȡ��
	 *
	 * @return ��ʼģ��ID
	 */
	public String getFromModelEid() {
		return fromModelEid;
	}

	/**
	 * ��ʼģ��ID�趨
	 *
	 * @param fromModelEid ��ʼģ��ID
	 */
	public void setFromModelEid(String fromModelEid) {
		this.fromModelEid = fromModelEid;
	}

	/**
	 * ��ģ������ȡ��
	 *
	 * @return ��ģ������
	 */
	public String getToModelName() {
		return toModelName;
	}

	/**
	 * ��ģ�������趨
	 *
	 * @param toModelName ��ģ������
	 */
	public void setToModelName(String toModelName) {
		this.toModelName = toModelName;
	}

	/**
	 * ��ģ��IDȡ��
	 *
	 * @return ��ģ��ID
	 */
	public String getToModelEid() {
		return toModelEid;
	}

	/**
	 * ��ģ��ID�趨
	 *
	 * @param toModelEid ��ģ��ID
	 */
	public void setToModelEid(String toModelEid) {
		this.toModelEid = toModelEid;
	}

	/**
	 * ��ϵ����ȡ��
	 *
	 * @return ��ϵ����
	 */
	public String getRlnDesc() {
		return rlnDesc;
	}

	/**
	 * ��ϵ�����趨
	 *
	 * @param rlnDesc ��ϵ����
	 */
	public void setRlnDesc(String rlnDesc) {
		this.rlnDesc = rlnDesc;
	}

	/**
	 * Ԥ���ֶ�1ȡ��
	 *
	 * @return Ԥ���ֶ�1
	 */
	public String getRlnKey1() {
		return rlnKey1;
	}

	/**
	 * Ԥ���ֶ�1�趨
	 *
	 * @param rlnKey1 Ԥ���ֶ�1
	 */
	public void setRlnKey1(String rlnKey1) {
		this.rlnKey1 = rlnKey1;
	}

	/**
	 * Ԥ���ֶ�2ȡ��
	 *
	 * @return Ԥ���ֶ�2
	 */
	public String getRlnKey2() {
		return rlnKey2;
	}

	/**
	 * Ԥ���ֶ�2�趨
	 *
	 * @param rlnKey2 Ԥ���ֶ�2
	 */
	public void setRlnKey2(String rlnKey2) {
		this.rlnKey2 = rlnKey2;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rlnCode;
	}

	/**
	 * ��ϵ���ȡ��
	 *
	 * @return rlnType ��ϵ���
	 */
	
	public String getRlnType() {
		return rlnType;
	}

	/**
	 * ��ϵ����趨
	 *
	 * @param rlnType ��ϵ���
	 */
	
	public void setRlnType(String rlnType) {
		this.rlnType = rlnType;
	}
	
	
}