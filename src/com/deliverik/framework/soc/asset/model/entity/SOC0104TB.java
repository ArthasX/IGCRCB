/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0104Info;

/**
  * ����: ��������ʵ��
  * ��������: ��������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="SOC0104")
public class SOC0104TB extends BaseEntity implements Serializable,
		Cloneable, SOC0104Info {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="SOC0104_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="SOC0104_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SOC0104_TABLE_GENERATOR")
	protected Integer autid;

	/** ����������� */
	protected String autdesc;

	/** ���ʱ��� */
	protected String auttime;
	
	/** ״̬ */
	protected String autstatus;
	
	/** ������ʱ�� */
	protected String autupdtime;
	
	/** ���Ա�ʱ�� */
	protected String autcomptime;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getAutid() {
		return autid;
	}

	/**
	 * �߼������趨
	 *
	 * @param autid �߼�����
	 */
	public void setAutid(Integer autid) {
		this.autid = autid;
	}

	/**
	 * �����������ȡ��
	 *
	 * @return �����������
	 */
	public String getAutdesc() {
		return autdesc;
	}

	/**
	 * ������������趨
	 *
	 * @param autdesc �����������
	 */
	public void setAutdesc(String autdesc) {
		this.autdesc = autdesc;
	}

	/**
	 * ���ʱ���ȡ��
	 *
	 * @return ���ʱ���
	 */
	public String getAuttime() {
		return auttime;
	}

	/**
	 * ���ʱ����趨
	 *
	 * @param auttime ���ʱ���
	 */
	public void setAuttime(String auttime) {
		this.auttime = auttime;
	}
	
	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getAutstatus() {
		return autstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param autstatus ״̬
	 */
	public void setAutstatus(String autstatus) {
		this.autstatus = autstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return autid;
	}

	/**
	 * ������ʱ��ȡ��
	 * @return ������ʱ��
	 */
	public String getAutupdtime() {
		return autupdtime;
	}

	/**
	 * ������ʱ���趨
	 * @param autupdtime ������ʱ��
	 */ 
	public void setAutupdtime(String autupdtime) {
		this.autupdtime = autupdtime;
	}

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getAutcomptime() {
		return autcomptime;
	}

	/**
	 * ���Ա�ʱ���趨
	 * @param autcomptime ���Ա�ʱ��
	 */
	public void setAutcomptime(String autcomptime) {
		this.autcomptime = autcomptime;
	}

}