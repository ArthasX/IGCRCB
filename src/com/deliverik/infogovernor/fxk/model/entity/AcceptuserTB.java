/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.fxk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.fxk.model.AcceptuserInfo;

/**
  * ����: ���չ�����ʾ���������ݱ�ʵ��
  * ��������: ���չ�����ʾ���������ݱ�ʵ��
  * ������¼: 2014/06/17
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="acceptuser")
public class AcceptuserTB extends BaseEntity implements Serializable,
		Cloneable, AcceptuserInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="ACCEPTUSER_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ACCEPTUSER_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ACCEPTUSER_TABLE_GENERATOR")
	protected Integer apid;

	/** ������id */
	protected String apuserid;

	/** ���������� */
	protected String apusername;

	/** ���ջ����� */
	protected String aporgid;

	/** ���ջ������� */
	protected String aporgname;

	/** ������ʾ���� */
	protected Integer rwid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getApid() {
		return apid;
	}

	/**
	 * �����趨
	 *
	 * @param apid ����
	 */
	public void setApid(Integer apid) {
		this.apid = apid;
	}

	/**
	 * ������idȡ��
	 *
	 * @return ������id
	 */
	public String getApuserid() {
		return apuserid;
	}

	/**
	 * ������id�趨
	 *
	 * @param apuserid ������id
	 */
	public void setApuserid(String apuserid) {
		this.apuserid = apuserid;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getApusername() {
		return apusername;
	}

	/**
	 * �����������趨
	 *
	 * @param apusername ����������
	 */
	public void setApusername(String apusername) {
		this.apusername = apusername;
	}

	/**
	 * ���ջ�����ȡ��
	 *
	 * @return ���ջ�����
	 */
	public String getAporgid() {
		return aporgid;
	}

	/**
	 * ���ջ������趨
	 *
	 * @param aporgid ���ջ�����
	 */
	public void setAporgid(String aporgid) {
		this.aporgid = aporgid;
	}

	/**
	 * ���ջ�������ȡ��
	 *
	 * @return ���ջ�������
	 */
	public String getAporgname() {
		return aporgname;
	}

	/**
	 * ���ջ��������趨
	 *
	 * @param aporgname ���ջ�������
	 */
	public void setAporgname(String aporgname) {
		this.aporgname = aporgname;
	}

	/**
	 * ������ʾ����ȡ��
	 *
	 * @return ������ʾ����
	 */
	public Integer getRwid() {
		return rwid;
	}

	/**
	 * ������ʾ�����趨
	 *
	 * @param rwid ������ʾ����
	 */
	public void setRwid(Integer rwid) {
		this.rwid = rwid;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return apid;
	}

}