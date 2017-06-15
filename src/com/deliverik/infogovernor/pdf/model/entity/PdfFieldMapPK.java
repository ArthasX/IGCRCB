/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: PDF���������̱�ӳ���ʵ������
  * ��������: PDF���������̱�ӳ���ʵ������
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class PdfFieldMapPK extends BasePK implements Serializable {

	/** ���̶���ID */
	protected String pdid;

	/** ���̱�����ID */
	protected String pidid;

	/**
	 * ���캯��
	 */
	public PdfFieldMapPK() {

	}

	/**
	 * ���캯��
	 */
	public PdfFieldMapPK(String pdid, String pidid) {
		super();
		this.pdid = pdid;
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
	 * ���̱�����IDȡ��
	 *
	 * @return ���̱�����ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���̱�����ID�趨
	 *
	 * @param pidid ���̱�����ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

}