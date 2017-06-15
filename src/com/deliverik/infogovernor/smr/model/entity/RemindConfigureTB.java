/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.smr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.smr.model.RemindConfigureInfo;

/**
  * ����: �������ñ�ʵ��
  * ��������: �������ñ�ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="remindConfigure")
public class RemindConfigureTB extends BaseEntity implements Serializable,
		Cloneable, RemindConfigureInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="REMINDCONFIGURE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REMINDCONFIGURE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REMINDCONFIGURE_TABLE_GENERATOR")
	protected Integer rcid;

	/** �� */
	protected String rcyear;

	/** �� */
	protected String rcmonth;

	/** �� */
	protected String rcday;

	/** ���� */
	protected String rctype;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRcid() {
		return rcid;
	}

	/**
	 * �����趨
	 *
	 * @param rcid ����
	 */
	public void setRcid(Integer rcid) {
		this.rcid = rcid;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcyear() {
		return rcyear;
	}

	/**
	 * ���趨
	 *
	 * @param rcyear ��
	 */
	public void setRcyear(String rcyear) {
		this.rcyear = rcyear;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcmonth() {
		return rcmonth;
	}

	/**
	 * ���趨
	 *
	 * @param rcmonth ��
	 */
	public void setRcmonth(String rcmonth) {
		this.rcmonth = rcmonth;
	}

	/**
	 * ��ȡ��
	 *
	 * @return ��
	 */
	public String getRcday() {
		return rcday;
	}

	/**
	 * ���趨
	 *
	 * @param rcday ��
	 */
	public void setRcday(String rcday) {
		this.rcday = rcday;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * �����趨
	 *
	 * @param rctype ����
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return rcid;
	}

}