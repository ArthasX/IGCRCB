/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: SOC0117VWʵ������
  * ��������: SOC0117VWʵ������
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0117VWPK extends BasePK implements Serializable {

	/** ���� */
	protected Integer id;

	/** �ʲ�����id */
	protected String eid;

	/**
	 * ���캯��
	 */
	public SOC0117VWPK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0117VWPK(Integer id, String eid) {
		super();
		this.id = id;
		this.eid = eid;
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
	 * �ʲ�����idȡ��
	 *
	 * @return �ʲ�����id
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * �ʲ�����id�趨
	 *
	 * @param eid �ʲ�����id
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

}