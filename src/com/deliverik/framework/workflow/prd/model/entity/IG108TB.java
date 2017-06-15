/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG108Info;

/**
  * ����: �Զ������̱���ѯ���������ʵ��
  * ��������: �Զ������̱���ѯ���������ʵ��
  * ������¼: 2013/03/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG108")
public class IG108TB extends BaseEntity implements Serializable, Cloneable, IG108Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG108_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG108_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG108_TABLE_GENERATOR")
	protected Integer pqid;

	/** ������������ */
	protected String pdid;

	/** ���������� */
	protected String pidid;
	
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	/** ��������Ϣ */
	protected IG007TB pidTB;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPqid() {
		return pqid;
	}

	/**
	 * �����趨
	 *
	 * @param pqid ����
	 */
	public void setPqid(Integer pqid) {
		this.pqid = pqid;
	}

	/**
	 * ������������ȡ��
	 *
	 * @return ������������
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * �������������趨
	 *
	 * @param pdid ������������
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * �����������趨
	 *
	 * @param pidid ����������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��������Ϣȡ��
	 * @return ��������Ϣ
	 */
	public IG007TB getPidTB() {
		return pidTB;
	}

	/**
	 * ��������Ϣ�趨
	 * @param pidTB ��������Ϣ
	 */
	public void setPidTB(IG007TB pidTB) {
		this.pidTB = pidTB;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pqid;
	}

}