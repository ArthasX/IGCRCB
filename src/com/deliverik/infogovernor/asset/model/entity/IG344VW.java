/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.asset.model.IG344Info;

/**
  * ����: IG344VWʵ��
  * ��������: IG344VWʵ��
  * ������¼: 2012/07/13
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG344VW implements Serializable, Cloneable, IG344Info {

	/** ���������� */
	protected String einame;
	@Id
	/** �����¼��� */
	protected String eilabel;

	/** �����¼�Ǽ�ʱ�� */
	protected String eiinsdate;

	/** �������� */
	protected String civalue;

	/** �������� */
	protected String civalue1;

	/** �������� */
	protected String civalue2;

	/** �������� */
	protected Double civalue3;

	/**
	 * ����������ȡ��
	 *
	 * @return ����������
	 */
	public String getEiname() {
		return einame;
	}

	/**
	 * �����������趨
	 *
	 * @param einame ����������
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * �����¼���ȡ��
	 *
	 * @return �����¼���
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * �����¼����趨
	 *
	 * @param eilabel �����¼���
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * �����¼�Ǽ�ʱ��ȡ��
	 *
	 * @return �����¼�Ǽ�ʱ��
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * �����¼�Ǽ�ʱ���趨
	 *
	 * @param eiupdtime �����¼�Ǽ�ʱ��
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue() {
		return civalue;
	}

	/**
	 * ���������趨
	 *
	 * @param civalue ��������
	 */
	public void setCivalue(String civalue) {
		this.civalue = civalue;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue1() {
		return civalue1;
	}

	/**
	 * ���������趨
	 *
	 * @param civalue1 ��������
	 */
	public void setCivalue1(String civalue1) {
		this.civalue1 = civalue1;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public String getCivalue2() {
		return civalue2;
	}

	/**
	 * ���������趨
	 *
	 * @param civalue2 ��������
	 */
	public void setCivalue2(String civalue2) {
		this.civalue2 = civalue2;
	}

	/**
	 * ��������ȡ��
	 *
	 * @return ��������
	 */
	public Double getCivalue3() {
		return civalue3;
	}

	/**
	 * ���������趨
	 *
	 * @param civalue3 ��������
	 */
	public void setCivalue3(Double civalue3) {
		this.civalue3 = civalue3;
	}

}