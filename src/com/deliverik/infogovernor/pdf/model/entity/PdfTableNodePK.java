/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: PDF����XML�б��ʽ���ڵ㶨���ʵ������
  * ��������: PDF����XML�б��ʽ���ڵ㶨���ʵ������
  * ������¼: 2013/08/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class PdfTableNodePK extends BasePK implements Serializable {

	/** ���̶���ID */
	protected String pdid;

	/** ������ */
	protected String databinding;

	/**
	 * ���캯��
	 */
	public PdfTableNodePK() {

	}

	/**
	 * ���캯��
	 */
	public PdfTableNodePK(String pdid, String databinding) {
		super();
		this.pdid = pdid;
		this.databinding = databinding;
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
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getDatabinding() {
		return databinding;
	}

	/**
	 * �������趨
	 *
	 * @param databinding ������
	 */
	public void setDatabinding(String databinding) {
		this.databinding = databinding;
	}

}