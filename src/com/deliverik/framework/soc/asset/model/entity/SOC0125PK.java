package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;
/**
 * ����: �ʲ������ʵ������
 * ��������: �ʲ������ʵ������
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
@SuppressWarnings("serial")
public class SOC0125PK extends BasePK implements Serializable {

	/** ���� */
	protected Integer eiddid;

	/** �汾�� */
	protected Integer version;
	
	/**
	 * ���캯��
	 */
	public SOC0125PK() {

	}
	
	/**
	 * ���캯��
	 */
	public SOC0125PK(Integer eiddid, Integer version) {
		super();
		this.eiddid = eiddid;
		this.version = version;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Integer getEiddid() {
		return eiddid;
	}

	/**
	 * �����趨
	 * @param eiddid����
	 */
	public void setEiddid(Integer eiddid) {
		this.eiddid = eiddid;
	}

	/**
	 * �汾��ȡ��
	 * @return �汾��
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾���趨
	 * @param version�汾��
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
}
