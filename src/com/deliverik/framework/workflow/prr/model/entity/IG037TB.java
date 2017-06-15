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
import com.deliverik.framework.workflow.prr.model.IG037Info;

/**
  * ����: ���̵�����־��ʵ��
  * ��������: ���̵�����־��ʵ��
  * ������¼: 2014/11/14
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="iG037")
public class IG037TB extends BaseEntity implements Serializable,
		Cloneable, IG037Info {

	/** ���̵������� */
	@Id
	@TableGenerator(
		name="IG037_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG037_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG037_TABLE_GENERATOR")
	protected Integer irid;

	/** �������� */
	protected Integer prid;

	/** ����ʱ�� */
	protected String irtime;

	/** �����û�ID */
	protected String iruserid;

	/** �����û����� */
	protected String irusername;

	/** ���벿��id */
	protected String irorgid;

	/** ���벿������ */
	protected String irorgname;

	/** ������־���� */
	protected String irdesc;

	/** ������־���� */
	protected String ircomment;

	/**
	 * ���̵�������ȡ��
	 *
	 * @return ���̵�������
	 */
	public Integer getIrid() {
		return irid;
	}

	/**
	 * ���̵��������趨
	 *
	 * @param irid ���̵�������
	 */
	public void setIrid(Integer irid) {
		this.irid = irid;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 *
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getIrtime() {
		return irtime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param irtime ����ʱ��
	 */
	public void setIrtime(String irtime) {
		this.irtime = irtime;
	}

	/**
	 * �����û�IDȡ��
	 *
	 * @return �����û�ID
	 */
	public String getIruserid() {
		return iruserid;
	}

	/**
	 * �����û�ID�趨
	 *
	 * @param iruserid �����û�ID
	 */
	public void setIruserid(String iruserid) {
		this.iruserid = iruserid;
	}

	/**
	 * �����û�����ȡ��
	 *
	 * @return �����û�����
	 */
	public String getIrusername() {
		return irusername;
	}

	/**
	 * �����û������趨
	 *
	 * @param irusername �����û�����
	 */
	public void setIrusername(String irusername) {
		this.irusername = irusername;
	}

	/**
	 * ���벿��idȡ��
	 *
	 * @return ���벿��id
	 */
	public String getIrorgid() {
		return irorgid;
	}

	/**
	 * ���벿��id�趨
	 *
	 * @param irorgid ���벿��id
	 */
	public void setIrorgid(String irorgid) {
		this.irorgid = irorgid;
	}

	/**
	 * ���벿������ȡ��
	 *
	 * @return ���벿������
	 */
	public String getIrorgname() {
		return irorgname;
	}

	/**
	 * ���벿�������趨
	 *
	 * @param irorgname ���벿������
	 */
	public void setIrorgname(String irorgname) {
		this.irorgname = irorgname;
	}

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getIrdesc() {
		return irdesc;
	}

	/**
	 * ������־�����趨
	 *
	 * @param irdesc ������־����
	 */
	public void setIrdesc(String irdesc) {
		this.irdesc = irdesc;
	}

	/**
	 * ������־����ȡ��
	 *
	 * @return ������־����
	 */
	public String getIrcomment() {
		return ircomment;
	}

	/**
	 * ������־�����趨
	 *
	 * @param ircomment ������־����
	 */
	public void setIrcomment(String ircomment) {
		this.ircomment = ircomment;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return irid;
	}

}