/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
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
import com.deliverik.framework.workflow.prr.model.IG715Info;

/**
 * <p>����:���񹤵���������ʵ��</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG715")
public class IG715TB extends BaseEntity implements Serializable, Cloneable, IG715Info {
	/** ���񹤵�ID */
	@Id
	@TableGenerator(
		    name="IG715_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG715_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG715_TABLE_GENERATOR")
	protected Integer sprrid;

	/** ���񹤵�ID*/
	protected Integer sprrsfid;

	/** ����ID*/
	protected Integer sprrprid;

	/** ʱ��*/
	protected String sprrinstime;

	
	/** ���񹤵�����ʵ�� */
	@OneToOne
	@JoinColumn(name="sprrsfid", referencedColumnName="sfid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG933TB ServiceFormTB;
	
	/** ��������ʵ�� */
	@OneToOne
	@JoinColumn(name="sprrprid", referencedColumnName="prid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG500TB ProcessRecordTB;
	
	/**
	 * ���ܣ�����ȡ��
	 * @return sprrid ����
	 */
	public Serializable getPK() {
		return sprrid;
	}
	
	/**
	 * ���ܣ�����ȡ��
	 * @return sprrid ����
	 */
	public Integer getSprrid() {
		return sprrid;
	}

	/**
	 * ���ܣ���������
	 * @param sprrid ����
	 */
	public void setSprrid(Integer sprrid) {
		this.sprrid = sprrid;
	}
	
	/**
	 * ���ܣ����񹤵�IDȡ��
	 * @return ���񹤵�ID
	 */
	public Integer getSprrsfid() {
		return sprrsfid;
	}

	/**
	 * ���ܣ����񹤵�ID����
	 * @param sprrsfid ���񹤵�ID
	 */
	public void setSprrsfid(Integer sprrsfid) {
		this.sprrsfid = sprrsfid;
	}
	
	/**
	 * ���ܣ�����IDȡ��
	 * @return ����ID 
	 */
	public Integer getSprrprid() {
		return sprrprid;
	}

	/**
	 * ���ܣ�����ID����
	 * @param sprrprid ����ID
	 */
	public void setSprrprid(Integer sprrprid) {
		this.sprrprid = sprrprid;
	}
	
	/**
	 * ���ܣ�ʱ��ȡ��
	 * @return ʱ�� 
	 */
	public String getSprrinstime() {
		return sprrinstime;
	}

	/**
	 * ���ܣ�ʱ������
	 * @param sprrinstime ʱ��
	 */
	public void setSprrinstime(String sprrinstime) {
		this.sprrinstime = sprrinstime;
	}
	
	/**
	 * ���ܣ����񹤵�����ȡ��
	 * @return ���񹤵����� 
	 */
	public IG933TB getServiceFormTB() {
		return ServiceFormTB;
	}

	/**
	 * ���ܣ����񹤵���������
	 * @param serviceFormTB ���񹤵�����
	 */
	public void setServiceFormTB(IG933TB serviceFormTB) {
		ServiceFormTB = serviceFormTB;
	}
	
	/**
	 * ���ܣ����̶���ȡ��
	 * @return ���̶��� 
	 */
	public IG500TB getProcessRecordTB() {
		return ProcessRecordTB;
	}

	/**
	 * ���ܣ����̶�������
	 * @param processRecordTB ���̶���
	 */
	public void setProcessRecordTB(IG500TB processRecordTB) {
		ProcessRecordTB = processRecordTB;
	}
	
}
