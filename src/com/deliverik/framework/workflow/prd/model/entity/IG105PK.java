/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ����: ���̲����趨��Ϣʵ������
 * �������������̲����趨��Ϣʵ������
 * ������¼������ 2010/11/26
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IG105PK extends BasePK implements Serializable{

	/** ���̶���ID */
	protected String pdid;

	/** ����״̬ */
	protected String prstatus;

	/** �����̶� */
	protected String prurgency;
	
	/** ���԰汾 */
	protected Integer psdversion;
	
	/**
	 * ���̲����趨��Ϣʵ���������캯��
	 * 
	 */
	public IG105PK() {
	}

	/**
	 * ���̲����趨��Ϣʵ���������캯��
	 * 
	 * @param pdid���̶���ID
	 * @param prstatus����״̬
	 * @param prurgency�����̶�
	 * @param psdversion���԰汾
	 */
	public IG105PK(String pdid, String prstatus, String prurgency, Integer psdversion) {
		super();
		this.pdid = pdid;
		this.prstatus = prstatus;
		this.prurgency = prurgency;
		this.psdversion = psdversion;
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
	 * @param pdid���̶���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����״̬ȡ��
	 * 
	 * @return ����״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ����״̬�趨
	 * 
	 * @param prstatus����״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �����̶�ȡ��
	 * 
	 * @return �����̶�
	 */
	public String getPrurgency() {
		return prurgency;
	}

	/**
	 * �����̶��趨
	 * 
	 * @param prurgency�����̶�
	 */
	public void setPrurgency(String prurgency) {
		this.prurgency = prurgency;
	}
	
	/**
	 * ���԰汾ȡ��
	 * 
	 * @return ���԰汾
	 */
	public Integer getPsdversion() {
		return psdversion;
	}

	/**
	 * ���԰汾�趨
	 * 
	 * @param psdversion���԰汾
	 */
	public void setPsdversion(Integer psdversion) {
		this.psdversion = psdversion;
	}

}
