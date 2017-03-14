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
import com.deliverik.infogovernor.smr.model.RemindInfoInfo;

/**
  * ����: ������Ϣ��ʵ��
  * ��������: ������Ϣ��ʵ��
  * ������¼: 2013/08/05
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="remindInfo")
public class RemindInfoTB extends BaseEntity implements Serializable,
		Cloneable, RemindInfoInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="REMINDINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="REMINDINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="REMINDINFO_TABLE_GENERATOR")
	protected Integer riid;


	/** �û�id */
	protected String riuseid;

	/** ������Ϣ */
	protected String riinfo;

	/** ״̬ */
	protected String ristatus;

	/** �������� */
	protected String ritype;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * �����趨
	 *
	 * @param riid ����
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * �û�idȡ��
	 *
	 * @return �û�id
	 */
	public String getRiuseid() {
		return riuseid;
	}

	/**
	 * �û�id�趨
	 *
	 * @param riuseid �û�id
	 */
	public void setRiuseid(String riuseid) {
		this.riuseid = riuseid;
	}

	/**
	 * ������Ϣȡ��
	 *
	 * @return ������Ϣ
	 */
	public String getRiinfo() {
		return riinfo;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param riinfo ������Ϣ
	 */
	public void setRiinfo(String riinfo) {
		this.riinfo = riinfo;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getRistatus() {
		return ristatus;
	}

	/**
	 * ״̬�趨
	 *
	 * @param ristatus ״̬
	 */
	public void setRistatus(String ristatus) {
		this.ristatus = ristatus;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getRitype() {
		return ritype;
	}

	/**
	 * ���������趨
	 *
	 * @param ritype ��������
	 */
	public void setRitype(String ritype) {
		this.ritype = ritype;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return riid;
	}

}