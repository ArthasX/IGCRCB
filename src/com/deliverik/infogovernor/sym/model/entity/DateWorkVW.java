/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.infogovernor.sym.model.DateWorkVWInfo;

/**
 * 
 * �Ӵ�ͳ��ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class DateWorkVW implements Serializable, Cloneable, DateWorkVWInfo {

	@Id
	/** ���� */
	protected String date;
	
	/** �û�ID */
	
	protected String userid;
	
	/** ��ɫID */
	protected String roleid;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	
}
