/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ��Ա����ɫ�޶�ʵ������
  * ��������: ��Ա����ɫ�޶�ʵ������
  * ������¼: 2013/11/27
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG008PK extends BasePK implements Serializable {

	/** ������ID */
	protected String pidid;

	/** ��ɫID */
	protected Integer roleid;

	/**
	 * ���캯��
	 */
	public IG008PK() {

	}

	/**
	 * ���캯��
	 */
	public IG008PK(String pidid, Integer roleid) {
		super();
		this.pidid = pidid;
		this.roleid = roleid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��ɫIDȡ��
	 *
	 * @return ��ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * ��ɫID�趨
	 *
	 * @param roleid ��ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

}