/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: SOC0151VWʵ������
  * ��������: SOC0151VWʵ������
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0151VWPK extends BasePK implements Serializable {

	/** ���� */
	protected Integer id;

	/** ���������� */
	protected Integer ccdid;

	/**
	 * ���캯��
	 */
	public SOC0151VWPK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0151VWPK(Integer id, Integer ccdid) {
		super();
		this.id = id;
		this.ccdid = ccdid;
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

}