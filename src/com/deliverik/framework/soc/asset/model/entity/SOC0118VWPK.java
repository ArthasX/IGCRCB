/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: SOC0118VWʵ������
  * ��������: SOC0118VWʵ������
  * ������¼: 2016/06/21
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class SOC0118VWPK extends BasePK implements Serializable {

	/** ���� */
	protected Integer id;

	/** �ʲ�ID                   */
	protected Integer eiid;

	/**
	 * ���캯��
	 */
	public SOC0118VWPK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0118VWPK(Integer id, Integer eiid) {
		super();
		this.id = id;
		this.eiid = eiid;
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
	 * �ʲ�ID                  ȡ��
	 *
	 * @return �ʲ�ID                  
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * �ʲ�ID                  �趨
	 *
	 * @param eiid �ʲ�ID                  
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

}