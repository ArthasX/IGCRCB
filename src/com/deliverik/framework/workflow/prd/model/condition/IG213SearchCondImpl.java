/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

import java.io.Serializable;


/**
 * ����״̬��������ʵ��
 *
 */
public class IG213SearchCondImpl implements IG213SearchCond {
	
	/** ����״̬ID */
	protected String prtdid;
	
	/** ��������ID */
	protected String pdid;

	/** ����״̬���� */
	protected String roletype;
	
	/** ����״̬ID */
	protected String prtdid_like;

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

	/**
	 * ����״̬IDȡ��
	 * 
	 * @return ����״̬ID
	 */
	public String getPrtdid_like() {
		return prtdid_like;
	}

	/**
	 * ����״̬ID�趨
	 * 
	 * @param prtdid_like ����״̬ID
	 */
	public void setPrtdid_like(String prtdid_like) {
		this.prtdid_like = prtdid_like;
	}
	
}
