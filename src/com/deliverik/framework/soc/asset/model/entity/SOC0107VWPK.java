/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: SOC0107VWʵ������
  * ��������: SOC0107VWʵ������
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0107VWPK extends BasePK implements Serializable {

	/** ���� */
	protected Integer id;

	/** ���������� */
	protected Integer ciid;

	/**
	 * ���캯��
	 */
	public SOC0107VWPK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0107VWPK(Integer id, Integer ciid) {
		super();
		this.id = id;
		this.ciid = ciid;
	}

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
	public Integer getCiid() {
		return ciid;
	}

	/**
	 * �����������趨
	 *
	 * @param ciid ����������
	 */
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}

}