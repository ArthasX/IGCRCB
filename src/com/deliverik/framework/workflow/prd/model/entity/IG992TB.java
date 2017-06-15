/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG992Info;

/**
  * ����: �����ⲿ���ö����ʵ��
  * ��������: �����ⲿ���ö����ʵ��
  * ������¼: 2012/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG992")
public class IG992TB extends BaseEntity implements Serializable,
		Cloneable, IG992Info {

	/** ���� */
	@Id
	@TableGenerator(
		name="IG992_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG992_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG992_TABLE_GENERATOR")
	protected Integer pedid;

	/** �¼�ID */
	protected String pedeventid;

	/** ����BL */
	protected String pedaction;

	/** ���� */
	protected String peddesc;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getPedid() {
		return pedid;
	}

	/**
	 * �����趨
	 *
	 * @param pedid ����
	 */
	public void setPedid(Integer pedid) {
		this.pedid = pedid;
	}

	/**
	 * �¼�IDȡ��
	 *
	 * @return �¼�ID
	 */
	public String getPedeventid() {
		return pedeventid;
	}

	/**
	 * �¼�ID�趨
	 *
	 * @param pedeventid �¼�ID
	 */
	public void setPedeventid(String pedeventid) {
		this.pedeventid = pedeventid;
	}

	/**
	 * ����BLȡ��
	 *
	 * @return ����BL
	 */
	public String getPedaction() {
		return pedaction;
	}

	/**
	 * ����BL�趨
	 *
	 * @param pedaction ����BL
	 */
	public void setPedaction(String pedaction) {
		this.pedaction = pedaction;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getPeddesc() {
		return peddesc;
	}

	/**
	 * �����趨
	 *
	 * @param peddesc ����
	 */
	public void setPeddesc(String peddesc) {
		this.peddesc = peddesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return pedid;
	}

}