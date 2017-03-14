/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * ����: �ʲ�����ϸ��ʵ������
 * ��������: �ʲ�����ϸ��ʵ������
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class SOC0126PK extends BasePK implements Serializable {

	/** �ʲ���ID */
	protected Integer eiddid;

	/** �ʲ���汾 */
	protected Integer eiddversion;

	/** �ʲ����� */
	protected String einame;
	
	/** �ʲ�����汾 */
	protected Integer eiImportversion;

	/**
	 * ���캯��
	 */
	public SOC0126PK() {

	}

	/**
	 * ���캯��
	 */
	public SOC0126PK(Integer eiddid, Integer eiddversion, String einame,Integer eiImportversion) {
		super();
		this.eiddid = eiddid;
		this.eiddversion = eiddversion;
		this.einame = einame;
		this.eiImportversion=eiImportversion;
	}

	/**
	 * �ʲ���IDȡ��
	 *
	 * @return �ʲ���ID
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * �ʲ���ID�趨
	 *
	 * @param eiddid�ʲ���ID
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * �ʲ���汾ȡ��
	 *
	 * @return �ʲ���汾
	 */
	public Integer getEiddversion() {
		return eiddversion;
	}

	/**
	 * �ʲ���汾�趨
	 *
	 * @param eiddversion�ʲ���汾
	 */
	public void setEiddversion(Integer eiddversion) {
		this.eiddversion = eiddversion;
	}

		/**
		 * �ʲ�����汾ȡ��
		 * @return�ʲ�����汾
		 */
	public Integer getEiImportversion() {
		return eiImportversion;
	}

	/**
	 * �ʲ�����汾�趨
	 * @param eiImportversion�ʲ�����汾
	 */
	public void setEiImportversion(Integer eiImportversion) {
		this.eiImportversion = eiImportversion;
	}

	public String getEiname() {
		return einame;
	}

	public void setEiname(String einame) {
		this.einame = einame;
	}
}
