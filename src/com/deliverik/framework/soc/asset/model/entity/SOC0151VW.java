/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;

/**
  * ����: SOC0151VWʵ��
  * ��������: SOC0151VWʵ��
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0151VWPK.class)
@Table(name="SOC0151VW")
public class SOC0151VW extends BaseEntity implements Serializable,
		Cloneable, SOC0151VWInfo {

	/** ���� */
	@Id
	protected Integer id;

	/** ���������� */
	@Id
	protected Integer ccdid;

	/** �ʲ�ģ������ȡֵ��Χ��ʶ */
	protected String ccdcategory;

	/** �ʲ�ģ������ȡֵ��Χ��ʶ���� */
	protected String ccdlabel;

	/** �ʲ�ģ������ȡֵ��Χֵ */
	protected String ccdvalue;

	/** �ʲ�ģ������ȡֵ��Χ״̬ */
	protected String ccdstatus;

	/** �ʲ�ģ������ȡֵ��Χ����Ӧ�� */
	protected String ccdtype;

	/** �ʲ�ģ������ȡֵ��ΧԤ���ֶ� */
	protected String ccdinfo;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public Integer getCcdid() {
		return ccdid;
	}

	/**
	 * �����������趨
	 *
	 * @param ccdid ����������
	 */
	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public String getCcdcategory() {
		return ccdcategory;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ�趨
	 *
	 * @param ccdcategory �ʲ�ģ������ȡֵ��Χ��ʶ
	 */
	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ����ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public String getCcdlabel() {
		return ccdlabel;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ��ʶ�����趨
	 *
	 * @param ccdlabel �ʲ�ģ������ȡֵ��Χ��ʶ����
	 */
	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χֵȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χֵ
	 */
	public String getCcdvalue() {
		return ccdvalue;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χֵ�趨
	 *
	 * @param ccdvalue �ʲ�ģ������ȡֵ��Χֵ
	 */
	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public String getCcdstatus() {
		return ccdstatus;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ״̬�趨
	 *
	 * @param ccdstatus �ʲ�ģ������ȡֵ��Χ״̬
	 */
	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ��ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public String getCcdtype() {
		return ccdtype;
	}

	/**
	 * �ʲ�ģ������ȡֵ��Χ����Ӧ���趨
	 *
	 * @param ccdtype �ʲ�ģ������ȡֵ��Χ����Ӧ��
	 */
	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ�ȡ��
	 *
	 * @return �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public String getCcdinfo() {
		return ccdinfo;
	}

	/**
	 * �ʲ�ģ������ȡֵ��ΧԤ���ֶ��趨
	 *
	 * @param ccdinfo �ʲ�ģ������ȡֵ��ΧԤ���ֶ�
	 */
	public void setCcdinfo(String ccdinfo) {
		this.ccdinfo = ccdinfo;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return new SOC0151VWPK(id, ccdid);
	}

}