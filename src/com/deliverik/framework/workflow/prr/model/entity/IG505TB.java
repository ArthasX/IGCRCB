/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG505Info;

/**
  * ����: ���̱�ֵ��ʵ��
  * ��������: ���̱�ֵ��ʵ��
  * ������¼: 2013/08/28
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG505")
public class IG505TB extends BaseEntity implements Serializable,
		Cloneable, IG505Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG505_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG505_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG505_TABLE_GENERATOR")
	protected Integer piprrid;

	/** �������� */
	protected Integer prid;
	
	protected Integer piprid;

	/** �������� */
	protected String piprtype;

	/** �������� */
	protected String piprtitle;

	/**
	 * ����ȡ��
	 * @return piprrid ����
	 */
	public Integer getPiprrid() {
		return piprrid;
	}

	/**
	 * �����趨
	 * @param piprrid ����
	 */
	public void setPiprrid(Integer piprrid) {
		this.piprrid = piprrid;
	}

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * pipridȡ��
	 * @return piprid piprid
	 */
	public Integer getPiprid() {
		return piprid;
	}

	/**
	 * piprid�趨
	 * @param piprid piprid
	 */
	public void setPiprid(Integer piprid) {
		this.piprid = piprid;
	}

	/**
	 * ��������ȡ��
	 * @return piprtype ��������
	 */
	public String getPiprtype() {
		return piprtype;
	}

	/**
	 * ���������趨
	 * @param piprtype ��������
	 */
	public void setPiprtype(String piprtype) {
		this.piprtype = piprtype;
	}

	/**
	 * ��������ȡ��
	 * @return piprtitle ��������
	 */
	public String getPiprtitle() {
		return piprtitle;
	}

	/**
	 * ���������趨
	 * @param piprtitle ��������
	 */
	public void setPiprtitle(String piprtitle) {
		this.piprtitle = piprtitle;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.piprrid;
	}

}