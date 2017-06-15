/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG213Info;

/**
 * ���̽�ɫ���Ͷ���
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG213")
public class IG213TB extends BaseEntity implements Serializable, Cloneable, IG213Info {
	
	/** ����״̬ID */
	@Id
	protected String prtdid;
	
	/**
	 * ��������ID
	 */
	protected String pdid;

	/**
	 * ����״̬����
	 */
	protected String roletype;

	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return prtdid;
	}
	
	/**
	 * ���̽�ɫ���Ͷ���IDȡ��
	 * @return ���̽�ɫ���Ͷ���ID
	 */
	public String getPrtdid() {
		return prtdid;
	}

	/**
	 * ����״̬ID�趨
	 * @param psdid ����״̬ID
	 */
	public void setPrtdid(String prtdid) {
		this.prtdid = prtdid;
	}

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * ��������ID�趨
	 * @param pdid ��������ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ���̽�ɫ����ȡ��
	 * @return ���̽�ɫ����
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * ���̽�ɫ�����趨
	 * @param psdname ���̽�ɫ����
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	
}
