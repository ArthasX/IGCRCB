/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ���̲鿴��ɫ��Ȩ����ʵ������
  * ��������: ���̲鿴��ɫ��Ȩ����ʵ������
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG701PK extends BasePK implements Serializable {

	/** ���̶���ID */
	protected String pdid;

	/** ��ɫID */
	protected Integer roleid;
	
	/** ��ID */
	protected String pidid;

	/**
	 * ���캯��
	 */
	public IG701PK() {

	}

	/**
	 * ���캯��
	 */
	public IG701PK(String pdid, Integer roleid,String pidid) {
		super();
		this.pdid = pdid;
		this.roleid = roleid;
		this.pidid = pidid;
	}

	/**
	 * ���̶���IDȡ��
	 *
	 * @return ���̶���ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ���̶���ID�趨
	 *
	 * @param pdid ���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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
	
	/**
	 * ��IDȡ��
	 *
	 * @return ��ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ��ID�趨
	 *
	 * @param pidid ��ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

}