/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �ʲ�ģ������ȱʡֵʵ������
  * ��������: �ʲ�ģ������ȱʡֵʵ������
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG611PK extends BasePK implements Serializable {

	/** ģ��ID */
	protected Integer eid;

	/** ����ID */
	protected Integer cid;

	/**
	 * ���캯��
	 */
	public IG611PK() {

	}

	/**
	 * ���캯��
	 */
	public IG611PK(Integer eid, Integer cid) {
		super();
		this.eid = eid;
		this.cid = cid;
	}

	/**
	 * ģ��IDȡ��
	 *
	 * @return ģ��ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * ģ��ID�趨
	 *
	 * @param eid ģ��ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param cid ����ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
	}

}