/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: ���̲鿴��ɫ���ñ�ʵ������
  * ��������: ���̲鿴��ɫ���ñ�ʵ������
  * ������¼: 2012/10/15
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class IG700PK extends BasePK implements Serializable {

	/** ���̶���ID */
	protected String pdid;

	/** ��ɫID */
	protected Integer roleid;

	/**
	 * ���캯��
	 */
	public IG700PK() {

	}

	/**
	 * ���캯��
	 */
	public IG700PK(String pdid, Integer roleid) {
		super();
		this.pdid = pdid;
		this.roleid = roleid;
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

}