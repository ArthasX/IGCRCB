/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: SOC0109VWʵ������
  * ��������: SOC0109VWʵ������
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0109VWPK extends BasePK implements Serializable {

	/** ���� */
	protected Integer id;

	/** �ʲ�ģ������ID                            */
	protected String cid;

	/**
	 * ���캯��
	 */
	public SOC0109VWPK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0109VWPK(Integer id, String cid) {
		super();
		this.id = id;
		this.cid = cid;
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
	 * �ʲ�ģ������ID                           ȡ��
	 *
	 * @return �ʲ�ģ������ID                           
	 */
	public String getCid() {
		return cid;
	}

	/**
	 * �ʲ�ģ������ID                           �趨
	 *
	 * @param cid �ʲ�ģ������ID                           
	 */
	public void setCid(String cid) {
		this.cid = cid;
	}

}