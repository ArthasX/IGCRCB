/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.pdf.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * ����: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ������
  * ��������: �����ֶ������̹��б�ֵӳ���ϵ��ͼʵ������
  * ������¼: 2013/07/31
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
public class PdfIg599MapVWPK extends BasePK implements Serializable {

	/** ����ID */
	protected Integer prid;

	/** ������ID */
	protected String pidid;

	/**
	 * ���캯��
	 */
	public PdfIg599MapVWPK() {

	}

	/**
	 * ���캯��
	 */
	public PdfIg599MapVWPK(Integer prid, String pidid) {
		super();
		this.prid = prid;
		this.pidid = pidid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 *
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������IDȡ��
	 *
	 * @return ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 *
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

}