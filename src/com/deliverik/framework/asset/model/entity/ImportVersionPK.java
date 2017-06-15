/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �������ݰ汾�����ʵ������
  * ��������: �������ݰ汾�����ʵ������
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class ImportVersionPK extends BasePK implements Serializable {

	/** ����汾 */
	protected Integer impversion;

	/** ʵ���� */
	protected String impeiname;

	/**
	 * ���캯��
	 */
	public ImportVersionPK() {

	}

	/**
	 * ���캯��
	 */
	public ImportVersionPK(Integer impversion, String impeiname) {
		super();
		this.impversion = impversion;
		this.impeiname = impeiname;
		
	}

	/**
	 * ����汾ȡ��
	 *
	 * @return ����汾
	 */
	public Integer getImpversion() {
		return impversion;
	}

	/**
	 * ����汾�趨
	 *
	 * @param impversion����汾
	 */
	public void setImpversion(Integer impversion) {
		this.impversion = impversion;
	}

	/**
	 * ʵ����ȡ��
	 *
	 * @return ʵ����
	 */
	public String getImpeiname() {
		return impeiname;
	}

	/**
	 * ʵ�����趨
	 *
	 * @param impeinameʵ����
	 */
	public void setImpeiname(String impeiname) {
		this.impeiname = impeiname;
	}

}