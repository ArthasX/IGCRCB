/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CITaskInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * ����: CI��������ʵ��
  * ��������: CI��������ʵ��
  * ������¼: 2011/05/18
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CITask")
public class CITaskTB extends BaseEntity implements Serializable,
		Cloneable, CITaskInfo {

	/** �߼����� */
	@Id
	@TableGenerator(
		name="CITASK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="CITASK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CITASK_TABLE_GENERATOR")
	protected Integer citid;

	/** CI����������� */
	protected String citdesc;

	/** CI���ʱ��� */
	protected String cittime;
	
	/** ״̬ */
	protected String citstatus;
	
	/** ������ʱ�� */
	protected String citupdtime;
	
	/** ���Ա�ʱ�� */
	protected String citcomptime;

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getCitid() {
		return citid;
	}

	/**
	 * �߼������趨
	 *
	 * @param citid �߼�����
	 */
	public void setCitid(Integer citid) {
		this.citid = citid;
	}

	/**
	 * CI�����������ȡ��
	 *
	 * @return CI�����������
	 */
	public String getCitdesc() {
		return citdesc;
	}

	/**
	 * CI������������趨
	 *
	 * @param citdesc CI�����������
	 */
	public void setCitdesc(String citdesc) {
		this.citdesc = citdesc;
	}

	/**
	 * CI���ʱ���ȡ��
	 *
	 * @return CI���ʱ���
	 */
	public String getCittime() {
		return cittime;
	}

	/**
	 * CI���ʱ����趨
	 *
	 * @param cittime CI���ʱ���
	 */
	public void setCittime(String cittime) {
		this.cittime = cittime;
	}
	
	
	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getCitstatus() {
		return citstatus;
	}

	/**
	 * ״̬�趨
	 * 
	 * @param citstatus ״̬
	 */
	public void setCitstatus(String citstatus) {
		this.citstatus = citstatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return citid;
	}
	
	/**
	 * ������ʱ��ȡ��
	 * @return ������ʱ��
	 */
	public String getCitupdtime() {
		return citupdtime;
	}

	/**
	 * ������ʱ���趨
	 * @param citupdtime ������ʱ��
	 */ 
	public void setCitupdtime(String citupdtime) {
		this.citupdtime = citupdtime;
	}

	/**
	 * ���Ա�ʱ��ȡ��
	 * @return ���Ա�ʱ��
	 */
	public String getCitcomptime() {
		return citcomptime;
	}

	/**
	 * ���Ա�ʱ���趨
	 * @param citcomptime ���Ա�ʱ��
	 */
	public void setCitcomptime(String citcomptime) {
		this.citcomptime = citcomptime;
	}


}