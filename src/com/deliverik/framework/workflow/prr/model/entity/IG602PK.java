/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ����: ����ִ������Ϣʵ������
 * ��������: ����ִ������Ϣʵ������
 * ������¼: 2012/04/11
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class IG602PK extends BasePK implements Serializable {

	/** �û�ID */
	protected String userid;

	/** �û���ɫID */
	protected Integer roleid;
	
	/**
	 * �û�IDȡ��
	 * @return �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 *
	 * @param userid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * �û���ɫIDȡ��
	 * @return �û���ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �û���ɫID�趨
	 *
	 * @param roleid �û���ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public IG602PK(){}
	
	public IG602PK(String userid, Integer roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}
}
